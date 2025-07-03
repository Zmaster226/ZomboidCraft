package com.example.zomboidcraft.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ZombieCloneEntity extends Zombie {
    public ZombieCloneEntity(EntityType<? extends Zombie> type, Level level) {
        super(type, level);
    }

    public static ZombieCloneEntity create(Level level, Player player) {
        ZombieCloneEntity clone = new ZombieCloneEntity(ModEntities.ZOMBIE_CLONE.get(), level);
        clone.moveTo(player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
        clone.setCustomName(player.getName());
        clone.setCustomNameVisible(true);
        clone.setPersistenceRequired();
        return clone;
    }
}
