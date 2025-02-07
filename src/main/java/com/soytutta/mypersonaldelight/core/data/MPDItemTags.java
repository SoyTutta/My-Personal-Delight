//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mypersonaldelight.core.data;

import javax.annotation.Nullable;

import com.soytutta.mypersonaldelight.common.registry.MPDItems;
import com.soytutta.mypersonaldelight.common.tag.CompatibilityTags;
import com.soytutta.mypersonaldelight.common.tag.MyCommonTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

import java.util.concurrent.CompletableFuture;

public class MPDItemTags extends ItemTagsProvider {
    public MPDItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, "mypersonaldelight", existingFileHelper);
    }

    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.registerCommonTags();
        this.registerNeoForgeTags();
        this.registerMinecraftTags();
        this.registerModTags();
        this.registerCompatibilityTags();
    }

    private void registerCommonTags() {
        this.tag(CommonTags.FOODS_CABBAGE).add(MPDItems.MINT_LETTUCE.get());
        this.tag(CommonTags.FOODS_RAW_COD).add(MPDItems.RAW_ELDER_GUARDIAN_SLICE.get());
        this.tag(CommonTags.FOODS_COOKED_COD).add(MPDItems.COOKED_ELDER_GUARDIAN_SLICE.get());
        this.tag(CommonTags.FOODS_RAW_SALMON).add(MPDItems.RAW_GUARDIAN_SLICE.get());
        this.tag(CommonTags.FOODS_COOKED_SALMON).add(MPDItems.COOKED_GUARDIAN_SLICE.get());
        this.tag(CommonTags.FOODS_RAW_MUTTON).add(MPDItems.ANCIENT_RIBS.get());
        this.tag(CommonTags.FOODS_COOKED_MUTTON).add(MPDItems.COOKED_ANCIENT_RIBS.get());
        this.tag(CommonTags.FOODS_RAW_BEEF).add(MPDItems.ANCIENT_RIBS.get());
        this.tag(CommonTags.FOODS_COOKED_BEEF).add(MPDItems.COOKED_ANCIENT_RIBS.get());

        this.tag(MyCommonTags.RAW_GUARDIAN_TAIL).add(MPDItems.RAW_GUARDIAN_TAIL.get());
        this.tag(MyCommonTags.COOKED_GUARDIAN_TAIL).add(MPDItems.SMOKED_GUARDIAN_TAIL.get());
        this.tag(MyCommonTags.RAW_GUARDIAN_MEAT).add(MPDItems.RAW_GUARDIAN_SLICE.get());
        this.tag(MyCommonTags.COOKED_GUARDIAN_MEAT).add(MPDItems.COOKED_GUARDIAN_SLICE.get());
        this.tag(MyCommonTags.RAW_ELDER_GUARDIAN_TAIL).add(MPDItems.RAW_ELDER_GUARDIAN_TAIL.get());
        this.tag(MyCommonTags.COOKED_ELDER_GUARDIAN_TAIL).add(MPDItems.SMOKED_ELDER_GUARDIAN_TAIL.get());
        this.tag(MyCommonTags.RAW_ELDER_GUARDIAN_MEAT).add(MPDItems.RAW_ELDER_GUARDIAN_SLICE.get());
        this.tag(MyCommonTags.COOKED_ELDER_GUARDIAN_MEAT).add(MPDItems.COOKED_ELDER_GUARDIAN_SLICE.get());

        this.tag(MyCommonTags.GUARDIAN_MEATS).addTag(MyCommonTags.RAW_GUARDIAN_MEAT).addTag(MyCommonTags.COOKED_GUARDIAN_MEAT).addTag(MyCommonTags.RAW_ELDER_GUARDIAN_MEAT).addTag(MyCommonTags.COOKED_ELDER_GUARDIAN_MEAT).addTag(MyCommonTags.RAW_GUARDIAN_TAIL).addTag(MyCommonTags.COOKED_GUARDIAN_TAIL).addTag(MyCommonTags.RAW_ELDER_GUARDIAN_TAIL).addTag(MyCommonTags.COOKED_ELDER_GUARDIAN_TAIL);
        this.tag(MyCommonTags.GUARDIAN_TAILS).addTag(MyCommonTags.RAW_GUARDIAN_TAIL).addTag(MyCommonTags.COOKED_GUARDIAN_TAIL).addTag(MyCommonTags.RAW_ELDER_GUARDIAN_TAIL).addTag(MyCommonTags.COOKED_ELDER_GUARDIAN_TAIL);

        this.tag(MyCommonTags.FOODS_BOILED_EGG).add(MPDItems.ANCIENT_BOILED_EGG.get());
        this.tag(CommonTags.FOODS_COOKED_EGG).addTag(MyCommonTags.FOODS_BOILED_EGG);
        this.tag(MyCommonTags.ROTTEN_VEGETABLES).add(Items.POISONOUS_POTATO,ModItems.ROTTEN_TOMATO.get());
        this.tag(MyCommonTags.ROTTEN_MEALS).add(Items.ROTTEN_FLESH, MPDItems.ROTTEN_BACON.get(), MPDItems.ROTTEN_MINCED_BEEF.get(), MPDItems.ROTTEN_CHICKEN_CUTS.get(),MPDItems.ROTTEN_MUTTON_CHOPS.get(),MPDItems.ROTTEN_SAUSAGE.get());
    }

    private void registerNeoForgeTags() {
        this.tag(Tags.Items.FOODS_VEGETABLE).add(MPDItems.POTATO_SLICES.get(),MPDItems.POT_SLICE.get());
        this.tag(Tags.Items.CROPS_POTATO).add(MPDItems.POTATO_SLICES.get());
        this.tag(Tags.Items.SLIMEBALLS).add(MPDItems.SLIMECUBE.get());
        this.tag(Tags.Items.BONES).add(MPDItems.BROKEN_BONES.get());
    }

    private void registerModTags() {
    }

    private void registerMinecraftTags() {
        this.tag(ItemTags.CAT_FOOD).addTag(MyCommonTags.RAW_GUARDIAN_MEAT);
        this.tag(ItemTags.WOLF_FOOD).add(MPDItems.BROKEN_BONES.get());
    }

    public void registerCompatibilityTags() {
        this.tag(CompatibilityTags.BOILED_EGG_CANDIDATE).add(Items.TURTLE_EGG);
        this.tag(CompatibilityTags.RAW_MEATS).add(MPDItems.ANCIENT_RIBS.get());
    }
}