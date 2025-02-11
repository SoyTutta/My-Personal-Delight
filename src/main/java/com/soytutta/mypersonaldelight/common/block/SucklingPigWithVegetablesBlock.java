package com.soytutta.mypersonaldelight.common.block;

import com.soytutta.mypersonaldelight.common.utility.MPDTextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.DoubleBlockCombiner.BlockType;
import net.minecraft.world.level.material.PushReaction;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class SucklingPigWithVegetablesBlock extends ThreefoldFeastBlock{
    public static final IntegerProperty EXTRASERVINGS = IntegerProperty.create("extraservings", 0, 1);
    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;

    public SucklingPigWithVegetablesBlock(Properties properties, Supplier<Item> altServingOneItem, int altServingOneCount, Supplier<Item> altServingTwoItem, int altServingTwoCount, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, altServingOneItem, altServingOneCount, altServingTwoItem, altServingTwoCount, servingItem, hasLeftovers);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, BedPart.HEAD).setValue(FACING, Direction.NORTH).setValue(getServingsProperty(), getMaxServings()).setValue(getExtraServingsProperty(), 1));
    }

    private static Direction getDirectionToOther(BedPart part, Direction direction) {
        return part == BedPart.HEAD ? direction : direction.getOpposite();
    }

    @Override
    @SuppressWarnings("deprecation")
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing != getDirectionToOther(stateIn.getValue(PART), stateIn.getValue(FACING))) {
            return !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        } else {
            return stateIn.canSurvive(worldIn, currentPos) && facingState.is(this) && facingState.getValue(PART) != stateIn.getValue(PART) ? stateIn : Blocks.AIR.defaultBlockState();
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && player.isCreative()) {
            BedPart bedpart = state.getValue(PART);

            if (bedpart == BedPart.FOOT) {
                BlockPos blockpos = pos.relative(getDirectionToOther(bedpart, state.getValue(FACING)));
                BlockState blockstate = level.getBlockState(blockpos);

                if (blockstate.is(this) && blockstate.getValue(PART) == BedPart.HEAD) {
                    level.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                    level.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
                }
            }
        }

        super.playerWillDestroy(level, pos, state, player);
        return state;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection();
        BlockPos clickedPos = context.getClickedPos();
        BlockPos adjacentPos = clickedPos.relative(direction);
        Level level = context.getLevel();

        if (level.getBlockState(adjacentPos).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(adjacentPos)) {
            if (canSurvive(level.getBlockState(adjacentPos), level, adjacentPos) &&
                    canSurvive(this.defaultBlockState(), level, clickedPos)) {
                return this.defaultBlockState().setValue(FACING, direction);
            }
        }
        Player player = context.getPlayer();
        if (player != null) {
            player.displayClientMessage(MPDTextUtils.getTranslation("block.feast.space_required"), true);
        }
        return null;
    }

    @Override
    @SuppressWarnings("deprecation")
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(worldIn, pos, state, placer, stack);
        if (!worldIn.isClientSide) {
            BlockPos facingPos = pos.relative(state.getValue(FACING));
            worldIn.setBlock(facingPos, state.setValue(PART, BedPart.FOOT), 3);
            worldIn.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(worldIn, pos, 3);
        }
    }

    public static DoubleBlockCombiner.BlockType getBlockType(BlockState state) {
        BedPart bedpart = state.getValue(PART);
        return bedpart == BedPart.FOOT ? BlockType.FIRST : BlockType.SECOND;
    }

    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
        return blockState.getValue(this.getServingsProperty()) + blockState.getValue(this.getExtraServingsProperty());
    }

    public IntegerProperty getExtraServingsProperty() {
        return EXTRASERVINGS;
    }

    @Override
    protected ItemInteractionResult takeServing(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getServingsProperty());
        int Extraservings = state.getValue(getExtraServingsProperty());

        if (servings == 0) {
            level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.destroyBlock(pos, true);
            return ItemInteractionResult.SUCCESS;
        }

        ItemStack servingOne = this.getaltServingOneItem(state);
        ItemStack servingTwo = this.getaltServingTwoItem(state);
        ItemStack servingThree = this.getServingItem(state);

        if (Extraservings > 0) {
            ItemStack selectedServing = determineServing(servingOne, servingTwo, servingThree, pos, state, player);
            if (selectedServing != null && processServing(level, pos, state, player, hand, selectedServing, Extraservings)) {
                BlockPos pairPos = pos.relative(getDirectionToOther(state.getValue(PART), state.getValue(FACING)));
                BlockState pairState = level.getBlockState(pairPos);
                level.setBlock(pos, state.setValue(this.getExtraServingsProperty(), Extraservings - 1), 3);
                if (pairState.is(this)) {
                    level.setBlock(pairPos, pairState.setValue(this.getExtraServingsProperty(), Extraservings - 1), 3);
                }
                return ItemInteractionResult.SUCCESS;
            }
        } else if (servings > 0) {
            ItemStack selectedServing = determineServing(servingOne, servingTwo, servingThree, pos, state, player);
            if (selectedServing != null && processServing(level, pos, state, player, hand, selectedServing, servings)) {
                BlockPos pairPos = pos.relative(getDirectionToOther(state.getValue(PART), state.getValue(FACING)));
                BlockState pairState = level.getBlockState(pairPos);

                level.setBlock(pos, state.setValue(this.getServingsProperty(), servings - 1), 3);
                if (pairState.is(this)) {
                    level.setBlock(pairPos, pairState.setValue(this.getServingsProperty(), servings - 1), 3);
                }

                return ItemInteractionResult.SUCCESS;
            }
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected ItemStack determineServing(ItemStack servingOne, ItemStack servingTwo, ItemStack servingThree, BlockPos pos, BlockState state, Player player) {
        int maxServings = getMaxServings();
        int servings = state.getValue(getServingsProperty());
        int extraservings = state.getValue(getExtraServingsProperty());

        if (extraservings > 0) {
            return servingOne;
        }
        if (servings > (maxServings - altServingTwoCount)) {
            return servingThree;
        }
        return servingTwo;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS, EXTRASERVINGS, PART);
    }
}
