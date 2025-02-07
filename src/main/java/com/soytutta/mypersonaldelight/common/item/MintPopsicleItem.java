package com.soytutta.mypersonaldelight.common.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.Random;

public class MintPopsicleItem extends ConsumableItem {
    private static final Random RANDOM = new Random();

    public MintPopsicleItem(Properties properties) {
        super(properties);
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        consumer.clearFire();
        if (consumer.hasEffect(MobEffects.CONFUSION)) {
            consumer.removeEffect(MobEffects.CONFUSION);
        } else if (consumer.hasEffect(MobEffects.POISON)) {
            consumer.removeEffect(MobEffects.POISON);
        }
        if (RANDOM.nextDouble() < 0.25) {
            level.explode(null, consumer.getX(), consumer.getEyeY(), consumer.getZ(), 0.25F, Level.ExplosionInteraction.NONE);
            consumer.hurt(consumer.damageSources().magic(), 4.0F);
        }
    }
}
