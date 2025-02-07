package com.soytutta.mypersonaldelight.common.block;

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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.function.Supplier;

public class PotatoAndMeatPieBlock extends FeastBlock {
    public static final IntegerProperty EXTRASERVINGS = IntegerProperty.create("extraservings", 0, 2);

    public PotatoAndMeatPieBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);

        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(getServingsProperty(), getMaxServings()).setValue(getExtraServingsProperty(), getMaxExtraServings()));
    }

    public IntegerProperty getExtraServingsProperty() {
        return EXTRASERVINGS;
    }

    public int getMaxExtraServings() {
        return 2;
    }

    @Override
    protected ItemInteractionResult takeServing(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getExtraServingsProperty());

        ItemStack serving = this.getServingItem(state);
        ItemStack heldStack = player.getItemInHand(hand);

        if (servings > 0) {
            if (!serving.hasCraftingRemainingItem() || ItemStack.isSameItem(heldStack, serving.getCraftingRemainingItem())) {
                level.setBlock(pos, state.setValue(getExtraServingsProperty(), servings - 1), 3);
                if (!player.getAbilities().instabuild && serving.hasCraftingRemainingItem()) {
                    heldStack.shrink(1);
                }
                if (!player.getInventory().add(serving)) {
                    player.drop(serving, false);
                }
                if (level.getBlockState(pos).getValue(getExtraServingsProperty()) == 0 && !this.hasLeftovers) {
                    level.removeBlock(pos, false);
                }
                level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
                return ItemInteractionResult.SUCCESS;
            }
        } else {
            return super.takeServing(level, pos, state, player, hand);
        }
        player.displayClientMessage(TextUtils.getTranslation("block.feast.use_container",serving.getCraftingRemainingItem().getHoverName()), true);

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
        return (blockState.getValue(this.getServingsProperty()) + blockState.getValue(this.getExtraServingsProperty()));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS, EXTRASERVINGS);
    }
}
