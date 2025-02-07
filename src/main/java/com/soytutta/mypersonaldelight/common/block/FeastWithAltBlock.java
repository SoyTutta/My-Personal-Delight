package com.soytutta.mypersonaldelight.common.block;


import java.util.function.Supplier;

import com.soytutta.mypersonaldelight.common.utility.MPDTextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.common.block.FeastBlock;
import net.minecraft.tags.TagKey;

public class FeastWithAltBlock extends FeastBlock {
    private final Supplier<Item> altServingItem;
    private final Supplier<Item> altContainerShow;
    private final Object altContainer;

    public FeastWithAltBlock(BlockBehaviour.Properties properties, Supplier<Item> servingItem, boolean hasLeftovers, Supplier<Item> altServingItem, Supplier<Item> altContainerShow, Object altContainer) {
        super(properties, servingItem, hasLeftovers);
        this.altServingItem = altServingItem;
        this.altContainerShow = altContainerShow;
        this.altContainer = altContainer;
    }

    public ItemStack getServingAltItem(BlockState state) {
        return new ItemStack(this.altServingItem.get());
    }

    public ItemStack getAltContainerItem(BlockState state) {
        return new ItemStack(this.altContainerShow.get());
    }

    @Override
    protected ItemInteractionResult takeServing(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getServingsProperty());

        if (servings == 0) {
            level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.destroyBlock(pos, true);
            return ItemInteractionResult.SUCCESS;
        }

        ItemStack serving = this.getServingItem(state);
        ItemStack servingAlt = this.getServingAltItem(state);
        ItemStack altcontainerShow = this.getAltContainerItem(state);
        ItemStack heldStack = player.getItemInHand(hand);

        if (servings > 0) {
            if (heldStack.getItem() == altContainer || heldStack.is((TagKey<Item>) altContainer)){
                if (!servingAlt.hasCraftingRemainingItem() || ItemStack.isSameItem(heldStack, servingAlt.getCraftingRemainingItem())) {
                    level.setBlock(pos, state.setValue(this.getServingsProperty(), servings - 1), 3);
                    level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (heldStack.is(Tags.Items.TOOLS)) {
                        if (!player.getInventory().add(servingAlt)) {
                            player.drop(servingAlt, false);
                        }
                        if (level.getBlockState(pos).getValue(this.getServingsProperty()) == 0 && !this.hasLeftovers) {
                            level.removeBlock(pos, false);
                        }
                        return ItemInteractionResult.SUCCESS;
                    }
                    if (!player.getAbilities().instabuild && servingAlt.hasCraftingRemainingItem()) {
                        heldStack.shrink(1);
                    }
                    if (!player.getInventory().add(servingAlt)) {
                        player.drop(servingAlt, false);
                    }
                    if (level.getBlockState(pos).getValue(this.getServingsProperty()) == 0 && !this.hasLeftovers) {
                        level.removeBlock(pos, false);
                    }
                    return ItemInteractionResult.SUCCESS;
                }
            } else if (!serving.hasCraftingRemainingItem() || ItemStack.isSameItem(heldStack, serving.getCraftingRemainingItem())) {
                level.setBlock(pos, state.setValue(getServingsProperty(), servings - 1), 3);
                if (!player.getAbilities().instabuild && serving.hasCraftingRemainingItem()) {
                    heldStack.shrink(1);
                }
                if (!player.getInventory().add(serving)) {
                    player.drop(serving, false);
                }
                if (level.getBlockState(pos).getValue(getServingsProperty()) == 0 && !this.hasLeftovers) {
                    level.removeBlock(pos, false);
                }
                level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
                return ItemInteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(MPDTextUtils.getTranslation(
                        "block.feastalt.use_container",
                        serving.getCraftingRemainingItem().getHoverName(),
                        altcontainerShow.getHoverName()), true);
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}