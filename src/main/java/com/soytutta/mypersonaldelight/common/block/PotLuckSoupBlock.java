package com.soytutta.mypersonaldelight.common.block;

import com.soytutta.mypersonaldelight.common.tag.MyCommonTags;
import com.soytutta.mypersonaldelight.common.utility.MPDTextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class PotLuckSoupBlock extends ThreefoldFeastBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final BooleanProperty ROOF = BooleanProperty.create("roof");
    public static final BooleanProperty SUPPORT = BooleanProperty.create("support");
    public static final BooleanProperty FIRST = BooleanProperty.create("first_serving");
    public static final IntegerProperty MEAT = IntegerProperty.create("meat", 0, 4);
    public static final IntegerProperty VEGGIES = IntegerProperty.create("veggies", 0, 4);
    public static final BooleanProperty TAIL = BooleanProperty.create("tail");
    public static final BooleanProperty VALANCE = BooleanProperty.create("valance");

    public PotLuckSoupBlock(Properties properties, Supplier<Item> altServingOneItem, int altServingOneCount, Supplier<Item> altServingTwoItem, int altServingTwoCount, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, altServingOneItem, altServingOneCount, altServingTwoItem, altServingTwoCount, servingItem, hasLeftovers);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(getServingsProperty(), getMaxServings()).setValue(getMeatProperty(), getMaxMeat()).setValue(getVeggiesProperty(), getMaxVeggies()).setValue(TAIL,true).setValue(FIRST,true).setValue(ROOF,false).setValue(SUPPORT,false));
    }

    protected static final VoxelShape HEADSHAPES = Stream.of( Block.box(2, 1.5, 2, 14, 3.5, 14), Block.box(0, 3.5, 2, 2, 15.5, 14), Block.box(14, 3.5, 2, 16, 15.5, 14), Block.box(2, 3.5, 0, 14, 15.5, 2), Block.box(2, 3.5, 14, 14, 15.5, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    protected static final VoxelShape[] SOUPSHAPES = new VoxelShape[]{
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 9.0D, 14.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D)
    };

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape servingsShape = SOUPSHAPES[state.getValue(SERVINGS)];
        return Shapes.or(HEADSHAPES, servingsShape);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return true;
    }

    private static boolean isHeated(LevelReader level, BlockPos pos) {
        BlockPos posBelow = pos.below();
        BlockState blockStateBelow = level.getBlockState(posBelow);

        if (blockStateBelow.is(ModTags.HEAT_SOURCES)) {
            if (blockStateBelow.hasProperty(BlockStateProperties.LIT)) {
                return blockStateBelow.getValue(BlockStateProperties.LIT);
            }
            return true;
        }

        return false;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        adjustBlockState(level, pos, state);
        super.tick(state, level, pos, random);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState offsetState, LevelAccessor level, BlockPos pos, BlockPos offsetPos) {
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            serverLevel.scheduleTick(pos, this, 1);
        }
        boolean blockAboveFree = isEmptyOrWater(level.getBlockState(pos.above()));
        boolean blockWestFree = isEmptyOrWater(level.getBlockState(pos.relative(state.getValue(FACING).getCounterClockWise())));
        BlockState blockStateBelow = level.getBlockState(pos.below());
        boolean hasHeatSourceBelow = blockStateBelow.is(ModTags.TRAY_HEAT_SOURCES);

        return super.updateShape(
                state.setValue(ROOF, !(blockAboveFree && blockWestFree))
                        .setValue(SUPPORT, hasHeatSourceBelow),
                direction, offsetState, level, pos, offsetPos
        );
    }

    private boolean isEmptyOrWater(BlockState state) {
        return state.is(Blocks.AIR) || state.getFluidState().is(FluidTags.WATER);
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            serverLevel.scheduleTick(pos, this, 1);
        }
        int meat = state.getValue(MEAT);
        int veggies = state.getValue(VEGGIES);
        int servings = state.getValue(getServingsProperty());

        if (!level.isClientSide()) {
            boolean isProcessed = false;

            if (!isHeated(level, pos) && (heldStack.is(MyCommonTags.ANY_GUARDIAN_MEATS) || heldStack.is(CommonTags.FOODS_TOMATO) || heldStack.is(CommonTags.FOODS_ONION))) {
                player.displayClientMessage(MPDTextUtils.getTranslation("block.needheat.use_container"), true);
                isProcessed = true;
            }

            if (heldStack.is(MyCommonTags.ANY_GUARDIAN_MEATS) && meat < getMaxMeat() && isHeated(level, pos)) {
                int increment = heldStack.is(MyCommonTags.ANY_GUARDIAN_TAILS) ? getMaxMeat() : meat + 1;
                state = addIngredient(player, state, pos, MEAT, heldStack, increment, level);
            } else if ((heldStack.is(CommonTags.FOODS_TOMATO) || heldStack.is(CommonTags.FOODS_ONION)) && veggies < getMaxVeggies() && isHeated(level, pos)) {
                int increment = (veggies <= getMaxVeggies() - 2) ? 2 : 1;
                state = addIngredient(player, state, pos, VEGGIES, heldStack, veggies + increment, level);
                isProcessed = true;
            }

            if (isProcessed) {
                level.playSound(null, pos, SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }

            if (heldStack.get(DataComponents.POTION_CONTENTS) != null && heldStack.get(DataComponents.POTION_CONTENTS).is(Potions.WATER)) {
                level.setBlockAndUpdate(pos, state.setValue(getServingsProperty(), servings + 1)
                        .setValue(VALANCE, (servings + 1) <= state.getValue(VEGGIES)));

                if (!player.getAbilities().instabuild) {
                    heldStack.shrink(1);
                    player.setItemInHand(hand, new ItemStack(Items.GLASS_BOTTLE));
                }

                level.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
        }
        return super.useItemOn(heldStack, state, level, pos, player, hand, hit);
    }

    private BlockState addIngredient(Player player, BlockState state, BlockPos pos, IntegerProperty property, ItemStack heldStack, int newValue, LevelAccessor level) {
        BlockState newState = state.setValue(property, newValue);
        newState = newState.setValue(VALANCE, newState.getValue(getServingsProperty()) <= newState.getValue(VEGGIES));
        level.setBlock(pos, newState, 3);

        if (!player.getAbilities().instabuild) {
            heldStack.shrink(1);
        }

        return newState;
    }

    @Override
    protected ItemInteractionResult takeServing(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getServingsProperty());
        int meat = state.getValue(getMeatProperty());
        int veggies = state.getValue(getVeggiesProperty());

        ItemStack servingOne = this.getaltServingOneItem(state);
        ItemStack servingTwo = this.getaltServingTwoItem(state);
        ItemStack servingThree = this.getServingItem(state);

        if (servings > 0) {
            if (state.getValue(VALANCE)) {
                ItemStack selectedServing = determineServing(servingOne, servingTwo, servingThree, pos, state, player);

                if (selectedServing != null && processServing(level, pos, state, player, hand, selectedServing, servings)) {
                    BlockState newState = state;

                    if (state.getValue(FIRST)) newState = newState.setValue(FIRST, false);
                    if (meat > 0) newState = newState.setValue(getMeatProperty(), meat - 1);
                    if (veggies > 0) newState = newState.setValue(getVeggiesProperty(), veggies - 1);
                    if (meat == 0 && state.getValue(TAIL)) newState = newState.setValue(TAIL, false);

                    newState = newState.setValue(this.getServingsProperty(), servings - 1);
                    level.setBlock(pos, newState, 3);


                    return ItemInteractionResult.SUCCESS;
                }
            }
        }

        if (veggies > 0 && !(meat > 0 || state.getValue(TAIL))) {
            player.displayClientMessage(MPDTextUtils.getTranslation("block.veggies_excess.use_container"), true);
        } else if (!(veggies >= servings)) {
            player.displayClientMessage(MPDTextUtils.getTranslation("block.meat_excess.use_container"), true);
        } else if ((state.getValue(VALANCE)) && servings == 0) {
            player.displayClientMessage(MPDTextUtils.getTranslation("block.tasteless.use_container"), true);
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected ItemStack determineServing(ItemStack servingOne, ItemStack servingTwo, ItemStack servingThree, BlockPos pos, BlockState state, Player player) {
        int meat = state.getValue(getMeatProperty());
        int veggies = state.getValue(getVeggiesProperty());
        boolean hasTail = state.getValue(TAIL);

        if (state.getValue(FIRST)) {
            return servingOne;
        }
        if (meat == 0 && veggies > 0 && hasTail) {
            return servingThree;
        }
        if (meat > 0 && veggies > 0) {
            return servingTwo;
        }
        return null;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    private void adjustBlockState(LevelAccessor level, BlockPos pos, BlockState state) {
        if (state.getValue(WATERLOGGED) && state.getValue(getServingsProperty()) < getMaxServings()) {
            level.setBlock(pos, state.setValue(getServingsProperty(), getMaxServings())
                    .setValue(WATERLOGGED, false)
                    .setValue(VALANCE, getMaxServings() == state.getValue(VEGGIES)), 3);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        if (isHeated(level, pos)) {
            int servings = state.getValue(getServingsProperty());
            double baseHeight = SOUPSHAPES[servings].bounds().maxY + pos.getY();

            if (random.nextFloat() < 0.2F) {
                double x = (double) pos.getX() + 0.5 + (random.nextDouble() * 0.6 - 0.3);
                double y = baseHeight + 0.2;
                double z = (double) pos.getZ() + 0.5 + (random.nextDouble() * 0.6 - 0.3);
                level.addParticle(ParticleTypes.BUBBLE_POP, x, y, z, 0.0, 0.0, 0.0);
            }

            if (random.nextFloat() < 0.05F) {
                double x = (double) pos.getX() + 0.5 + (random.nextDouble() * 0.4 - 0.2);
                double y = baseHeight + 0.1;
                double z = (double) pos.getZ() + 0.5 + (random.nextDouble() * 0.4 - 0.2);
                double motionY = random.nextBoolean() ? 0.015 : 0.005;
                level.addParticle(ModParticleTypes.STEAM.get(), x, y, z, 0.0, motionY, 0.0);
            }
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ROOF, SUPPORT, FIRST, MEAT, TAIL, VEGGIES, VALANCE, WATERLOGGED);
    }

    public IntegerProperty getMeatProperty() {
        return MEAT;
    }

    public int getMaxMeat() {
        return 4;
    }

    public IntegerProperty getVeggiesProperty() {
        return VEGGIES;
    }

    public int getMaxVeggies() {
        return 4;
    }

}
