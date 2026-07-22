package net.that1slime.berriesplus.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.that1slime.berriesplus.BerriesPlus;
import net.that1slime.berriesplus.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BerriesPlus.MOD_ID);

public static final DeferredItem<Item> BLUE_BERRIES = ITEMS.register("blue_berries",
        () -> new ItemNameBlockItem(ModBlocks.BLUE_BERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.BLUE_BERRY)));

public static final DeferredItem<Item> YELLOW_BERRIES = ITEMS.register("yellow_berries",
        () -> new ItemNameBlockItem(ModBlocks.YELLOW_BERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.YELLOW_BERRY)));

    public static final DeferredItem<Item> YELLOW_BERRY_PIE = ITEMS.register("yellow_berry_pie",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.YELLOW_BERRY_PIE)));

    public static final DeferredItem<Item> BLUE_BERRY_PIE = ITEMS.register("blue_berry_pie",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.BLUE_BERRY_PIE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
