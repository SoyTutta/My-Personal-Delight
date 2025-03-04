package com.soytutta.mypersonaldelight.integration.FAcompat;

import com.soytutta.mypersonaldelight.common.utility.MPDFoodValues;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.function.Supplier;

import static com.soytutta.mypersonaldelight.common.registry.MPDItems.foodItem;


public class MNDIntegration {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, "mynethersdelight");
    public static final Supplier<Item> HALF_A_HOTDOG = ITEMS.register("half_a_hotdog", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.HALF_A_HOTDOG)));
    public static final Supplier<Item> HALF_A_CHILIDOG = ITEMS.register("half_a_chilidog", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.HALF_A_CHILIDOG)));
}
