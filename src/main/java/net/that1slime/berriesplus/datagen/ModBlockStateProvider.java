package net.that1slime.berriesplus.datagen;

import net.that1slime.berriesplus.BerriesPlus;
import net.that1slime.berriesplus.block.ModBlocks;
import net.that1slime.berriesplus.block.custom.BlueBerryBushBlock;
import net.that1slime.berriesplus.block.custom.YellowBerryBushBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BerriesPlus.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeBush(
                (SweetBerryBushBlock) ModBlocks.BLUE_BERRY_BUSH.get(),
                "blue_berry_bush_stage",
                "blue_berry_bush_stage"
        );

        makeBush(
                (SweetBerryBushBlock) ModBlocks.YELLOW_BERRY_BUSH.get(),
                "yellow_berry_bush_stage",
                "yellow_berry_bush_stage"
        );
    }

    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, SweetBerryBushBlock block, String modelName, String textureName) {
        int age = state.getValue(SweetBerryBushBlock.AGE);

        return new ConfiguredModel[]{
                new ConfiguredModel(
                        models().cross(
                                modelName + age,
                                ResourceLocation.fromNamespaceAndPath(
                                        BerriesPlus.MOD_ID,
                                        "block/" + textureName + age
                                )
                        ).renderType("cutout")
                )
        };
    }
}