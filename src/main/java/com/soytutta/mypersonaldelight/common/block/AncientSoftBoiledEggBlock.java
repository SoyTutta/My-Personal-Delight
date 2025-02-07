package com.soytutta.mypersonaldelight.common.block;

import com.soytutta.mypersonaldelight.common.utility.MPDTextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.function.Supplier;

public class AncientSoftBoiledEggBlock extends TwofoldFeastBlock{

    public AncientSoftBoiledEggBlock(Properties properties, Supplier<Item> altServingOneItem, int altServingOneCount, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, altServingOneItem, altServingOneCount, servingItem, hasLeftovers);
    }

    @Override
    protected ItemStack determineServing(ItemStack servingOne, ItemStack servingTwo, BlockPos pos, BlockState state, Player player) {
        ItemStack itemInHand = player.getMainHandItem();
        if (itemInHand.is(ModTags.KNIVES)) {
            return servingTwo;
        }
        return servingOne;
    }

    @Override
    public void displayUseContainerMessage(BlockState state, Player player, ItemStack selectedServing) {
        player.displayClientMessage(MPDTextUtils.getTranslation("block.feast.use_alt_container", selectedServing.getCraftingRemainingItem().getHoverName(), MPDTextUtils.getTranslation("block.feast.need_knives")), true);
    }
}
