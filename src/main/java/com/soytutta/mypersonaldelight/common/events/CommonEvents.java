package com.soytutta.mypersonaldelight.common.events;

import com.soytutta.mypersonaldelight.common.potion.MPDPotions;
import com.soytutta.mypersonaldelight.common.registry.MPDItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
public class CommonEvents {

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();
        builder.addMix(Potions.AWKWARD, MPDItems.RAW_FROG_LEG.get(), MPDPotions.FROGGY_POTION);
        builder.addMix(MPDPotions.FROGGY_POTION, Items.REDSTONE, MPDPotions.LONG_FROGGY_POTION);
        builder.addMix(MPDPotions.FROGGY_POTION, Items.GLOWSTONE_DUST, MPDPotions.STRONG_FROGGY_POTION);
    }

   @SubscribeEvent
   public static void livingDie(LivingDeathEvent event){
       if (!event.getEntity().level().isClientSide
               && event.getEntity() instanceof Mob mob && event.getSource() != null
               && event.getSource().getDirectEntity() instanceof LivingEntity directSource
           && directSource.getItemInHand(InteractionHand.MAIN_HAND).is(MPDItems.ROTTEN_MEAT_ON_A_BONE.get())) {

           CompoundTag mobNBT = new CompoundTag();
           mob.save(mobNBT);

           if (mob instanceof Villager) {
               Villager villager = (Villager)mob;
               mob.level().playSound((Player) null, mob.getX(), mob.getY(), mob.getZ(), SoundEvents.ZOMBIE_VILLAGER_CONVERTED, SoundSource.PLAYERS, 1.0F, 1.0F);
               ZombieVillager zombieVillager = EntityType.ZOMBIE_VILLAGER.create(mob.level());
               if (zombieVillager != null) {
                   if (mob.isBaby()) {
                       zombieVillager.setBaby(true);
                   }

                   zombieVillager.setCanPickUpLoot(true);
                   zombieVillager.setVillagerData(villager.getVillagerData());
                   zombieVillager.moveTo(mob.getX(), mob.getY(), mob.getZ(), mob.getYRot(), mob.getXRot());
                   mob.level().addFreshEntity(zombieVillager);
                   mob.setInvisible(true);
                   return;
               }
           }

           Zombie fakerZombie = EntityType.ZOMBIE.create(mob.level());
           if (fakerZombie != null) {
               Mob mobCopy = (Mob)mob.getType().create(mob.level());
               if (mobCopy != null) {
                   mobCopy.setInvisible(true);
                   mobCopy.load(mobNBT);

                   mob.addTag("prevent_drops");
                   mobCopy.moveTo(mob.getX(), mob.getY(), mob.getZ(), mob.getYRot(), mob.getXRot());
                   mobCopy.setHealth(1);
                   fakerZombie.doHurtTarget(mobCopy);

                   mob.die(null);
               }
               fakerZombie.remove(Entity.RemovalReason.DISCARDED);
           }
       }
   }

   @SubscribeEvent
   public static void onMobDrop(LivingDropsEvent event) {
       if (event.getEntity() instanceof Mob mob && mob.getTags().contains("prevent_drops")) {
           event.getDrops().clear();
       }
   }
}
