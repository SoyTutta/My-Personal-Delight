//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mypersonaldelight.core.data.recipes;
import com.soytutta.mypersonaldelight.MyPersonalDelight;
import com.soytutta.mypersonaldelight.common.registry.MPDItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.Arrays;


public class MPDSmeltingRecipes {

    public static void register(RecipeOutput output) {
        foodSmeltingRecipes("breaded_meat", Ingredient.of(MPDItems.RAW_BREADED_MEAT.get()), MPDItems.COOKED_BREADED_MEAT.get(), 0.35F, output);
        foodSmeltingRecipes("frog_leg", Ingredient.of(MPDItems.RAW_FROG_LEG.get()), MPDItems.COOKED_FROG_LEG.get(), 0.35F, output);
        foodSmeltingRecipes("ancient_ribs", Ingredient.of(MPDItems.ANCIENT_RIBS.get()), MPDItems.COOKED_ANCIENT_RIBS.get(), 0.35F, output);
        foodSmeltingRecipes("guardian_slice", Ingredient.of(MPDItems.RAW_GUARDIAN_SLICE.get()), MPDItems.COOKED_GUARDIAN_SLICE.get(), 0.35F, output);
        foodSmeltingRecipes("elder_guardian_slice", Ingredient.of(MPDItems.RAW_ELDER_GUARDIAN_SLICE.get()), MPDItems.COOKED_ELDER_GUARDIAN_SLICE.get(), 0.35F, output);

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(MPDItems.SQUISHMALLOW.get()), RecipeCategory.FOOD,
                        MPDItems.SMOKED_SQUISHMALLOW.get(), 0.35F, 100)
                .unlockedBy("has_squishmallow", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.SMOKED_SQUISHMALLOW.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(MyPersonalDelight.MODID, "squishmallow") + "_from_smoking");
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(MPDItems.SQUISHMALLOW.get()), RecipeCategory.FOOD,
                        MPDItems.SMOKED_SQUISHMALLOW.get(), 0.35F, 100)
                .unlockedBy("has_squishmallow", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.SMOKED_SQUISHMALLOW.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(MyPersonalDelight.MODID, "squishmallow") + "_from_campfire_cooking");

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(MPDItems.RAW_GUARDIAN_TAIL.get()), RecipeCategory.FOOD,
                        MPDItems.SMOKED_GUARDIAN_TAIL.get(), 0.35F, 100)
                .unlockedBy("has_guardian_tail", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.RAW_GUARDIAN_TAIL.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(MyPersonalDelight.MODID, "guardian_tail") + "_from_smoking");
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(MPDItems.RAW_ELDER_GUARDIAN_TAIL.get()), RecipeCategory.FOOD,
                        MPDItems.SMOKED_ELDER_GUARDIAN_TAIL.get(), 0.35F, 100)
                .unlockedBy("has_elder_guardian_tail", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.RAW_ELDER_GUARDIAN_TAIL.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(MyPersonalDelight.MODID, "elder_guardian_tail") + "_from_smoking");
    }

    private static void foodSmeltingRecipes(String name, Ingredient ingredient, ItemLike result, float experience, RecipeOutput output) {
        String namePrefix = ResourceLocation.fromNamespaceAndPath("mypersonaldelight", name).toString();
        ItemLike[] items = Arrays.stream(ingredient.getItems())
                .map(ItemStack::getItem)
                .toArray(ItemLike[]::new);

        RecipeBuilder smeltingRecipe = SimpleCookingRecipeBuilder.smelting(ingredient, RecipeCategory.FOOD, result, experience, 200)
                .unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(items));
        smeltingRecipe.save(output, namePrefix + "_cooking");

        RecipeBuilder campfireRecipe = SimpleCookingRecipeBuilder.campfireCooking(ingredient, RecipeCategory.FOOD, result, experience, 600)
                .unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(items));
        campfireRecipe.save(output, namePrefix + "_from_campfire_cooking");

        RecipeBuilder smokingRecipe = SimpleCookingRecipeBuilder.smoking(ingredient, RecipeCategory.FOOD, result, experience, 100)
                .unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(items));
        smokingRecipe.save(output, namePrefix + "_from_smoking");
    }

}