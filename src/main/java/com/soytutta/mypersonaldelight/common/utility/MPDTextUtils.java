package com.soytutta.mypersonaldelight.common.utility;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class MPDTextUtils {
    public MPDTextUtils() {
    }
    public static MutableComponent getTranslation(String key, Object... args) {
        return Component.translatable("mypersonaldelight." + key, args);
    }
}
