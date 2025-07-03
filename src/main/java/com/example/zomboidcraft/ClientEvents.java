package com.example.zomboidcraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ZomboidCraft.MODID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiOverlayEvent.Post event) {
        if (!Minecraft.getInstance().player.getTags().contains(ModEvents.BLEEDING_TAG)) return;

        PoseStack poseStack = event.getPoseStack();
        int width = Minecraft.getInstance().getWindow().getGuiScaledWidth();
        int height = Minecraft.getInstance().getWindow().getGuiScaledHeight();

        Minecraft.getInstance().font.draw(poseStack, "BLEEDING", width / 2f - 20, height / 2f - 60, 0xFF5555);
    }
}
