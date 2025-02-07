package com.soytutta.mypersonaldelight.common;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class MPDCommonSetup {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(MPDCommonSetup::registerDispenserBehaviors);
    }

    public static void registerDispenserBehaviors() {
    }
}

