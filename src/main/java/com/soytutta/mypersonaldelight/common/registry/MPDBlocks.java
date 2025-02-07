//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mypersonaldelight.common.registry;

import com.soytutta.mypersonaldelight.common.block.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.function.Supplier;

public class MPDBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, "mypersonaldelight");
    // Feasts
    public static final Supplier<Block> ANCIENT_SOFT_BOILED_EGG_AND_BREADS_BLOCK = BLOCKS.register("ancient_soft-boiled_egg_and_breads_block",
            () -> new AncientSoftBoiledEggBlock(Block.Properties.ofFullCopy(Blocks.CAKE), MPDItems.PLATE_OF_ANCIENT_SOFT_BOILED_EGG_AND_BREAD, true, MPDItems.ANCIENT_EGG_SANDWICH, ModItems.IRON_KNIFE, ModTags.KNIVES));
    public static final Supplier<Block> POTATO_AND_MEAT_PIE_BLOCK = BLOCKS.register("potato_and_meat_pie_block",
            () -> new PotatoAndMeatPieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), MPDItems.PLATE_OF_POTATO_AND_MEAT_PIE, true));
    public static final Supplier<Block> MINT_ROULETTE_BLOCK = BLOCKS.register("mint_roulette_block",
            () -> new MintRouletteBlock(Block.Properties.ofFullCopy(Blocks.CAKE), MPDItems.SWEET_TRIGGER, true));
    public static final Supplier<Block> ICE_CREAM_IN_A_PUMPKIN_HEAD_BLOCK = BLOCKS.register("ice_cream_in_a_pumpkin_head_block",
            () -> new SnowGolemFeastBlock(Block.Properties.ofFullCopy(Blocks.CAKE), MPDItems.PUMPKIN_HEAD_SLICE, ModItems.PUMPKIN_SLICE));
    public static final Supplier<Block> POTLUCK_SOUP_BLOCK = BLOCKS.register("potluck_soup_block",
            () -> new PotLuckSoupBlock(Block.Properties.ofFullCopy(Blocks.CAKE), MPDItems.FIRST_PLATE_OF_POTLUCK_SOUP, 1, MPDItems.PLATE_OF_POTLUCK_SOUP, 3, MPDItems.TAIL_IN_PLATE_OF_POTLUCK_SOUP,true));

}
