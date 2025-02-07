package com.soytutta.mypersonaldelight.common.tag;

import com.soytutta.mypersonaldelight.MyPersonalDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MPDTags {

    private static TagKey<Item> modItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MyPersonalDelight.MODID, path));
    }

    private static TagKey<Block> modBlockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MyPersonalDelight.MODID, path));
    }

    private static TagKey<EntityType<?>> modEntityTag(String path) {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MyPersonalDelight.MODID, path));
    }

}