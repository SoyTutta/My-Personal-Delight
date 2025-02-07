package com.soytutta.mypersonaldelight.common.block;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class AncientSoftBoiledEggBlock extends FeastWithAltBlock{
    public AncientSoftBoiledEggBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers, Supplier<Item> altServingItem, Supplier<Item> altContainerShow, Object altContainer) {
        super(properties, servingItem, hasLeftovers, altServingItem, altContainerShow, altContainer);
    }
}
