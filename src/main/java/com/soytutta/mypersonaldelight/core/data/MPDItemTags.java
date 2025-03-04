//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mypersonaldelight.core.data;

import javax.annotation.Nullable;

import com.soytutta.mypersonaldelight.common.registry.MPDItems;
import com.soytutta.mypersonaldelight.common.tag.CompatibilityTags;
import com.soytutta.mypersonaldelight.common.tag.MPDTags;
import com.soytutta.mypersonaldelight.common.tag.MyCommonTags;
import com.soytutta.mypersonaldelight.integration.FAcompat.MNDIntegration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
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
        this.tag(MyCommonTags.FOODS_COOKED_POTATO).add(Items.BAKED_POTATO, MPDItems.BAKED_POTATO_SLICES.get());
        this.tag(CommonTags.FOODS_CABBAGE).add(MPDItems.MINT_LETTUCE.get());
        this.tag(CommonTags.CROPS_CABBAGE).add(MPDItems.MINT_LETTUCE.get());
        this.tag(CommonTags.FOODS_SAFE_RAW_FISH).add(MPDItems.RAW_FROG_LEG.get(), MPDItems.RAW_ELDER_GUARDIAN_SLICE.get());
        this.tag(CommonTags.FOODS_RAW_CHICKEN).add(MPDItems.RAW_FROG_LEG.get());
        this.tag(CommonTags.FOODS_COOKED_CHICKEN).add(MPDItems.COOKED_FROG_LEG.get());
        this.tag(CommonTags.FOODS_RAW_COD).add(MPDItems.RAW_ELDER_GUARDIAN_SLICE.get());
        this.tag(CommonTags.FOODS_COOKED_COD).add(MPDItems.COOKED_ELDER_GUARDIAN_SLICE.get());
        this.tag(CommonTags.FOODS_RAW_SALMON).add(MPDItems.RAW_GUARDIAN_SLICE.get());
        this.tag(CommonTags.FOODS_COOKED_SALMON).add(MPDItems.COOKED_GUARDIAN_SLICE.get());
        this.tag(CommonTags.FOODS_RAW_MUTTON).add(MPDItems.ANCIENT_RIBS.get());
        this.tag(CommonTags.FOODS_COOKED_MUTTON).add(MPDItems.COOKED_ANCIENT_RIBS.get());
        this.tag(CommonTags.FOODS_RAW_BEEF).add(MPDItems.ANCIENT_RIBS.get());
        this.tag(CommonTags.FOODS_COOKED_BEEF).add(MPDItems.COOKED_ANCIENT_RIBS.get());

        this.tag(MyCommonTags.RAW_FROG_MEAT).add(MPDItems.RAW_FROG_LEG.get());
        this.tag(MyCommonTags.COOKED_FROG_MEAT).add(MPDItems.COOKED_FROG_LEG.get());
        this.tag(MyCommonTags.FROG_MEAT).addTag(MyCommonTags.RAW_FROG_MEAT).addTag(MyCommonTags.COOKED_FROG_MEAT);

        this.tag(MyCommonTags.GUARDIAN_TAILS).add(MPDItems.RAW_GUARDIAN_TAIL.get(), MPDItems.SMOKED_GUARDIAN_TAIL.get());
        this.tag(MyCommonTags.ELDER_GUARDIAN_TAILS).add(MPDItems.RAW_ELDER_GUARDIAN_TAIL.get(), MPDItems.SMOKED_ELDER_GUARDIAN_TAIL.get());

        this.tag(MyCommonTags.RAW_GUARDIAN_MEAT).add(MPDItems.RAW_GUARDIAN_SLICE.get());
        this.tag(MyCommonTags.COOKED_GUARDIAN_MEAT).add(MPDItems.COOKED_GUARDIAN_SLICE.get());
        this.tag(MyCommonTags.RAW_ELDER_GUARDIAN_MEAT).add(MPDItems.RAW_ELDER_GUARDIAN_SLICE.get());
        this.tag(MyCommonTags.COOKED_ELDER_GUARDIAN_MEAT).add(MPDItems.COOKED_ELDER_GUARDIAN_SLICE.get());

        this.tag(MyCommonTags.ANY_GUARDIAN_MEATS).addTag(MyCommonTags.RAW_GUARDIAN_MEAT).addTag(MyCommonTags.COOKED_GUARDIAN_MEAT).addTag(MyCommonTags.RAW_ELDER_GUARDIAN_MEAT).addTag(MyCommonTags.COOKED_ELDER_GUARDIAN_MEAT);
        this.tag(MyCommonTags.ANY_GUARDIAN_TAILS).addTag(MyCommonTags.GUARDIAN_TAILS).addTag(MyCommonTags.ELDER_GUARDIAN_TAILS);

        this.tag(MyCommonTags.FOODS_BOILED_EGG).add(MPDItems.ANCIENT_BOILED_EGG.get());
        this.tag(CommonTags.FOODS_COOKED_EGG).addTag(MyCommonTags.FOODS_BOILED_EGG);
        this.tag(MyCommonTags.ROTTEN_VEGETABLES).add(Items.POISONOUS_POTATO,ModItems.ROTTEN_TOMATO.get());
        this.tag(MyCommonTags.ROTTEN_MEALS).add(Items.ROTTEN_FLESH, MPDItems.ROTTEN_BACON.get(), MPDItems.ROTTEN_MINCED_BEEF.get(), MPDItems.ROTTEN_CHICKEN_CUTS.get(),MPDItems.ROTTEN_MUTTON_CHOPS.get(),MPDItems.ROTTEN_SAUSAGE.get());
    }

    private void registerNeoForgeTags() {
        this.tag(Tags.Items.FOODS_COOKED_FISH).add(MPDItems.COOKED_FROG_LEG.get(), MPDItems.COOKED_GUARDIAN_SLICE.get(), MPDItems.COOKED_ELDER_GUARDIAN_SLICE.get());
        this.tag(Tags.Items.FOODS_RAW_FISH).add(MPDItems.RAW_FROG_LEG.get(), MPDItems.RAW_GUARDIAN_SLICE.get(), MPDItems.RAW_ELDER_GUARDIAN_SLICE.get());
        this.tag(Tags.Items.FOODS_VEGETABLE).add(MPDItems.POTATO_SLICES.get(),MPDItems.POT_SLICE.get());
        this.tag(Tags.Items.CROPS_POTATO).add(MPDItems.POTATO_SLICES.get());
        this.tag(Tags.Items.SLIMEBALLS).add(MPDItems.SLIMECUBE.get());
        this.tag(Tags.Items.BONES).add(MPDItems.BROKEN_BONES.get());
        this.tag(Tags.Items.FOODS_RAW_MEAT).addTag(MPDTags.RAW_FROG_LEGS);
        this.tag(Tags.Items.FOODS_COOKED_MEAT).addTag(MPDTags.COOKED_FROG_LEGS);
    }

    private void registerModTags() {
        this.tag(MPDTags.RAW_FROG_LEGS).add(MPDItems.RAW_FROG_LEG.get());
        this.tag(MPDTags.COOKED_FROG_LEGS).add(MPDItems.COOKED_FROG_LEG.get());
        this.tag(MPDTags.FROG_LEGS).addTag(MPDTags.COOKED_FROG_LEGS).addTag(MPDTags.RAW_FROG_LEGS);
    }

    private void registerMinecraftTags() {
        this.tag(ItemTags.SWORDS).add(MPDItems.ROTTEN_MEAT_ON_A_BONE.get());
        this.tag(ItemTags.SWORD_ENCHANTABLE).add(MPDItems.ROTTEN_MEAT_ON_A_BONE.get());
        this.tag(ItemTags.CAT_FOOD).addTag(MyCommonTags.RAW_ELDER_GUARDIAN_MEAT).addTag(MyCommonTags.RAW_GUARDIAN_MEAT).add(ModItems.COD_SLICE.get(), ModItems.SALMON_SLICE.get(),ModItems.COD_ROLL.get(), ModItems.SALMON_ROLL.get());
        this.tag(ItemTags.WOLF_FOOD).add(MPDItems.BROKEN_BONES.get()).addTag(MyCommonTags.ROTTEN_MEALS).add(MNDIntegration.HALF_A_HOTDOG.get());;
    }

    public void registerCompatibilityTags() {
        this.tag(CompatibilityTags.BOILED_EGG_CANDIDATE).add(Items.TURTLE_EGG);
        this.tag(CompatibilityTags.FOOD_JERKY_MEAT).addTag(MyCommonTags.ROTTEN_MEALS);
        this.tag(CompatibilityTags.FOOD_PIZZA_TOPPING).add(MPDItems.COOKED_FROG_LEG.get(), MPDItems.POT_SLICE.get(), MPDItems.COOKED_GUARDIAN_SLICE.get(), MPDItems.COOKED_ELDER_GUARDIAN_SLICE.get(), MPDItems.MINT_LETTUCE.get());
    }
}