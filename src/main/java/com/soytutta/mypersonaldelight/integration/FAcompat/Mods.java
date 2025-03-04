package com.soytutta.mypersonaldelight.integration.FAcompat;

import net.neoforged.fml.ModList;

public enum Mods {
    MYNETHERSDELIGHT,
    BREWINANDCHEWIN;

    private final String id;

    Mods() {
        id = name().toLowerCase();
    }

    public boolean isLoaded() {
        return ModList.get().isLoaded(id);
    }
}