//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mypersonaldelight.core.data.recipes;

import com.soytutta.mypersonaldelight.common.registry.MPDItems;
import com.soytutta.mypersonaldelight.common.tag.MyCommonTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.crafting.DifferenceIngredient;
import vectorwing.farmersdelight.common.crafting.FoodServingRecipe;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

public class MPDCraftingRecipes {

    public static void register(RecipeOutput output) {
        recipesVanillaAlternatives(output);
        recipesBlocks(output);
        recipesCraftedMeals(output);
        SpecialRecipeBuilder.special(FoodServingRecipe::new).save(output, "food_serving");
    }

    private static void recipesVanillaAlternatives(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.SLIME_BALL)
                .requires(MPDItems.SLIMECUBE.get())
                .unlockedBy("has_slimecube", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.SLIMECUBE.get()))
                .save(output, "mypersonaldelight:crafting/slime_ball");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.BONE_MEAL)
                .requires(MPDItems.BROKEN_BONES.get())
                .unlockedBy("has_bone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL))
                .save(output, "mypersonaldelight:crafting/bone_meal");

    }

    private static void recipesBlocks(RecipeOutput output) {
    }

    private static void recipesCraftedMeals(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.RAW_BREADED_MEAT.get())
                .requires(Tags.Items.FOODS_RAW_MEAT)
                .requires(Tags.Items.EGGS)
                .requires(Tags.Items.CROPS_WHEAT)
                .unlockedBy("has_wheat", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT, Items.EGG))
                .save(output, "mypersonaldelight:crafting/raw_breaded_meat");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.BREADED_MEAT_SANDWICH.get())
                .requires(MPDItems.COOKED_BREADED_MEAT.get())
                .requires(Tags.Items.FOODS_BREAD)
                .requires(CommonTags.CROPS_CABBAGE)
                .requires(CommonTags.CROPS_TOMATO)
                .unlockedBy("has_breaded_meat", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.COOKED_BREADED_MEAT.get(), MPDItems.RAW_BREADED_MEAT.get()))
                .save(output, "mypersonaldelight:crafting/breaded_meat_sandwich");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.NAPOLITANA_WITH_FRIES_POTATOES.get())
                .requires(ModItems.MILK_BOTTLE.get())
                .requires(CommonTags.CROPS_TOMATO)
                .requires(MPDItems.FRIES_POTATOES.get())
                .requires(MPDItems.COOKED_BREADED_MEAT.get())
                .requires(Items.BOWL)
                .unlockedBy("has_breaded_meat", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.COOKED_BREADED_MEAT.get(), MPDItems.RAW_BREADED_MEAT.get()))
                .save(output, "mypersonaldelight:crafting/napolitana_with_fries_potatoes");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.BREADED_MEAT_WITH_MASHED_POTATO.get())
                .requires(MPDItems.MASHED_POTATO.get())
                .requires(MPDItems.COOKED_BREADED_MEAT.get())
                .requires(Items.BOWL)
                .unlockedBy("has_breaded_meat", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.COOKED_BREADED_MEAT.get(), MPDItems.RAW_BREADED_MEAT.get()))
                .save(output, "mypersonaldelight:crafting/breaded_meat_with_mashed_potato");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.BEET_AND_EGG_SALAD.get())
                .requires(Tags.Items.CROPS_BEETROOT)
                .requires(Tags.Items.CROPS_BEETROOT)
                .requires(MyCommonTags.FOODS_BOILED_EGG)
                .requires(Items.BOWL)
                .unlockedBy("has_beetroot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BEETROOT))
                .save(output, "mypersonaldelight:crafting/beet_and_egg_salad");

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.GLISTERING_MELON_POPSICLE.get(), 1)
                .pattern("ggg")
                .pattern("g#g")
                .pattern("ggg")
                .define('#', ModItems.MELON_POPSICLE.get())
                .define('g', Items.GOLD_NUGGET)
                .unlockedBy("has_melon_popsicle", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MELON_POPSICLE.get()))
                .save(output, "mypersonaldelight:crafting/glistering_melon_popsicle");
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.COCOA_POPSICLE.get(), 1)
                .pattern(" ##")
                .pattern("i##")
                .pattern("-i ")
                .define('#', Items.COCOA_BEANS)
                .define('i', Items.ICE)
                .define('-', Items.STICK)
                .unlockedBy("has_cocoa", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COCOA_BEANS))
                .save(output, "mypersonaldelight:crafting/cocoa_popsicle");
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.MINT_POPSICLE.get(), 1)
                .pattern(" ##")
                .pattern("i##")
                .pattern("-i ")
                .define('#', MPDItems.MINT_LETTUCE.get())
                .define('i', Items.ICE)
                .define('-', Items.STICK)
                .unlockedBy("has_mint", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.MINT_LETTUCE.get()))
                .save(output, "mypersonaldelight:crafting/mint_popsicle");
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.SWEET_BERRIES_POPSICLE.get(), 1)
                .pattern(" ##")
                .pattern("i##")
                .pattern("-i ")
                .define('#', Items.SWEET_BERRIES)
                .define('i', Items.ICE)
                .define('-', Items.STICK)
                .unlockedBy("has_sweet_berries", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SWEET_BERRIES))
                .save(output, "mypersonaldelight:crafting/sweet_berries_popsicle");
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.GLOW_BERRIES_POPSICLE.get(), 1)
                .pattern(" ##")
                .pattern("i##")
                .pattern("-i ")
                .define('#', Items.GLOW_BERRIES)
                .define('i', Items.ICE)
                .define('-', Items.STICK)
                .unlockedBy("has_sweet_berries", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOW_BERRIES))
                .save(output, "mypersonaldelight:crafting/glow_berries_popsicle");
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.APPLE_POPSICLE.get(), 1)
                .pattern(" ##")
                .pattern("i##")
                .pattern("-i ")
                .define('#', Items.APPLE)
                .define('i', Items.ICE)
                .define('-', Items.STICK)
                .unlockedBy("has_apple", InventoryChangeTrigger.TriggerInstance.hasItems(Items.APPLE))
                .save(output, "mypersonaldelight:crafting/apple_popsicle");
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.GOLDEN_APPLE_POPSICLE.get(), 1)
                .pattern("ggg")
                .pattern("g#g")
                .pattern("ggg")
                .define('#', MPDItems.APPLE_POPSICLE.get())
                .define('g', Items.GOLD_NUGGET)
                .unlockedBy("has_apple_popsicle", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.APPLE_POPSICLE.get()))
                .save(output, "mypersonaldelight:crafting/golden_apple_popsicle");
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.TORCH_POPSICLE.get(), 1)
                .pattern(" ##")
                .pattern("i##")
                .pattern("-i ")
                .define('#', Ingredient.of(Items.TORCHFLOWER,Items.TORCHFLOWER_SEEDS))
                .define('i', Items.ICE)
                .define('-', Items.STICK)
                .unlockedBy("has_apple", InventoryChangeTrigger.TriggerInstance.hasItems(Items.APPLE))
                .save(output, "mypersonaldelight:crafting/torch_popsicle");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.SQUISHMALLOW.get())
                .requires(Items.STICK)
                .requires(MPDItems.SLIMECUBE.get())
                .unlockedBy("has_slime", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SLIME_BALL, MPDItems.SLIMECUBE.get()))
                .save(output, "mypersonaldelight:crafting/squishmallow");
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.SLIME_JELLY.get(), 1)
                .pattern("sss")
                .pattern("SwS")
                .pattern("ccc")
                .define('s', MPDItems.SLIMECUBE.get())
                .define('w', Tags.Items.BUCKETS_WATER).define('S', Items.SUGAR)
                .define('c', Items.SUGAR_CANE)
                .unlockedBy("has_slime", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SLIME_BALL, MPDItems.SLIMECUBE.get()))
                .save(output, "mypersonaldelight:crafting/slime_jelly");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.SWEET_TRIGGER.get(),2)
                .requires(Items.HONEY_BOTTLE)
                .requires(MPDItems.MINT_LETTUCE.get(),2)
                .requires(Items.SWEET_BERRIES)
                .unlockedBy("has_mint", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.MINT_LETTUCE.get()))
                .save(output, "mypersonaldelight:crafting/sweet_trigger");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.CREEPER_SALAD.get())
                .requires(Tags.Items.GUNPOWDERS)
                .requires(MPDItems.MINT_LETTUCE.get(),2)
                .requires(Items.BOWL)
                .unlockedBy("has_mint", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.MINT_LETTUCE.get()))
                .save(output, "mypersonaldelight:crafting/creeper_salad");
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.MINT_ROULETTE.get())
                .pattern("msm")
                .pattern("mcm")
                .define('s', MPDItems.SWEET_TRIGGER.get())
                .define('m', MPDItems.MINT_LETTUCE.get())
                .define('c', MPDItems.CREEPER_SALAD.get())
                .unlockedBy("has_mint", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.MINT_LETTUCE.get()))
                .save(output, "mypersonaldelight:crafting/creeper_roulette");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.GUARDIAN_GRILLED_ON_A_STICK.get())
                .requires(Items.STICK)
                .requires(MPDItems.COOKED_GUARDIAN_SLICE.get(),3)
                .unlockedBy("has_guardian_slice", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.COOKED_GUARDIAN_SLICE.get()))
                .save(output, "mypersonaldelight:crafting/guardian_grilled_on_a_stick");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.ELDER_GUARDIAN_GRILLED_ON_A_STICK.get())
                .requires(Items.STICK)
                .requires(MPDItems.COOKED_ELDER_GUARDIAN_SLICE.get(),3)
                .unlockedBy("has_elder_guardian_slice", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.COOKED_ELDER_GUARDIAN_SLICE.get()))
                .save(output, "mypersonaldelight:crafting/elder_guardian_grilled_on_a_stick");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.ANCIENT_BREAKFAST.get())
                .requires(Ingredient.of(Items.PITCHER_POD,MPDItems.POT_SLICE.get()),3)
                .requires(MPDItems.ANCIENT_BOILED_EGG.get(),2)
                .requires(Items.BOWL)
                .unlockedBy("has_ancient_boiled_egg_or_pitcher_pot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PITCHER_POD,MPDItems.POT_SLICE.get(),MPDItems.ANCIENT_BOILED_EGG.get()))
                .save(output, "mypersonaldelight:crafting/ancient_breakfast");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.POT_WITH_HONEY_ON_A_STICK.get())
                .requires(Ingredient.of(Items.PITCHER_POD,MPDItems.POT_SLICE.get()),2)
                .requires(Items.STICK)
                .requires(Items.HONEY_BOTTLE)
                .unlockedBy("has_pitcher_pot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PITCHER_POD,MPDItems.POT_SLICE.get()))
                .save(output, "mypersonaldelight:crafting/pot_with_honey_on_a_stick");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.ANCIENT_SALAD.get())
                .requires(Items.TORCHFLOWER)
                .requires(Ingredient.of(Items.TORCHFLOWER,Items.TORCHFLOWER_SEEDS),2)
                .requires(Items.BOWL)
                .unlockedBy("has_torchflower_or_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(Items.TORCHFLOWER,Items.TORCHFLOWER_SEEDS))
                .save(output, "mypersonaldelight:crafting/ancient_salad");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.ANCIENT_EGG_SANDWICH.get())
                .requires(Tags.Items.FOODS_BREAD)
                .requires(MPDItems.ANCIENT_BOILED_EGG.get(), 2)
                .unlockedBy("has_ancient_eggs", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.ANCIENT_BOILED_EGG.get()))
                .save(output, "mypersonaldelight:crafting/ancient_egg_sandwich");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.ROTTEN_MEAT_ON_A_BONE.get())
                .requires(Items.BONE)
                .requires(MyCommonTags.ROTTEN_MEALS)
                .requires(MyCommonTags.ROTTEN_MEALS)
                .requires(MyCommonTags.ROTTEN_MEALS)
                .unlockedBy("has_guardian_slice", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.COOKED_GUARDIAN_SLICE.get()))
                .save(output, "mypersonaldelight:crafting/rotten_meat_on_a_bone");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.FROG_LEG_ON_A_STICK.get())
                .requires(Items.STICK)
                .requires(MPDItems.COOKED_FROG_LEG.get(),2)
                .unlockedBy("has_frog_leg", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.RAW_FROG_LEG.get()))
                .save(output, "mypersonaldelight:crafting/frog_legs_on_a_stick");

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.ROTTEN_CHICKEN_CUTS.get())
                .pattern("r")
                .pattern("#")
                .define('r', MPDItems.ROTTEN_MINCED_BEEF.get())
                .define('#', MPDItems.BROKEN_BONES.get())
                .unlockedBy("has_rotten_minced_beef", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.ROTTEN_MINCED_BEEF.get()))
                .save(output, "mypersonaldelight:crafting/rotten_chicken_cuts");
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.ROTTEN_MUTTON_CHOPS.get())
                .pattern("#")
                .pattern("r")
                .define('r', MPDItems.ROTTEN_MINCED_BEEF.get())
                .define('#', MPDItems.BROKEN_BONES.get())
                .unlockedBy("has_rotten_minced_beef", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.ROTTEN_MINCED_BEEF.get()))
                .save(output, "mypersonaldelight:crafting/rotten_mutton_chops");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MPDItems.ROTTEN_SAUSAGE.get())
                .requires(Items.STRING)
                .requires(MPDItems.ROTTEN_MINCED_BEEF.get())
                .unlockedBy("has_rotten_minced_beef", InventoryChangeTrigger.TriggerInstance.hasItems(MPDItems.ROTTEN_MINCED_BEEF.get()))
                .save(output, "mynethersdelight:crafting/rotten_sausage");

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, MPDItems.RAW_SUCKLING_PIG.get(), 1)
                .pattern("HBH")
                .pattern("bBb")
                .define('H', ModItems.HAM.get())
                .define('B', Items.PORKCHOP).define('b', ModItems.BACON.get())
                .unlockedBy("has_ham", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HAM.get()))
                .save(output, "mypersonaldelight:crafting/raw_suckling_pig");

    }

    private static Ingredient vegetablesPatch() {
        return DifferenceIngredient.of(Ingredient.of(Tags.Items.FOODS_VEGETABLE), Ingredient.of(new ItemLike[]{net.minecraft.world.item.Items.MELON_SLICE}));
    }
}
