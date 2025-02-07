//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mypersonaldelight.core.data.recipes;

import com.soytutta.mypersonaldelight.common.registry.MPDItems;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class MPDCuttingRecipes {

    public static void register(RecipeOutput output) {
        cuttingAnimalItems(output);
        cuttingVegetables(output);
        cuttingFoods(output);
    }

    private static void cuttingAnimalItems(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.GUARDIAN.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.GUARDIAN_HEAD.get())
                .addResult(MPDItems.RAW_GUARDIAN_TAIL.get())
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.GUARDIAN_HEAD.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), Items.PRISMARINE_SHARD, 3)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.RAW_GUARDIAN_TAIL.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.RAW_GUARDIAN_SLICE.get(), 3)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.SMOKED_GUARDIAN_TAIL.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.COOKED_GUARDIAN_SLICE.get(), 3)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.ELDER_GUARDIAN.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.ELDER_GUARDIAN_HEAD.get())
                .addResult(MPDItems.RAW_ELDER_GUARDIAN_TAIL.get())
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.ELDER_GUARDIAN_HEAD.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), Items.PRISMARINE_SHARD, 4)
                .addResult(Items.PRISMARINE_CRYSTALS, 3)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.RAW_ELDER_GUARDIAN_TAIL.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.RAW_ELDER_GUARDIAN_SLICE.get(), 3)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.SMOKED_ELDER_GUARDIAN_TAIL.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.COOKED_ELDER_GUARDIAN_SLICE.get(), 3)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.ANCIENT_RIBS.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.MUTTON_CHOPS.get(), 4)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.COOKED_ANCIENT_RIBS.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.COOKED_MUTTON_CHOPS.get(), 4)
                .build(output);
    }

    private static void cuttingVegetables(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.POTATO), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.POTATO_SLICES.get(), 2)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.PITCHER_POD), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.POT_SLICE.get(), 2)
                .build(output);
    }

    private static void cuttingFoods(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.BONE), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.BROKEN_BONES.get(),3)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.ROTTEN_FLESH), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.ROTTEN_BACON.get())
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.ROTTEN_BACON.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.ROTTEN_MINCED_BEEF.get())
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.BREADED_MEAT_SANDWICH.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.HALF_A_BREADED_MEAT_SANDWICH.get(), 2)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.BACON_SANDWICH.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.HALF_A_BACON_SANDWICH.get(), 2)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.EGG_SANDWICH.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.HALF_A_EGG_SANDWICH.get(), 2)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.ANCIENT_EGG_SANDWICH.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.HALF_A_ANCIENT_EGG_SANDWICH.get(), 2)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.CHICKEN_SANDWICH.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.HALF_A_CHICKEN_SANDWICH.get(), 2)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.HAMBURGER.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.HALF_A_HAMBURGER.get(), 2)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.SLIME_JELLY.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.SLIME_JELLY_SLICE.get(), 4)
                .build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MPDItems.ICE_CREAM_IN_A_PUMPKIN_HEAD.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), MPDItems.PUMPKIN_HEAD_SLICE.get(), 4)
                .build(output);
    }
}
