package com.soytutta.mypersonaldelight.common.item;

import com.soytutta.mypersonaldelight.common.tag.MyCommonTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class MPDTiers {
    public static final Tier ROTTEN = new SimpleTier(BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            15, -2.0f, 0f, 5, () -> Ingredient.of(MyCommonTags.ROTTEN_MEALS));

}