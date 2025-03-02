//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mypersonaldelight.core.data.recipes;

import com.soytutta.mypersonaldelight.common.registry.MPDItems;

import com.soytutta.mypersonaldelight.common.tag.CompatibilityTags;
import com.soytutta.mypersonaldelight.common.tag.MyCommonTags;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.neoforged.neoforge.common.crafting.DifferenceIngredient;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

public class MPDCookingRecipes {

    public MPDCookingRecipes() {
    }

    public static void register(RecipeOutput output) {
        cookMinecraftSoups(output);
        cookMeals(output);
    }

    private static void cookMinecraftSoups(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.DISGUSTING_STEW.get(), 1, 400, 1.0F)
                .addIngredient(MyCommonTags.ROTTEN_MEALS).addIngredient(MyCommonTags.ROTTEN_MEALS).addIngredient(MyCommonTags.ROTTEN_VEGETABLES)
                .addIngredient(CompoundIngredient.of(Ingredient.of(MyCommonTags.ROTTEN_MEALS), Ingredient.of(MyCommonTags.ROTTEN_VEGETABLES), Ingredient.of(ModItems.STRAW.get())))
                .unlockedByAnyIngredient(Items.ROTTEN_FLESH, MPDItems.ROTTEN_SAUSAGE.get(), MPDItems.ROTTEN_MINCED_BEEF.get(), MPDItems.ROTTEN_BACON.get(), MPDItems.ROTTEN_MUTTON_CHOPS.get(), MPDItems.ROTTEN_CHICKEN_CUTS.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/disgusting_stew");
        CookingPotRecipeBuilder.cookingPotRecipe(net.minecraft.world.item.Items.RABBIT_STEW, 1, 200, 1.0F, net.minecraft.world.item.Items.BOWL)
                .addIngredient(MyCommonTags.FOODS_COOKED_POTATO).addIngredient(Items.RABBIT).addIngredient(Items.CARROT)
                .addIngredient(Ingredient.of(Items.BROWN_MUSHROOM,Items.RED_MUSHROOM))
                .unlockedByAnyIngredient(net.minecraft.world.item.Items.RABBIT, net.minecraft.world.item.Items.BROWN_MUSHROOM, net.minecraft.world.item.Items.RED_MUSHROOM, net.minecraft.world.item.Items.CARROT, MPDItems.BAKED_POTATO_SLICES.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "farmersdelight:cooking/rabbit_stew");
    }

    private static void cookMeals(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.MASHED_POTATO.get(), 1, 400, 1.0F)
                .addIngredient(Ingredient.of(MyCommonTags.FOODS_COOKED_POTATO),2)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(output, "mypersonaldelight:cooking/mashed_potato");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.FRIES_POTATOES.get(), 1, 200, 1.0F,Items.PAPER)
                .addIngredient(Tags.Items.CROPS_POTATO).addIngredient(Tags.Items.CROPS_POTATO)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(output, "mypersonaldelight:cooking/fries_potato");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.POTATO_OMELET.get(), 1, 400, 1.0F)
                .addIngredient(Tags.Items.CROPS_POTATO).addIngredient(Tags.Items.CROPS_POTATO).addIngredient(CommonTags.FOODS_ONION)
                .addIngredient(Tags.Items.EGGS)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/potato_omelet");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.MASHED_POTATO_WITH_MEATBALLS.get(), 1, 200, 1.0F)
                .addIngredient(ModItems.MINCED_BEEF.get()).addIngredient(ModItems.TOMATO_SAUCE.get())
                .addIngredient(MPDItems.MASHED_POTATO.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/mashed_potato_with_meatballs");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.POTATO_AND_MEAT_PIE.get(), 1, 400, 2.0F)
                .addIngredient(MPDItems.MASHED_POTATO.get()).addIngredient(CommonTags.FOODS_RAW_BEEF).addIngredient(CommonTags.FOODS_RAW_BEEF)
                .addIngredient(CommonTags.FOODS_ONION).addIngredient(MPDItems.MASHED_POTATO.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/potato_and_meat_pie");


        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.PASTA_WITH_BEET.get(), 1, 200, 1.0F)
                .addIngredient(CommonTags.FOODS_PASTA).addIngredient(Items.BEETROOT,2)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/pasta_with_beet");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.BEET_JUICE.get(), 1, 200, 1.0F)
                .addIngredient(Items.BEETROOT,3).addIngredient(Items.SUGAR)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .build(output, "mypersonaldelight:cooking/beet_juice");

        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.SLIME_DUMPLINGS.get(), 1, 200, 1.0F)
                .addIngredient(MPDItems.SLIMECUBE.get(),2).addIngredient(CommonTags.FOODS_ONION)
                .addIngredient(vegetablesPatch())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/slime_dumplings");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.STICKY_GREEN_NOODLES.get(), 1, 400, 1.0F)
                .addIngredient(CommonTags.FOODS_PASTA).addIngredient(CommonTags.FOODS_COOKED_EGG)
                .addIngredient(MPDItems.SLIMECUBE.get(),2)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/sticky_green_noodles");

        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.POTLUCK_SOUP.get(), 1, 400, 2.0F,MPDItems.GUARDIAN_HEAD.get())
                .addIngredient(MyCommonTags.GUARDIAN_TAILS).addIngredient(Ingredient.of(MyCommonTags.ANY_GUARDIAN_MEATS),3)
                .addIngredient(CommonTags.FOODS_ONION).addIngredient(CommonTags.FOODS_TOMATO)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/potluck_soup");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.ELDER_POTLUCK_SOUP.get(), 1, 600, 4.0F,MPDItems.ELDER_GUARDIAN_HEAD.get())
                .addIngredient(MyCommonTags.ELDER_GUARDIAN_TAILS).addIngredient(Ingredient.of(MyCommonTags.ANY_GUARDIAN_TAILS),2)
                .addIngredient(MyCommonTags.ANY_GUARDIAN_MEATS).addIngredient(ModItems.ONION_CRATE.get()).addIngredient(ModItems.TOMATO_CRATE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/elder_potluck_soup");

        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.ANCIENT_BOILED_EGG.get(), 8, 400, 2.0F)
                .addIngredient(Items.SNIFFER_EGG)
                .unlockedByAnyIngredient(Items.SNIFFER_EGG)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/ancient_boiled_egg");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.RIBS_WITH_EGGS.get(), 1, 200, 2.0F)
                .addIngredient(MPDItems.ANCIENT_RIBS.get()).addIngredient(CommonTags.FOODS_COOKED_EGG).addIngredient(CommonTags.FOODS_ONION)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/ribs_with_eggs");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.ANCIENT_RIBS_WITH_SEEDS.get(), 1, 200, 2.0F)
                .addIngredient(MPDItems.ANCIENT_RIBS.get())
                .addIngredient(Ingredient.of(Items.PITCHER_POD,MPDItems.POT_SLICE.get()))
                .addIngredient(Ingredient.of(Items.PITCHER_POD,MPDItems.POT_SLICE.get(),Items.TORCHFLOWER_SEEDS,Items.TORCHFLOWER))
                .addIngredient(Items.TORCHFLOWER)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/ancient_ribs_with_seeds");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.PASTA_WITH_POT.get(), 1, 200, 2.0F)
                .addIngredient(CommonTags.FOODS_PASTA).addIngredient(Ingredient.of(Items.PITCHER_POD,MPDItems.POT_SLICE.get()),2)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/pasta_with_pot");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.ANCIENT_SOFT_BOILED_EGG_AND_BREADS.get(), 1, 300, 4.0F,Items.BOWL)
                .addIngredient(Items.SNIFFER_EGG).addIngredient(Ingredient.of(Items.TORCHFLOWER_SEEDS,Items.TORCHFLOWER))
                .addIngredient(CommonTags.FOODS_ONION).addIngredient(Tags.Items.FOODS_BREAD).addIngredient(Tags.Items.FOODS_BREAD)
                .unlockedByAnyIngredient(Items.SNIFFER_EGG)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/ancient_soft-boiled_egg_and_breads");
        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.BREADED_MEAT_WITH_PASTA.get(), 1, 200, 2.0F,Items.BOWL)
                .addIngredient(CommonTags.FOODS_PASTA).addIngredient(Ingredient.of(MPDItems.COOKED_BREADED_MEAT.get(),MPDItems.RAW_BREADED_MEAT.get()))
                .addIngredient(Tags.Items.EGGS)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/breaded_meat_with_pasta");

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.SMOKED_HAM.get(), 1, 400, 2.0F)
                .addIngredient(Items.GHAST_TEAR)
                .addIngredient(MPDItems.ROTTEN_HAM.get())
                .addIngredient(Items.GLOWSTONE_DUST)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(output, "mypersonaldelight:cooking/cure_rotten_ham");
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.COOKED_BACON.get(), 4, 400, 2.0F)
                .addIngredient(Items.GHAST_TEAR)
                .addIngredient(MPDItems.ROTTEN_BACON.get(),4)
                .addIngredient(Items.GLOWSTONE_DUST)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(output, "mypersonaldelight:cooking/cure_rotten_bacon");
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.BEEF_PATTY.get(), 4, 400, 2.0F)
                .addIngredient(Items.GHAST_TEAR)
                .addIngredient(MPDItems.ROTTEN_MINCED_BEEF.get(),4)
                .addIngredient(Items.REDSTONE)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(output, "mypersonaldelight:cooking/cure_minced_beef");
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.COOKED_MUTTON_CHOPS.get(), 4, 400, 2.0F)
                .addIngredient(Items.GHAST_TEAR)
                .addIngredient(MPDItems.ROTTEN_MUTTON_CHOPS.get(),4)
                .addIngredient(Items.REDSTONE)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(output, "mypersonaldelight:cooking/cure_mutton_chops");
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.COOKED_CHICKEN_CUTS.get(), 4, 400, 2.0F)
                .addIngredient(Items.GHAST_TEAR)
                .addIngredient(MPDItems.ROTTEN_CHICKEN_CUTS.get(),4)
                .addIngredient(Items.GLOWSTONE_DUST)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(output, "mypersonaldelight:cooking/cure_chicken_cuts");

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.BEEF_STEW.get(), 1, 400, 2.0F)
                .addIngredient(Items.GHAST_TEAR)
                .addIngredient(MPDItems.DISGUSTING_STEW.get())
                .addIngredient(Items.REDSTONE)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(output, "mypersonaldelight:cooking/cure_disgusting_stew");
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CHICKEN_SOUP.get(), 1, 400, 2.0F)
                .addIngredient(Items.GHAST_TEAR)
                .addIngredient(MPDItems.DISGUSTING_STEW.get())
                .addIngredient(Items.GLOWSTONE_DUST)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(output, "mypersonaldelight:cooking/cure_disgusting_stew_alt");

        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.SUCKLING_PIG_WITH_VEGETABLES.get(), 1, 400, 2.0F, Items.BOWL)
                .addIngredient(MPDItems.RAW_SUCKLING_PIG.get())
                .addIngredient(Tags.Items.CROPS_POTATO).addIngredient(Tags.Items.CROPS_POTATO)
                .addIngredient(CommonTags.FOODS_TOMATO).addIngredient(CommonTags.FOODS_CABBAGE).addIngredient(net.neoforged.neoforge.common.Tags.Items.CROPS_CARROT)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output, "mypersonaldelight:cooking/suckling_pig_with_vegetables");

        CookingPotRecipeBuilder.cookingPotRecipe(MPDItems.HONEY_NUGGETS.get(), 1,  200, 1.0F)
                .addIngredient(CommonTags.FOODS_RAW_CHICKEN)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(CommonTags.FOODS_ONION)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(output, "mypersonaldelight:cooking/honey_nuggets");
    }

    private static Ingredient vegetablesPatch() {
        return DifferenceIngredient.of(Ingredient.of(Tags.Items.FOODS_VEGETABLE), Ingredient.of(new ItemLike[]{net.minecraft.world.item.Items.MELON_SLICE}));
    }
    private static Ingredient MilkorCheese() {
        return CompoundIngredient.of(
                Ingredient.of(CommonTags.FOODS_MILK),
                Ingredient.of(CompatibilityTags.FOOD_CHEESE_WEDGE)
        );
    }
}