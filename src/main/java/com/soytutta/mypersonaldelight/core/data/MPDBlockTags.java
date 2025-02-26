package com.soytutta.mypersonaldelight.core.data;

import com.soytutta.mypersonaldelight.common.registry.MPDBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class MPDBlockTags extends BlockTagsProvider {
    public MPDBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, "mypersonaldelight", existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.registerModTags();
        this.registerMinecraftTags();
        this.registerForgeTags();
        this.registerBlockMineables();
    }

    protected void registerBlockMineables() {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(MPDBlocks.POTLUCK_SOUP_BLOCK.get());
        this.tag(ModTags.MINEABLE_WITH_KNIFE).add(MPDBlocks.SUCKLING_PIG_WITH_VEGETABLES_BLOCK.get(), MPDBlocks.POTATO_AND_MEAT_PIE_BLOCK.get(), MPDBlocks.ANCIENT_SOFT_BOILED_EGG_AND_BREADS_BLOCK.get(), MPDBlocks.ICE_CREAM_IN_A_PUMPKIN_HEAD_BLOCK.get(), MPDBlocks.MINT_ROULETTE_BLOCK.get(), MPDBlocks.POTLUCK_SOUP_BLOCK.get());
    }

    protected void registerMinecraftTags() {
    }

    protected void registerForgeTags() {
    }

    protected void registerModTags() {
    }
}