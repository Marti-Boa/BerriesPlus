package net.that1slime.berriesplus.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties BLUE_BERRY = new FoodProperties.Builder().nutrition(4).saturationModifier(0.20f).fast().build();

    public static final FoodProperties YELLOW_BERRY = new FoodProperties.Builder().nutrition(6).saturationModifier(0.7f).fast().build();
}