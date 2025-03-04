package com.soytutta.mypersonaldelight.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.RandomSource;
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
            RandomSource random = level.getRandom();

            if (currentEffect != null) {
                int currentDuration = currentEffect.getDuration();
                int currentAmplifier = currentEffect.getAmplifier();

                if (currentDuration >= 1200 * (currentAmplifier + 1) && currentAmplifier < 4) {
                    newAmplifier = currentAmplifier + 1;
                    newDuration = 1200;
                } else {
                    newAmplifier = currentAmplifier;
                    newDuration = Math.min(currentDuration + 200, 6000);
                }

                double slimeChance = 0.05 * (newAmplifier + 1);

                if (random.nextDouble() < slimeChance) {
                    int slimeCount = (newAmplifier % 2 == 1) ? 2 : 1;
                    int slimeSize = (newAmplifier >= 2) ? 2 : 1;

                    for (int i = 0; i < slimeCount; i++) {
                        Slime slime = EntityType.SLIME.create(level);
                        if (slime != null) {
                            slime.setSize(slimeSize, true);
                            slime.setPos(consumer.getX() + (random.nextDouble() - 0.5) * 2,
                                    consumer.getY() + consumer.getEyeHeight(),
                                    consumer.getZ() + (random.nextDouble() - 0.5) * 2);

                            for (MobEffectInstance effect : consumer.getActiveEffects()) {
                                slime.addEffect(new MobEffectInstance(effect));
                            }

                            level.addFreshEntity(slime);
                        }
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
