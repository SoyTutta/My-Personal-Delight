package com.soytutta.mypersonaldelight.common.registry;

import com.mojang.serialization.MapCodec;
import com.soytutta.mypersonaldelight.MyPersonalDelight;
import com.soytutta.mypersonaldelight.common.loot.RemplaceLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class MPDLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MyPersonalDelight.MODID);

    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> REMPLACE_LOOT =
            LOOT_MODIFIERS.register("remplace_item", RemplaceLootModifier.CODEC);
}