package com.soytutta.mypersonaldelight.common.registry;

import com.soytutta.mypersonaldelight.MyPersonalDelight;
import com.soytutta.mypersonaldelight.common.utility.MPDTextUtils;
import net.minecraft.core.registries.*;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.registry.ModItems;

public class MPDCreativeTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyPersonalDelight.MODID);

    public static final DeferredHolder<CreativeModeTab,
            CreativeModeTab> MY_PERSONAL_DELIGHT_TAB = TABS.register("main",
            () -> CreativeModeTab.builder()
                .title(MPDTextUtils.getTranslation("itemGroup.main"))
                .icon(MPDItems.ANCIENT_SOFT_BOILED_EGG_AND_BREADS.get()::getDefaultInstance)
                .displayItems((parameters, output) -> {
                    output.accept(MPDItems.RAW_SUCKLING_PIG.get());
                    output.accept(MPDItems.SUCKLING_PIG_WITH_VEGETABLES.get());
                    output.accept(MPDItems.PLATE_OF_MUZZLE_WITH_VEGETABLES.get());
                    output.accept(MPDItems.PLATE_OF_HAM_WITH_VEGETABLES.get());
                    output.accept(MPDItems.PLATE_OF_SUCKLING_PIG_WITH_VEGETABLES.get());

                    output.accept(MPDItems.RAW_BREADED_MEAT.get());
                    output.accept(MPDItems.COOKED_BREADED_MEAT.get());
                    output.accept(MPDItems.BREADED_MEAT_SANDWICH.get());
                    output.accept(MPDItems.HALF_A_BREADED_MEAT_SANDWICH.get());

                    output.accept(MPDItems.POTATO_SLICES.get());
                    output.accept(MPDItems.MASHED_POTATO.get());
                    output.accept(MPDItems.FRIES_POTATOES.get());
                    output.accept(MPDItems.POTATO_OMELET.get());
                    output.accept(MPDItems.NAPOLITANA_WITH_FRIES_POTATOES.get());
                    output.accept(MPDItems.BREADED_MEAT_WITH_MASHED_POTATO.get());
                    output.accept(MPDItems.MASHED_POTATO_WITH_MEATBALLS.get());
                    output.accept(MPDItems.POTATO_AND_MEAT_PIE.get());
                    output.accept(MPDItems.PLATE_OF_POTATO_AND_MEAT_PIE.get());

                    output.accept(MPDItems.BEET_AND_EGG_SALAD.get());
                    output.accept(MPDItems.PASTA_WITH_BEET.get());
                    output.accept(MPDItems.BEET_JUICE.get());

                    output.accept(ModItems.BACON_SANDWICH.get());
                    output.accept(MPDItems.HALF_A_BACON_SANDWICH.get());
                    output.accept(ModItems.EGG_SANDWICH.get());
                    output.accept(MPDItems.HALF_A_EGG_SANDWICH.get());
                    output.accept(ModItems.CHICKEN_SANDWICH.get());
                    output.accept(MPDItems.HALF_A_CHICKEN_SANDWICH.get());
                    output.accept(ModItems.HAMBURGER.get());
                    output.accept(MPDItems.HALF_A_HAMBURGER.get());

                    output.accept(ModItems.MELON_POPSICLE.get());
                    output.accept(MPDItems.GLISTERING_MELON_POPSICLE.get());
                    output.accept(MPDItems.COCOA_POPSICLE.get());
                    output.accept(MPDItems.MINT_POPSICLE.get());
                    output.accept(MPDItems.SWEET_BERRIES_POPSICLE.get());
                    output.accept(MPDItems.GLOW_BERRIES_POPSICLE.get());
                    output.accept(MPDItems.APPLE_POPSICLE.get());
                    output.accept(MPDItems.GOLDEN_APPLE_POPSICLE.get());;
                    output.accept(MPDItems.TORCH_POPSICLE.get());
                    output.accept(MPDItems.ICE_CREAM_IN_A_PUMPKIN_HEAD.get());
                    output.accept(MPDItems.PUMPKIN_HEAD_SLICE.get());

                    output.accept(MPDItems.SLIMECUBE.get());
                    output.accept(MPDItems.SLIME_DUMPLINGS.get());
                    output.accept(MPDItems.SQUISHMALLOW.get());
                    output.accept(MPDItems.SMOKED_SQUISHMALLOW.get());
                    output.accept(MPDItems.STICKY_GREEN_NOODLES.get());
                    output.accept(MPDItems.SLIME_JELLY.get());
                    output.accept(MPDItems.SLIME_JELLY_SLICE.get());

                    output.accept(MPDItems.MINT_LETTUCE.get());
                    output.accept(MPDItems.SWEET_TRIGGER.get());
                    output.accept(MPDItems.CREEPER_SALAD.get());
                    output.accept(MPDItems.MINT_ROULETTE.get());

                    output.accept(MPDItems.GUARDIAN.get());
                    output.accept(MPDItems.GUARDIAN_HEAD.get());
                    output.accept(MPDItems.RAW_GUARDIAN_TAIL.get());
                    output.accept(MPDItems.SMOKED_GUARDIAN_TAIL.get());
                    output.accept(MPDItems.RAW_GUARDIAN_SLICE.get());
                    output.accept(MPDItems.COOKED_GUARDIAN_SLICE.get());
                    output.accept(MPDItems.GUARDIAN_GRILLED_ON_A_STICK.get());
                    output.accept(MPDItems.POTLUCK_SOUP.get());
                    output.accept(MPDItems.FIRST_PLATE_OF_POTLUCK_SOUP.get());
                    output.accept(MPDItems.PLATE_OF_POTLUCK_SOUP.get());
                    output.accept(MPDItems.TAIL_IN_PLATE_OF_POTLUCK_SOUP.get());

                    output.accept(MPDItems.ELDER_GUARDIAN.get());
                    output.accept(MPDItems.ELDER_GUARDIAN_HEAD.get());
                    output.accept(MPDItems.RAW_ELDER_GUARDIAN_TAIL.get());
                    output.accept(MPDItems.SMOKED_ELDER_GUARDIAN_TAIL.get());
                    output.accept(MPDItems.RAW_ELDER_GUARDIAN_SLICE.get());
                    output.accept(MPDItems.COOKED_ELDER_GUARDIAN_SLICE.get());
                    output.accept(MPDItems.ELDER_GUARDIAN_GRILLED_ON_A_STICK.get());
                    output.accept(MPDItems.ELDER_POTLUCK_SOUP.get());
                    output.accept(MPDItems.FIRST_PLATE_OF_ELDER_POTLUCK_SOUP.get());
                    output.accept(MPDItems.PLATE_OF_ELDER_POTLUCK_SOUP.get());
                    output.accept(MPDItems.TAIL_IN_PLATE_OF_ELDER_POTLUCK_SOUP.get());

                    output.accept(MPDItems.POT_SLICE.get());
                    output.accept(MPDItems.ANCIENT_BOILED_EGG.get());
                    output.accept(MPDItems.ANCIENT_RIBS.get());
                    output.accept(MPDItems.COOKED_ANCIENT_RIBS.get());
                    output.accept(MPDItems.RIBS_WITH_EGGS.get());
                    output.accept(MPDItems.ANCIENT_RIBS_WITH_SEEDS.get());
                    output.accept(MPDItems.ANCIENT_BREAKFAST.get());
                    output.accept(MPDItems.PASTA_WITH_POT.get());
                    output.accept(MPDItems.POT_WITH_HONEY_ON_A_STICK.get());
                    output.accept(MPDItems.ANCIENT_SALAD.get());
                    output.accept(MPDItems.ANCIENT_EGG_SANDWICH.get());
                    output.accept(MPDItems.HALF_A_ANCIENT_EGG_SANDWICH.get());
                    output.accept(MPDItems.ANCIENT_SOFT_BOILED_EGG_AND_BREADS.get());
                    output.accept(MPDItems.PLATE_OF_ANCIENT_SOFT_BOILED_EGG_AND_BREAD.get());

                    output.accept(MPDItems.BROKEN_BONES.get());
                    output.accept(MPDItems.ROTTEN_HAM.get());
                    output.accept(MPDItems.ROTTEN_BACON.get());
                    output.accept(MPDItems.ROTTEN_MINCED_BEEF.get());
                    output.accept(MPDItems.ROTTEN_MUTTON_CHOPS.get());
                    output.accept(MPDItems.ROTTEN_CHICKEN_CUTS.get());
                    output.accept(MPDItems.ROTTEN_SAUSAGE.get());
                    output.accept(MPDItems.ROTTEN_MEAT_ON_A_BONE.get());
                    output.accept(MPDItems.DISGUSTING_STEW.get());
                }
        ).build()
    );
}