package com.example.zomboidcraft.entity;

import com.example.zomboidcraft.ZomboidCraft;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ZomboidCraft.MODID);

    public static final RegistryObject<EntityType<ZombieCloneEntity>> ZOMBIE_CLONE =
            ENTITIES.register("zombie_clone",
                    () -> EntityType.Builder.of(ZombieCloneEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .build("zombie_clone"));
}
