package com.soytutta.mypersonaldelight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.function.Supplier;

public class ThreefoldFeastBlock extends FeastBlock {
    public final Supplier<Item> altServingOneItem;
    public final int altServingOneCount;
    public final Supplier<Item> altServingTwoItem;
    public final int altServingTwoCount;

    public ThreefoldFeastBlock(Properties properties, Supplier<Item> altServingOneItem, int altServingOneCount, Supplier<Item> altServingTwoItem, int altServingTwoCount, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
        this.altServingOneItem = altServingOneItem;
        this.altServingOneCount = altServingOneCount;
        this.altServingTwoItem = altServingTwoItem;
        this.altServingTwoCount = altServingTwoCount;
    }

    public ItemStack getaltServingOneItem(BlockState state) {
        return new ItemStack(this.altServingOneItem.get());
    }

    public ItemStack getaltServingTwoItem(BlockState state) {
        return new ItemStack(this.altServingTwoItem.get());
    }

    @Override
    protected ItemInteractionResult takeServing(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getServingsProperty());

        if (servings == 0) {
            level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.destroyBlock(pos, true);
            return ItemInteractionResult.SUCCESS;
        }
        ItemStack servingOne = this.getaltServingOneItem(state);
        ItemStack servingTwo = this.getaltServingTwoItem(state);
        ItemStack servingThree = this.getServingItem(state);

        if (servings > 0) {
            ItemStack selectedServing = determineServing(servingOne, servingTwo, servingThree, pos, state);
            if (selectedServing != null) {
                processServing(level, pos, state, player, hand, selectedServing, servings);
              if (processServing(level, pos, state, player, hand, selectedServing, servings)) {
                  level.setBlock(pos, state.setValue(this.getServingsProperty(), servings - 1), 3);
                  return ItemInteractionResult.SUCCESS;
              }
            }
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    boolean processServing(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand, ItemStack selectedServing, int servings) {
        ItemStack heldStack = player.getItemInHand(hand);
        if (!selectedServing.hasCraftingRemainingItem() || ItemStack.isSameItem(heldStack, selectedServing.getCraftingRemainingItem())) {
            if (!player.getAbilities().instabuild && selectedServing.hasCraftingRemainingItem()) {
                heldStack.shrink(1);
            }
            if (!player.getInventory().add(selectedServing)) {
                player.drop(selectedServing, false);
            }

            if (level.getBlockState(pos).getValue(this.getServingsProperty()) == 0 && !this.hasLeftovers) {
                level.removeBlock(pos, false);
            }

            level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
            return true;
        } else {
            player.displayClientMessage(TextUtils.getTranslation("block.feast.use_container", selectedServing.getCraftingRemainingItem().getHoverName()), true);
            return false;
        }
    }

    protected ItemStack determineServing(ItemStack servingOne, ItemStack servingTwo, ItemStack servingThree, BlockPos pos, BlockState state) {
        int maxServings = getMaxServings();
        int servings = state.getValue(getServingsProperty());
        if (servings > (maxServings - altServingOneCount)) {
            return servingOne;
        }
        if (servings > (maxServings - (altServingOneCount + altServingTwoCount))) {
            return servingTwo;
        }
        return servingThree;
    }

}
