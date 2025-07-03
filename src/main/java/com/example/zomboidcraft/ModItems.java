package com.example.zomboidcraft;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ZomboidCraft.MODID);

    public static final RegistryObject<Item> MEDICAL_BANDAGE = ITEMS.register("medical_bandage",
            () -> new BandageItem(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BANDAGE = ITEMS.register("bandage",
            () -> new BandageItem(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> HERBAL_BANDAGE = ITEMS.register("herbal_bandage",
            () -> new BandageItem(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_MISC)));
}
