package com.soytutta.mypersonaldelight;

import com.soytutta.mypersonaldelight.common.MPDCommonSetup;
import com.soytutta.mypersonaldelight.common.potion.MPDPotions;
import com.soytutta.mypersonaldelight.common.registry.*;
import com.soytutta.mypersonaldelight.integration.FAcompat.BnCIntegration;
import com.soytutta.mypersonaldelight.integration.FAcompat.MNDIntegration;
import com.soytutta.mypersonaldelight.integration.FAcompat.Mods;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vectorwing.farmersdelight.client.event.ClientSetupEvents;

@Mod(MyPersonalDelight.MODID)
public class MyPersonalDelight
{
    public static final String MODID = "mypersonaldelight";
    public static final Logger LOGGER = LogManager.getLogger();

    public MyPersonalDelight(IEventBus modEventBus) {
        modEventBus.addListener(MPDCommonSetup::init);

        MPDItems.ITEMS.register(modEventBus);
        if (Mods.MYNETHERSDELIGHT.isLoaded()) MNDIntegration.ITEMS.register(modEventBus);
        if (Mods.BREWINANDCHEWIN.isLoaded()) BnCIntegration.ITEMS.register(modEventBus);
        MPDBlocks.BLOCKS.register(modEventBus);
        MPDCreativeTab.TABS.register(modEventBus);
        MPDLootModifiers.LOOT_MODIFIERS.register(modEventBus);
        MPDPotions.register(modEventBus);
    }
}