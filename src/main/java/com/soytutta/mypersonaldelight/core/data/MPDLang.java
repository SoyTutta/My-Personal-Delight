//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.soytutta.mypersonaldelight.core.data;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.soytutta.mypersonaldelight.common.registry.MPDBlocks;
import com.soytutta.mypersonaldelight.common.registry.MPDItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class MPDLang extends LanguageProvider {
    private final Set<String> addedKeys = new HashSet<>();

    public MPDLang(PackOutput output) {
        super(output, "mypersonaldelight", "en_us");
    }

    @Override
    protected void addTranslations() {
        Set<Supplier<Block>> blocks = MPDBlocks.BLOCKS.getEntries().stream()
                .map(entry -> (Supplier<Block>) entry::get)
                .collect(Collectors.toSet());
        Set<Supplier<Item>> items = MPDItems.ITEMS.getEntries().stream()
                .map(entry -> (Supplier<Item>) entry::get)
                .collect(Collectors.toSet());

        blocks.forEach((b) -> {
            String descriptionId = b.get().getDescriptionId();
            if (addedKeys.add(descriptionId)) {
                String name = descriptionId.replaceFirst("block.mypersonaldelight.", "");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("Of", "of");
                this.add(descriptionId, name);
            }
        });

        items.removeIf((i) -> i.get() instanceof BlockItem);
        items.forEach((i) -> {
            String descriptionId = i.get().getDescriptionId();
            if (addedKeys.add(descriptionId)) {
                String name = descriptionId.replaceFirst("item.mypersonaldelight.", "");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("A", "a");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("On", "on");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("Of", "of");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("And", "and");
                name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("With", "with");
                this.add(descriptionId, name);
            }
        });

        addSlimeJellySliceVariants();

        addCustomTranslations();
    }

    private void addSlimeJellySliceVariants() {
        Set<String> potionEffects = getPotionEffectNames();

        for (String effect : potionEffects) {
            String effectCapitalized = toTitleCase(effect, "_");
            String translationKey = String.format("item.mypersonaldelight.slime_jelly_slice.effect.%s", effect.toLowerCase());
            String translationValue = String.format("Slime Jelly Slice of %s", effectCapitalized);

            if (addedKeys.add(translationKey)) {
                this.add(translationKey, translationValue);
            }
        }
    }

    private Set<String> getPotionEffectNames() {
        return net.minecraft.core.registries.BuiltInRegistries.MOB_EFFECT.stream()
                .map(effect -> BuiltInRegistries.MOB_EFFECT.getKey(effect).getPath())
                .collect(Collectors.toSet());
    }

    private void addCustomTranslations() {
        this.add("mypersonaldelight.itemGroup.main", "My Personal Delight");
        this.add("item.mypersonaldelight.slime_jelly_slice.effect.empty", "Slime Jelly Slice");
        this.add("mypersonaldelight.block.meat_excess.use_container", "This needs a few more Veggies!");
        this.add("mypersonaldelight.block.veggies_excess.use_container", "This needs a few more Meat!");
        this.add("mypersonaldelight.block.tasteless.use_container", "There's some leftover soup, Try adding water!");
        this.add("mypersonaldelight.block.needheat.use_container", "You need a heat source for cooking.");
        this.add("mypersonaldelight.block.feastalt.use_container", "You need a %s or a %s to eat this.");
        this.add("mypersonaldelight.block.snowgolemfeast.use_container", "You need a %s to eat this.");
    }

    @Override
    public String getName() {
        return "Lang Entries";
    }

    public static String toTitleCase(String givenString, String regex) {
        String[] stringArray = givenString.split(regex);
        StringBuilder stringBuilder = new StringBuilder();
        String[] var4 = stringArray;
        int var5 = stringArray.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            String string = var4[var6];
            stringBuilder.append(Character.toUpperCase(string.charAt(0))).append(string.substring(1)).append(regex);
        }

        return stringBuilder.toString().trim().replaceAll(regex, " ").substring(0, stringBuilder.length() - 1);
    }

    public String correctBlockItemName(String name) {
        if (!name.endsWith("_bricks") && name.contains("bricks")) {
            name = name.replaceFirst("bricks", "brick");
        }

        if ((name.contains("_fence") || name.contains("_button")) && name.contains("planks")) {
            name = name.replaceFirst("_planks", "");
        }

        return name;
    }
}