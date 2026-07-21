package net.that1slime.berriesplus.damage;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.that1slime.berriesplus.BerriesPlus;

public class ModDamageTypes {

    public static final ResourceKey<DamageType> YELLOW_BERRY_BUSH =
            ResourceKey.create(
                    Registries.DAMAGE_TYPE,
                    ResourceLocation.fromNamespaceAndPath(
                            BerriesPlus.MOD_ID,
                            "yellow_berry_bush"
                    )
            );
}