package com.soytutta.mypersonaldelight.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CompatibilityTags {
    public static final TagKey<Item> HORROR_MEATS  = externalItemTag("brewinandchewin", "horror_meats");
    public static final TagKey<Item> RAW_MEATS = externalItemTag("brewinandchewin", "raw_meats");
    public static final TagKey<Item> BOILED_EGG_CANDIDATE = externalItemTag("mynethersdelight", "boiled_egg_candidate");

    public CompatibilityTags() {
    }

    private static TagKey<Item> externalItemTag(String modId, String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(modId, path));
    }
}
