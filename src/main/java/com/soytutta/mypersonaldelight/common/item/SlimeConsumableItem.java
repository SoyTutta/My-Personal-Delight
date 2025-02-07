package com.soytutta.mypersonaldelight.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.List;
import java.util.Random;

public class SlimeConsumableItem extends ConsumableItem {
    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;

    public SlimeConsumableItem(Properties properties) {
        super(properties);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }

    public SlimeConsumableItem(Properties properties, boolean hasFoodEffectTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = false;
    }

    public SlimeConsumableItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            MobEffectInstance currentEffect = consumer.getEffect(MobEffects.OOZING);
            int newAmplifier = 0;
            int newDuration = 600;
            Random random = new Random();

            if (currentEffect != null) {
                newDuration = Math.min(currentEffect.getDuration() + 300, 6000 );
                double slimeChance = (Math.min(0.0001 * newDuration, 0.1) + Math.min(0.03 * newAmplifier, 0.2));

                if (random.nextDouble() < slimeChance) {
                    newAmplifier = Math.min(currentEffect.getAmplifier() + 1, 5);
                } else {
                    newAmplifier = currentEffect.getAmplifier();
                }

                if (random.nextDouble() < slimeChance) {
                    consumer.hurt(consumer.damageSources().magic(), 1.0F);

                    Slime slime = EntityType.SLIME.create(level);
                    if (slime != null) {
                        slime.setSize(1, true);
                        slime.setPos(consumer.getX(), consumer.getY() + consumer.getEyeHeight(), consumer.getZ());
                        level.addFreshEntity(slime);
                    }
                }
            }

            MobEffectInstance newEffect = new MobEffectInstance(MobEffects.OOZING, newDuration, newAmplifier);
            consumer.addEffect(newEffect);

        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            if (this.hasCustomTooltip) {
                MutableComponent textEmpty = TextUtils.getTranslation("tooltip." + BuiltInRegistries.ITEM.getKey(this).getPath());
                tooltip.add(textEmpty.withStyle(ChatFormatting.BLUE));
            }
            if (this.hasFoodEffectTooltip) {
                TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
            }
        }
    }
}
