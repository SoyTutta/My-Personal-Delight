package com.soytutta.mypersonaldelight.core.data;

import com.soytutta.mypersonaldelight.common.block.SnowGolemFeastBlock;
import com.soytutta.mypersonaldelight.common.registry.MPDBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.block.*;

public class MPDBlockStates extends BlockStateProvider {

    public MPDBlockStates(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, "mypersonaldelight", existingFileHelper);
    }

    private String blockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return ResourceLocation.fromNamespaceAndPath("mypersonaldelight", "block/" + path);
    }

    protected void registerStatesAndModels() {

    }

    public void feastBlock(FeastBlock block) {
        this.getVariantBuilder(block).forAllStates((state) -> {
            IntegerProperty servingsProperty = block.getServingsProperty();
            int servings = state.getValue(servingsProperty);
            String suffix = "_stage" + (block.getMaxServings() - servings);
            if (servings == 0) {
                suffix = block.hasLeftovers ? "_leftover" : "_stage" + (servingsProperty.getPossibleValues().toArray().length - 2);
            }

            ConfiguredModel.Builder var10000 = ConfiguredModel.builder();
            String var10002 = this.blockName(block);
            return var10000.modelFile(this.existingModel(var10002 + suffix)).rotationY(((int)(state.getValue(FeastBlock.FACING)).toYRot() + 180) % 360).build();
        });
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(this.resourceBlock(path), this.models().existingFileHelper);
    }

    public void crateBlock(Block block, String cropName) {
        this.simpleBlock(block, this.models().cubeBottomTop(this.blockName(block), this.resourceBlock(cropName + "_crate_side"), this.resourceBlock(cropName + "_crate_bottom"), this.resourceBlock(cropName + "_crate_top")));
    }

    public ConfiguredModel[] cubeRandomRotation(Block block, String suffix) {
        String var10000 = this.blockName(block);
        String formattedName = var10000 + (suffix.isEmpty() ? "" : "_" + suffix);
        return ConfiguredModel.allYRotations(this.models().cubeAll(formattedName, this.resourceBlock(formattedName)), 0, false);
    }

    public void stageBlock(Block block, IntegerProperty ageProperty, Property<?>... ignored) {
        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            int ageSuffix = state.getValue(ageProperty);
            String blockName = this.blockName(block);
            String stageName = blockName + "_stage" + ageSuffix;
            return ConfiguredModel.builder().modelFile((this.models().cross(stageName, this.resourceBlock(stageName))).renderType("cutout")).build();
        }, ignored);
    }

    public void cabinetBlock(Block block, String woodType) {
        this.horizontalBlock(block, (state) -> {
            String suffix = state.getValue(CabinetBlock.OPEN) ? "_open" : "";
            return this.models().orientable(this.blockName(block) + suffix, this.resourceBlock(woodType + "_cabinet_side"), this.resourceBlock(woodType + "_cabinet_front" + suffix), this.resourceBlock(woodType + "_cabinet_top"));
        });
    }
}
