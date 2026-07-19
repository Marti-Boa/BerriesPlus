package net.that1slime.berriesplus.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.that1slime.berriesplus.BerriesPlus;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BerriesPlus.MOD_ID);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
