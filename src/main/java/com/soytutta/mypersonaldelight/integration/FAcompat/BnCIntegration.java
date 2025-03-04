package com.soytutta.mypersonaldelight.integration.FAcompat;

import com.soytutta.mypersonaldelight.common.utility.MPDFoodValues;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.function.Supplier;

import static com.soytutta.mypersonaldelight.common.registry.MPDItems.foodItem;

public class BnCIntegration {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, "brewinandchewin");
    public static final Supplier<Item> HALF_A_HAM_AND_CHEESE_SANDWICH = ITEMS.register("half_a_ham_and_cheese_sandwich", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.HALF_A_HAM_AND_CHEESE_SANDWICH)));
}
