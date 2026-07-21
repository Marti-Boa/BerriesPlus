package net.that1slime.berriesplus.worldgen;

import net.minecraft.world.level.biome.Biomes;
import net.that1slime.berriesplus.BerriesPlus;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_BLUE_BERRY_BUSH =
            registerKey("add_blue_berry_bush");

    public static final ResourceKey<BiomeModifier> ADD_YELLOW_BERRY_BUSH =
            registerKey("add_yellow_berry_bush");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_BLUE_BERRY_BUSH,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(
                                biomes.getOrThrow(Biomes.FOREST),
                                biomes.getOrThrow(Biomes.PLAINS)
                        ),
                        HolderSet.direct(
                                placedFeatures.getOrThrow(ModPlacedFeatures.BLUE_BERRY_BUSH_PLACED_KEY)
                        ),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                ));

        context.register(ADD_YELLOW_BERRY_BUSH,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(
                                biomes.getOrThrow(Biomes.FOREST),
                                biomes.getOrThrow(Biomes.PLAINS)
                        ),
                        HolderSet.direct(
                                placedFeatures.getOrThrow(ModPlacedFeatures.YELLOW_BERRY_BUSH_PLACED_KEY)
                        ),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(
                NeoForgeRegistries.Keys.BIOME_MODIFIERS,
                ResourceLocation.fromNamespaceAndPath(BerriesPlus.MOD_ID, name)
        );
    }
}