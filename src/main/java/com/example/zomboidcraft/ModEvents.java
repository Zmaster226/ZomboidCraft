package com.example.zomboidcraft;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ZomboidCraft.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    public static final String INFECTED_TAG = "zomboidcraft_infected";
    public static final String INFECTION_TIME_TAG = "zomboidcraft_infection_time";
    public static final String BLEEDING_TAG = "zomboidcraft_bleeding";

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (event.getSource().getEntity() != null && event.getSource().getEntity().getType() == EntityType.ZOMBIE) {
                if (player.level().random.nextFloat() < ModConfig.infectionChance.get()) {
                    CompoundTag tag = player.getPersistentData();
                    if (!tag.getBoolean(INFECTED_TAG)) {
                        tag.putBoolean(INFECTED_TAG, true);
                        tag.putInt(INFECTION_TIME_TAG, 0);
                    }
                }
            }
            if (player.level().random.nextFloat() < ModConfig.bleedChance.get()) {
                CompoundTag tag = player.getPersistentData();
                tag.putBoolean(BLEEDING_TAG, true);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            CompoundTag tag = player.getPersistentData();
            if (tag.getBoolean(INFECTED_TAG)) {
                int time = tag.getInt(INFECTION_TIME_TAG) + 1;
                tag.putInt(INFECTION_TIME_TAG, time);
                if (time >= ModConfig.infectionKillTime.get()) {
                    player.hurt(player.damageSources().generic(), Float.MAX_VALUE);
                }
            }
            if (tag.getBoolean(BLEEDING_TAG)) {
                if (player.tickCount % 40 == 0) {
                    player.hurt(player.damageSources().generic(), 1.0F);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            Level level = player.level();
            if (level instanceof ServerLevel serverLevel) {
                com.example.zomboidcraft.entity.ZombieCloneEntity clone =
                        com.example.zomboidcraft.entity.ZombieCloneEntity.create(serverLevel, player);
                serverLevel.addFreshEntity(clone);
            }
        }
    }
}
