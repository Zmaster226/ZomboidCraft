package com.example.zomboidcraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ZomboidCraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEvents {
    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiOverlayEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;
        CompoundTag tag = player.getPersistentData();
        GuiGraphics graphics = event.getGuiGraphics();
        int y = 10;
        if (tag.getBoolean(ModEvents.INFECTED_TAG)) {
            graphics.drawString(mc.font, "Infected", 10, y, 0xFFFF0000);
            y += 10;
        }
        if (tag.getBoolean(ModEvents.BLEEDING_TAG)) {
            graphics.drawString(mc.font, "Bleeding", 10, y, 0xFFFF0000);
        }
    }
}
