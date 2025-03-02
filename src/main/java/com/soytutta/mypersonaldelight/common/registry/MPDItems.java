//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mypersonaldelight.common.registry;

import com.soytutta.mypersonaldelight.common.item.*;
import com.soytutta.mypersonaldelight.common.utility.MPDFoodValues;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.PopsicleItem;

import java.util.function.Supplier;

public class MPDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, "mypersonaldelight");

    public static Item.Properties basicItem() {
        return (new Item.Properties());
    }

    public static Item.Properties foodItem(FoodProperties food) {
        return (new Item.Properties()).food(food);
    }

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return (new Item.Properties()).food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }
    public static Item.Properties drinkItem() {
        return (new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }

    /// Dungeons & Delights
    /// Slime
    /// /// ingredients
    public static final Supplier<Item> SLIMECUBE = ITEMS.register("slimecube", ()  ->
            new Item(basicItem())
    );
    /// /// meals
    public static final Supplier<Item> SLIME_DUMPLINGS = ITEMS.register("slime_dumplings", ()  ->
            new SlimeConsumableItem(foodItem(MPDFoodValues.SLIME_DUMPLINGS))
    );
    public static final Supplier<Item> SQUISHMALLOW = ITEMS.register("squishmallow", ()  ->
            new SlimeConsumableItem(foodItem(MPDFoodValues.SQUISHMALLOW))
    );
    public static final Supplier<Item> SMOKED_SQUISHMALLOW = ITEMS.register("smoked_squishmallow", ()  ->
            new SlimeConsumableItem(foodItem(MPDFoodValues.SMOKED_SQUISHMALLOW))
    );
    public static final Supplier<Item> STICKY_GREEN_NOODLES = ITEMS.register("sticky_green_noodles", ()  ->
            new SlimeConsumableItem(bowlFoodItem(MPDFoodValues.STICKY_GREEN_NOODLES), true)
    );
    /// /// feasts
    public static final Supplier<Item> SLIME_JELLY = ITEMS.register("slime_jelly", ()  ->
            new Item(basicItem().stacksTo(1))
    );
    public static final Supplier<Item> SLIME_JELLY_SLICE = ITEMS.register("slime_jelly_slice", ()  ->
            new SlimeConsumableItem(foodItem(MPDFoodValues.SLIME_JELLY_SLICE))
    );
    /// Creeper
    /// /// ingredients
    public static final Supplier<Item> MINT_LETTUCE = ITEMS.register("mint_lettuce", ()  ->
            new MintConsumableItem(foodItem(MPDFoodValues.MINT_LETTUCE))
    );
    /// /// meals
    public static final Supplier<Item> SWEET_TRIGGER = ITEMS.register("sweet_trigger", ()  ->
            new MintConsumableItem(foodItem(MPDFoodValues.SWEET_TRIGGER))
    );
    public static final Supplier<Item> CREEPER_SALAD = ITEMS.register("creeper_salad", ()  ->
            new CreeperSaladItem(bowlFoodItem(MPDFoodValues.CREEPER_SALAD))
    );
    /// /// feasts
    public static final Supplier<Item> MINT_ROULETTE = ITEMS.register("mint_roulette", ()  ->
            new BlockItem(MPDBlocks.MINT_ROULETTE_BLOCK.get(), basicItem().stacksTo(1))
    );
    /// Undead
    /// /// ingredients
    public static final Supplier<Item> BROKEN_BONES = ITEMS.register("broken_bones", ()  ->
            new Item(basicItem())
    );
    public static final Supplier<Item> ROTTEN_BACON = ITEMS.register("rotten_bacon", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.ROTTEN_BACON))
    );
    public static final Supplier<Item> ROTTEN_MINCED_BEEF = ITEMS.register("rotten_minced_beef", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.ROTTEN_MINCED_BEEF))
    );
    public static final Supplier<Item> ROTTEN_MUTTON_CHOPS = ITEMS.register("rotten_mutton_chops", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.ROTTEN_MUTTON_CHOPS))
    );
    public static final Supplier<Item> ROTTEN_CHICKEN_CUTS = ITEMS.register("rotten_chicken_cuts", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.ROTTEN_CHICKEN_CUTS))
    );
    public static final Supplier<Item> ROTTEN_SAUSAGE = ITEMS.register("rotten_sausage", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.ROTTEN_SAUSAGE))
    );
    public static final Supplier<Item> ROTTEN_MEAT_ON_A_BONE = ITEMS.register("rotten_meat_on_a_bone", ()  ->
            new RottenArmItem(MPDTiers.ROTTEN, foodItem(MPDFoodValues.ROTTEN_MEAT_ON_A_BONE)
                    .attributes(SwordItem.createAttributes(MPDTiers.ROTTEN, 3, -2.0F)))
    );
    public static final Supplier<Item> ROTTEN_HAM = ITEMS.register("rotten_ham", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.ROTTEN_HAM))
    );
    /// /// meals
    public static final Supplier<Item> DISGUSTING_STEW = ITEMS.register("disgusting_stew", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.DISGUSTING_STEW), true)
    );
    /// Guardian
    /// /// ingredients
    public static final Supplier<Item> GUARDIAN = ITEMS.register("guardian", ()  ->
            new Item(basicItem().stacksTo(1))
    );

    public static final Supplier<Item> GUARDIAN_HEAD = ITEMS.register("guardian_head", ()  ->
            new Item(basicItem())
    );
    public static final Supplier<Item> RAW_GUARDIAN_TAIL = ITEMS.register("raw_guardian_tail", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.RAW_GUARDIAN_TAIL))
    );
    public static final Supplier<Item> SMOKED_GUARDIAN_TAIL = ITEMS.register("smoked_guardian_tail", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.SMOKED_GUARDIAN_TAIL))
    );
    public static final Supplier<Item> RAW_GUARDIAN_SLICE = ITEMS.register("raw_guardian_slice", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.RAW_GUARDIAN_SLICE))
    );
    public static final Supplier<Item> COOKED_GUARDIAN_SLICE = ITEMS.register("cooked_guardian_slice", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.COOKED_GUARDIAN_SLICE))
    );
    /// /// meals
    public static final Supplier<Item> GUARDIAN_GRILLED_ON_A_STICK = ITEMS.register("guardian_grilled_on_a_stick", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.GUARDIAN_GRILLED_ON_A_STICK))
    );
    /// /// feasts
    public static final Supplier<Item> POTLUCK_SOUP = ITEMS.register("potluck_soup", ()  ->
            new BlockItem(MPDBlocks.POTLUCK_SOUP_BLOCK.get(), basicItem().stacksTo(1))
    );
    public static final Supplier<Item> FIRST_PLATE_OF_POTLUCK_SOUP = ITEMS.register("first_plate_of_potluck_soup", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.FIRST_PLATE_OF_POTLUCK_SOUP), true)
    );
    public static final Supplier<Item> PLATE_OF_POTLUCK_SOUP = ITEMS.register("plate_of_potluck_soup", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.PLATE_OF_POTLUCK_SOUP), true)
    );
    public static final Supplier<Item> TAIL_IN_PLATE_OF_POTLUCK_SOUP = ITEMS.register("tail_in_plate_of_potluck_soup", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.TAIL_IN_PLATE_OF_POTLUCK_SOUP), true)
    );
    /// Elder Guardian
    /// /// ingredients
    public static final Supplier<Item> ELDER_GUARDIAN = ITEMS.register("elder_guardian", ()  ->
            new Item(basicItem().stacksTo(1).rarity(Rarity.EPIC))
    );

    public static final Supplier<Item> ELDER_GUARDIAN_HEAD = ITEMS.register("elder_guardian_head", ()  ->
            new Item(basicItem().rarity(Rarity.RARE))
    );
    public static final Supplier<Item> RAW_ELDER_GUARDIAN_TAIL = ITEMS.register("raw_elder_guardian_tail", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.RAW_ELDER_GUARDIAN_TAIL).rarity(Rarity.RARE))
    );
    public static final Supplier<Item> SMOKED_ELDER_GUARDIAN_TAIL = ITEMS.register("smoked_elder_guardian_tail", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.SMOKED_ELDER_GUARDIAN_TAIL).rarity(Rarity.RARE))
    );
    public static final Supplier<Item> RAW_ELDER_GUARDIAN_SLICE = ITEMS.register("raw_elder_guardian_slice", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.RAW_ELDER_GUARDIAN_SLICE).rarity(Rarity.RARE))
    );
    public static final Supplier<Item> COOKED_ELDER_GUARDIAN_SLICE = ITEMS.register("cooked_elder_guardian_slice", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.COOKED_ELDER_GUARDIAN_SLICE).rarity(Rarity.RARE))
    );
    /// /// meals
    public static final Supplier<Item> ELDER_GUARDIAN_GRILLED_ON_A_STICK = ITEMS.register("elder_guardian_grilled_on_a_stick", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.ELDER_GUARDIAN_GRILLED_ON_A_STICK).rarity(Rarity.RARE))
    );
    /// /// feasts
    public static final Supplier<Item> ELDER_POTLUCK_SOUP = ITEMS.register("elder_potluck_soup", ()  ->
            new Item(basicItem().stacksTo(1).rarity(Rarity.EPIC))
    );
    public static final Supplier<Item> FIRST_PLATE_OF_ELDER_POTLUCK_SOUP = ITEMS.register("first_plate_of_elder_potluck_soup", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.FIRST_PLATE_OF_ELDER_POTLUCK_SOUP).rarity(Rarity.RARE), true)
    );
    public static final Supplier<Item> PLATE_OF_ELDER_POTLUCK_SOUP = ITEMS.register("plate_of_elder_potluck_soup", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.PLATE_OF_ELDER_POTLUCK_SOUP).rarity(Rarity.RARE), true)
    );
    public static final Supplier<Item> TAIL_IN_PLATE_OF_ELDER_POTLUCK_SOUP = ITEMS.register("tail_in_plate_of_elder_potluck_soup", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.TAIL_IN_PLATE_OF_ELDER_POTLUCK_SOUP).rarity(Rarity.RARE), true)
    );
    /// Sniffers
    /// /// ingredients
    public static final Supplier<Item> POT_SLICE = ITEMS.register("pot_slice", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.POT_SLICE))
    );
    public static final Supplier<Item> ANCIENT_BOILED_EGG = ITEMS.register("ancient_boiled_egg", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.ANCIENT_BOILED_EGG))
    );
    public static final Supplier<Item> ANCIENT_RIBS = ITEMS.register("ancient_ribs", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.ANCIENT_RIBS))
    );
    public static final Supplier<Item> COOKED_ANCIENT_RIBS = ITEMS.register("cooked_ancient_ribs", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.COOKED_ANCIENT_RIBS))
    );
    /// /// meals
    public static final Supplier<Item> RIBS_WITH_EGGS = ITEMS.register("ribs_with_eggs", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.RIBS_WITH_EGGS), true)
    );
    public static final Supplier<Item> ANCIENT_RIBS_WITH_SEEDS = ITEMS.register("ancient_ribs_with_seeds", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.ANCIENT_RIBS_WITH_SEEDS), true)
    );
    public static final Supplier<Item> ANCIENT_BREAKFAST = ITEMS.register("ancient_breakfast", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.ANCIENT_BREAKFAST), true)
    );
    public static final Supplier<Item> PASTA_WITH_POT = ITEMS.register("pasta_with_pot", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.PASTA_WITH_POT), true)
    );
    public static final Supplier<Item> POT_WITH_HONEY_ON_A_STICK = ITEMS.register("pot_with_honey_on_a_stick", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.POT_WITH_HONEY_ON_A_STICK))
    );
    public static final Supplier<Item> ANCIENT_SALAD = ITEMS.register("ancient_salad", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.ANCIENT_SALAD),false)
    );
    public static final Supplier<Item> ANCIENT_EGG_SANDWICH = ITEMS.register("ancient_egg_sandwich", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.ANCIENT_EGG_SANDWICH),false)
    );
    public static final Supplier<Item> HALF_A_ANCIENT_EGG_SANDWICH = ITEMS.register("half_a_ancient_egg_sandwich", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.HALF_A_ANCIENT_EGG_SANDWICH),false)
    );
    /// /// feasts
    public static final Supplier<Item> ANCIENT_SOFT_BOILED_EGG_AND_BREADS = ITEMS.register("ancient_soft-boiled_egg_and_breads", () ->
            new BlockItem(MPDBlocks.ANCIENT_SOFT_BOILED_EGG_AND_BREADS_BLOCK.get(), basicItem().stacksTo(1))
    );
    public static final Supplier<Item> PLATE_OF_ANCIENT_SOFT_BOILED_EGG_AND_BREAD = ITEMS.register("plate_of_ancient_soft-boiled_egg_and_bread", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.PLATE_OF_ANCIENT_SOFT_BOILED_EGG_AND_BREAD), true)
    );

    /// Breaded Delights
    /// /// ingredients
    public static final Supplier<Item> RAW_BREADED_MEAT = ITEMS.register("raw_breaded_meat", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.RAW_BREADED_MEAT))
    );
    public static final Supplier<Item> COOKED_BREADED_MEAT = ITEMS.register("cooked_breaded_meat", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.COOKED_BREADED_MEAT))
    );
    /// /// meals
    public static final Supplier<Item> BREADED_MEAT_SANDWICH = ITEMS.register("breaded_meat_sandwich", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.BREADED_MEAT_SANDWICH))
    );
    public static final Supplier<Item> HALF_A_BREADED_MEAT_SANDWICH = ITEMS.register("half_a_breaded_meat_sandwich", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.HALF_A_BREADED_MEAT_SANDWICH))
    );

    /// Potato Delight
    /// /// ingredients
    public static final Supplier<Item> POTATO_SLICES = ITEMS.register("potato_slices", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.POTATO_SLICES))
    );
    public static final Supplier<Item> BAKED_POTATO_SLICES = ITEMS.register("baked_potato_slices", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.BAKED_POTATO_SLICES))
    );
    public static final Supplier<Item> MASHED_POTATO = ITEMS.register("mashed_potato", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.MASHED_POTATO))
    );
    public static final Supplier<Item> FRIES_POTATOES = ITEMS.register("fries_potatoes", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.FRIES_POTATOES))
    );
    /// /// meals
    public static final Supplier<Item> POTATO_OMELET = ITEMS.register("potato_omelet", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.POTATO_OMELET), true)
    );
    public static final Supplier<Item> NAPOLITANA_WITH_FRIES_POTATOES = ITEMS.register("napolitana_with_fries_potatoes", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.NAPOLITANA_WITH_FRIES_POTATOES), true)
    );
    public static final Supplier<Item> BREADED_MEAT_WITH_MASHED_POTATO = ITEMS.register("breaded_meat_with_mashed_potato", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.BREADED_MEAT_WITH_MASHED_POTATO), true)
    );
    public static final Supplier<Item> BREADED_MEAT_WITH_PASTA = ITEMS.register("breaded_meat_with_pasta", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.BREADED_MEAT_WITH_PASTA), true)
    );
    public static final Supplier<Item> MASHED_POTATO_WITH_MEATBALLS = ITEMS.register("mashed_potato_with_meatballs", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.MASHED_POTATO_WITH_MEATBALLS), true)
    );
    /// /// feasts
    public static final Supplier<Item> POTATO_AND_MEAT_PIE = ITEMS.register("potato_and_meat_pie", ()  ->
            new BlockItem(MPDBlocks.POTATO_AND_MEAT_PIE_BLOCK.get(), basicItem().stacksTo(1))
    );
    public static final Supplier<Item> PLATE_OF_POTATO_AND_MEAT_PIE = ITEMS.register("plate_of_potato_and_meat_pie", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.PLATE_OF_POTATO_AND_MEAT_PIE), true)
    );
    /// Extra Delights
    /// /// frog
    public static final Supplier<Item> RAW_FROG_LEG = ITEMS.register("raw_frog_leg", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.RAW_FROG_LEG))
    );
    public static final Supplier<Item> COOKED_FROG_LEG = ITEMS.register("cooked_frog_leg", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.COOKED_FROG_LEG))
    );
    public static final Supplier<Item> FROG_LEG_ON_A_STICK = ITEMS.register("frog_legs_on_a_stick", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.FROG_LEG_ON_A_STICK))
    );
    public static final Supplier<Item> HONEY_NUGGETS = ITEMS.register("honey_nuggets", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.HONEY_NUGGETS))
    );
    /// /// pig
    public static final Supplier<Item> RAW_SUCKLING_PIG = ITEMS.register("raw_suckling_pig", ()  ->
            new Item(basicItem().stacksTo(1))
    );
    public static final Supplier<Item> SUCKLING_PIG_WITH_VEGETABLES = ITEMS.register("suckling_pig_with_vegetables", ()  ->
            new BlockItem(MPDBlocks.SUCKLING_PIG_WITH_VEGETABLES_BLOCK.get(), basicItem().stacksTo(1))
    );
    public static final Supplier<Item> PLATE_OF_MUZZLE_WITH_VEGETABLES = ITEMS.register("plate_of_muzzle_with_vegetables", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.PLATE_OF_MUZZLE_WITH_VEGETABLES), true)
    );
    public static final Supplier<Item> PLATE_OF_HAM_WITH_VEGETABLES = ITEMS.register("plate_of_ham_with_vegetables", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.PLATE_OF_HAM_WITH_VEGETABLES), true)
    );
    public static final Supplier<Item> PLATE_OF_SUCKLING_PIG_WITH_VEGETABLES = ITEMS.register("plate_of_suckling_pig_with_vegetables", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.PLATE_OF_SUCKLING_PIG_WITH_VEGETABLES), true)
    );
    /// /// pops
    public static final Supplier<Item> GLISTERING_MELON_POPSICLE = ITEMS.register("glistering_melon_popsicle", ()  ->
            new PopsicleItem(foodItem(MPDFoodValues.GLISTERING_MELON_POPSICLE).rarity(Rarity.UNCOMMON))
    );
    public static final Supplier<Item> COCOA_POPSICLE = ITEMS.register("cocoa_popsicle", ()  ->
            new PopsicleItem(foodItem(MPDFoodValues.COCOA_POPSICLE).rarity(Rarity.UNCOMMON))
    );

    public static final Supplier<Item> MINT_POPSICLE = ITEMS.register("mint_popsicle", ()  ->
            new MintPopsicleItem(foodItem(MPDFoodValues.MINT_POPSICLE).rarity(Rarity.UNCOMMON))
    );
    public static final Supplier<Item> SWEET_BERRIES_POPSICLE = ITEMS.register("sweet_berries_popsicle", ()  ->
            new PopsicleItem(foodItem(MPDFoodValues.SWEET_BERRIES_POPSICLE))
    );
    public static final Supplier<Item> GLOW_BERRIES_POPSICLE = ITEMS.register("glow_berries_popsicle", ()  ->
            new PopsicleItem(foodItem(MPDFoodValues.GLOW_BERRIES_POPSICLE).rarity(Rarity.UNCOMMON))
    );
    public static final Supplier<Item> APPLE_POPSICLE = ITEMS.register("apple_popsicle", ()  ->
            new PopsicleItem(foodItem(MPDFoodValues.APPLE_POPSICLE))
    );
    public static final Supplier<Item> GOLDEN_APPLE_POPSICLE = ITEMS.register("golden_apple_popsicle", ()  ->
            new PopsicleItem(foodItem(MPDFoodValues.GOLDEN_APPLE_POPSICLE).rarity(Rarity.UNCOMMON))
    );
    public static final Supplier<Item> TORCH_POPSICLE = ITEMS.register("torch_popsicle", ()  ->
            new PopsicleItem(foodItem(MPDFoodValues.TORCH_POPSICLE).rarity(Rarity.UNCOMMON))
    );
    /// /// IceCream
    public static final Supplier<Item> ICE_CREAM_IN_A_PUMPKIN_HEAD = ITEMS.register("ice_cream_in_a_pumpkin_head", ()  ->
            new BlockItem(MPDBlocks.ICE_CREAM_IN_A_PUMPKIN_HEAD_BLOCK.get(), basicItem().stacksTo(1).rarity(Rarity.UNCOMMON))
    );
    public static final Supplier<Item> PUMPKIN_HEAD_SLICE = ITEMS.register("pumpkin_head_slice", ()  ->
            new PopsicleItem(foodItem(MPDFoodValues.PUMPKIN_HEAD_SLICE).rarity(Rarity.UNCOMMON))
    );
    /// /// meals
    public static final Supplier<Item> BEET_AND_EGG_SALAD = ITEMS.register("beet_and_egg_salad", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.BEET_AND_EGG_SALAD), false)
    );
    public static final Supplier<Item> PASTA_WITH_BEET = ITEMS.register("pasta_with_beet", ()  ->
            new ConsumableItem(bowlFoodItem(MPDFoodValues.PASTA_WITH_BEET), true)
    );
    public static final Supplier<Item> BEET_JUICE = ITEMS.register("beet_juice", ()  ->
            new DrinkableItem(drinkItem().food(MPDFoodValues.BEET_JUICE), true, false)
    );
    /// /// half sandwich
    public static final Supplier<Item> HALF_A_BACON_SANDWICH = ITEMS.register("half_a_bacon_sandwich", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.HALF_A_BACON_SANDWICH))
    );
    public static final Supplier<Item> HALF_A_EGG_SANDWICH = ITEMS.register("half_a_egg_sandwich", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.HALF_A_EGG_SANDWICH))
    );
    public static final Supplier<Item> HALF_A_CHICKEN_SANDWICH = ITEMS.register("half_a_chicken_sandwich", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.HALF_A_CHICKEN_SANDWICH))
    );
    public static final Supplier<Item> HALF_A_HAMBURGER = ITEMS.register("half_a_hamburger", ()  ->
            new ConsumableItem(foodItem(MPDFoodValues.HALF_A_HAMBURGER))
    );
}
