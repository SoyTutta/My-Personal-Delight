package com.soytutta.mypersonaldelight.common.block;

import com.soytutta.mypersonaldelight.common.utility.MPDTextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.ItemUtils;

import java.util.function.Supplier;

public class SnowGolemFeastBlock extends PieBlock {
    public static final BooleanProperty PUMPKIN = BooleanProperty.create("pumpkin");
    public static final IntegerProperty FACE = IntegerProperty.create("face", 0, 11);
    private final Supplier<Item> IceCreamContainer;

    public SnowGolemFeastBlock(Properties properties, Supplier<Item> pieSlice, Supplier<Item> IceCreamContainer) {
        super(properties, pieSlice);
        this.IceCreamContainer = IceCreamContainer;

        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(BITES, 0).setValue(PUMPKIN,true).setValue(FACE, 1));
    }

    protected static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 10.0D, 14.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D)
    };

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(BITES)];
    }

    public ItemStack getIceContainerItem(BlockState state) {
        return new ItemStack(this.IceCreamContainer.get());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        int randomFace = context.getLevel().getRandom().nextInt(12);
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(FACE, randomFace);
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (heldStack.is(ModTags.KNIVES)) {
            return this.cutSlice(level, pos, state, player);
        }
        if (heldStack.is(net.neoforged.neoforge.common.Tags.Items.TOOLS_SHEAR)) {
            return this.chopPumpkin(level, pos, state, player);
        }
        if (player.isShiftKeyDown() && heldStack.getItem() == this.IceCreamContainer.get()) {
            return this.cutSlice(level, pos, state, player);
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        ItemStack iceCreamContainer = this.getIceContainerItem(state);
        ItemStack heldStack = player.getItemInHand(InteractionHand.MAIN_HAND);

        if (heldStack.is(Items.FLINT)) {
            return this.faceRotate(level, pos, state);
        }

        if (state.getValue(PUMPKIN)) {
            if (level.isClientSide) {
                if (this.consumeBite(level, pos, state, player).consumesAction()) {
                    return InteractionResult.SUCCESS;
                }
                if (heldStack.isEmpty()) {
                    return InteractionResult.CONSUME;
                }
            }
            return this.consumeBite(level, pos, state, player);
        } else if (heldStack.getItem() == this.IceCreamContainer.get()){
            if (this.consumeBitePumpkin(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
        } else {
            player.displayClientMessage(MPDTextUtils.getTranslation(
                    "block.snowgolemfeast.use_container",
                    iceCreamContainer.getHoverName()), true);
        }
        return InteractionResult.FAIL;
    }

    protected InteractionResult faceRotate(Level level, BlockPos pos, BlockState state) {
        int maxFace = FACE.getPossibleValues().size() - 1;
        int nextFace = (state.getValue(FACE) + 1) % (maxFace + 1);

        level.setBlock(pos, state.setValue(FACE, nextFace), Block.UPDATE_CLIENTS);
        level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_LEATHER.value(), SoundSource.PLAYERS, 0.8F, 0.8F);

        return InteractionResult.SUCCESS;
    }

    protected InteractionResult consumeBitePumpkin(Level level, BlockPos pos, BlockState state, Player playerIn) {
        ItemStack heldStack = playerIn.getItemInHand(InteractionHand.MAIN_HAND);
        if (!playerIn.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            if (heldStack.getItem() == this.IceCreamContainer.get()) {
                heldStack.shrink(1);
            }
            ItemStack sliceStack = this.getPieSliceItem();
            FoodProperties sliceFood = sliceStack.getItem().getFoodProperties(sliceStack, playerIn);
            if (sliceFood != null) {
                playerIn.getFoodData().eat(sliceFood);

                for(FoodProperties.PossibleEffect effect : sliceFood.effects()) {
                    if (!level.isClientSide && effect != null && level.random.nextFloat() < effect.probability()) {
                        playerIn.addEffect(effect.effect());
                    }
                }
            }

            int bites = state.getValue(BITES);
            if (bites < this.getMaxBites() - 1) {
                level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
            } else {
                level.removeBlock(pos, false);
            }

            level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
            return InteractionResult.SUCCESS;
        }
    }

    protected ItemInteractionResult chopPumpkin(Level level, BlockPos pos, BlockState state, Player player) {
        int bites = this.getMaxBites() - state.getValue(BITES);
        if (state.getValue(PUMPKIN)) {
            level.setBlock(pos, state.setValue(PUMPKIN, false), 3);
            Direction direction = player.getDirection().getOpposite();
            for (int i = 0; i < bites; i++) {
                ItemUtils.spawnItemEntity(level, ModItems.PUMPKIN_SLICE.get().getDefaultInstance(), (double)pos.getX() + (double)0.5F, (double)pos.getY() + 0.3, (double)pos.getZ() + (double)0.5F, (double)direction.getStepX() * 0.15, 0.05, (double)direction.getStepZ() * 0.15);
            }
            level.playSound(null, pos, SoundEvents.PUMPKIN_CARVE, SoundSource.PLAYERS, 0.8F, 0.8F);
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.FAIL;
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(PUMPKIN, FACE);
    }
}