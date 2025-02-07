//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mypersonaldelight.core.data;

import com.soytutta.mypersonaldelight.core.data.recipes.MPDCraftingRecipes;
import com.soytutta.mypersonaldelight.core.data.recipes.MPDCookingRecipes;
import com.soytutta.mypersonaldelight.core.data.recipes.MPDCuttingRecipes;
import com.soytutta.mypersonaldelight.core.data.recipes.MPDSmeltingRecipes;
import net.minecraft.data.PackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

public class MPDRecipes extends RecipeProvider {

    public MPDRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }
    protected void buildRecipes(RecipeOutput output) {
        MPDSmeltingRecipes.register(output);
        MPDCraftingRecipes.register(output);
        MPDCuttingRecipes.register(output);
        MPDCookingRecipes.register(output);
    }
}
