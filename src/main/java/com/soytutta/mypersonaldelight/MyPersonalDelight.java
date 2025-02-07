package com.soytutta.mypersonaldelight;

import com.soytutta.mypersonaldelight.common.MPDCommonSetup;
import com.soytutta.mypersonaldelight.common.registry.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MyPersonalDelight.MODID)
public class MyPersonalDelight
{
    public static final String MODID = "mypersonaldelight";
    public static final Logger LOGGER = LogManager.getLogger();

    public MyPersonalDelight(IEventBus modEventBus) {
        modEventBus.addListener(MPDCommonSetup::init);

        MPDItems.ITEMS.register(modEventBus);
        MPDBlocks.BLOCKS.register(modEventBus);
        MPDCreativeTab.TABS.register(modEventBus);
        MPDLootModifiers.LOOT_MODIFIERS.register(modEventBus);
    }
}