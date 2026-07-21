package net.that1slime.berriesplus.worldgen;

import net.that1slime.berriesplus.BerriesPlus;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> BLUE_BERRY_BUSH_PLACED_KEY =
            registerKey("blue_berry_bush_placed");

    public static final ResourceKey<PlacedFeature> YELLOW_BERRY_BUSH_PLACED_KEY =
            registerKey("yellow_berry_bush_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(
                context,
                BLUE_BERRY_BUSH_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUE_BERRY_BUSH_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        register(
                context,
                YELLOW_BERRY_BUSH_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.YELLOW_BERRY_BUSH_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(512),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(
                Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(BerriesPlus.MOD_ID, name)
        );
    }

    private static void register(
            BootstrapContext<PlacedFeature> context,
            ResourceKey<PlacedFeature> key,
            Holder<ConfiguredFeature<?, ?>> configuration,
            List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}