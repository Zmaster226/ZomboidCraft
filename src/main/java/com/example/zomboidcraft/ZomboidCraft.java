package com.example.zomboidcraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.ModLoadingContext;

@Mod(ZomboidCraft.MODID)
public class ZomboidCraft {
    public static final String MODID = "zomboidcraft";

    public ZomboidCraft() {
        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, ModConfig.SPEC);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        com.example.zomboidcraft.entity.ModEntities.ENTITIES.register(bus);
        bus.addListener(this::clientSetup);
        bus.register(new ModEvents());
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        // Client-only setup
    }
}
