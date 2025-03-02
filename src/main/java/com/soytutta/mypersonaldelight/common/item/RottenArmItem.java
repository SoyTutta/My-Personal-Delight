package com.soytutta.mypersonaldelight.common.item;

import com.soytutta.mypersonaldelight.common.utility.MPDTextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import vectorwing.farmersdelight.common.Configuration;

import java.util.List;

public class RottenArmItem extends SwordItem {
    public RottenArmItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            MutableComponent textEmpty = MPDTextUtils.getTranslation("tooltip." + BuiltInRegistries.ITEM.getKey(this).getPath());
            tooltip.add(textEmpty.withStyle(ChatFormatting.DARK_GREEN));
        }
    }
}
