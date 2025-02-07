package com.soytutta.mypersonaldelight.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Objects;

public class SlimeJellyItem extends SlimeConsumableItem {
    public SlimeJellyItem(Properties properties) {
        super(properties);
    }

    public ItemStack getDefaultInstance() {
        ItemStack itemstack = super.getDefaultInstance();
        itemstack.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER));
        return itemstack;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        Player player = entityLiving instanceof Player ? (Player)entityLiving : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
        }

        if (!level.isClientSide) {
            PotionContents potionContents = stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
            potionContents.forEachEffect(effect -> {
                MobEffect mobEffect = effect.getEffect().value();
                if (mobEffect.isInstantenous()) {
                    mobEffect.applyInstantenousEffect(player, player, entityLiving, effect.getAmplifier(), 1.0F);
                } else {
                    entityLiving.addEffect(effect);
                }
            });
        }


        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            stack.consume(1, player);
        }

        return stack;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    public String getDescriptionId(ItemStack stack) {
        return Potion.getName((stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY)).potion(), this.getDescriptionId() + ".effect.");
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        PotionContents potioncontents = stack.get(DataComponents.POTION_CONTENTS);
        if (potioncontents != null) {
            Objects.requireNonNull(tooltipComponents);
            potioncontents.addPotionTooltip(tooltipComponents::add, 1.0F, context.tickRate());
        }
    }
}