//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mypersonaldelight.core.data;

import com.soytutta.mypersonaldelight.MyPersonalDelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import java.util.Set;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = MyPersonalDelight.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MPDDataGenerators {

    public MPDDataGenerators() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        MPDBlockTags blockTags = new MPDBlockTags(output, lookupProvider, helper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new MPDItemTags(output, lookupProvider, blockTags.contentsGetter(), helper));
        generator.addProvider(event.includeServer(), new MPDRecipes(output, lookupProvider));
        generator.addProvider(event.includeServer(), new MPDDataMaps(output, lookupProvider));
        generator.addProvider(event.includeClient(), new MPDLang(output));

        MPDBlockStates blockStates = new MPDBlockStates(output, helper);
        generator.addProvider(event.includeClient(), blockStates);

        generator.addProvider(true, new DatapackBuiltinEntriesProvider(
                output,
                lookupProvider,
                new RegistrySetBuilder(),
                Set.of(MyPersonalDelight.MODID)
        ));
    }
}
