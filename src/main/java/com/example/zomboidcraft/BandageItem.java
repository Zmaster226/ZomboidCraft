package com.example.zomboidcraft;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;

public class BandageItem extends Item {
    private final boolean curesInfection;

    public BandageItem(Properties properties, boolean curesInfection) {
        super(properties);
        this.curesInfection = curesInfection;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 40; // 2 seconds
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player player) {
            CompoundTag tag = player.getPersistentData();
            tag.putBoolean(ModEvents.BLEEDING_TAG, false);
            if (curesInfection) {
                tag.putBoolean(ModEvents.INFECTED_TAG, false);
                tag.putInt(ModEvents.INFECTION_TIME_TAG, 0);
            }
            if (!player.isCreative()) {
                stack.shrink(1);
            }
        }
        return stack;
    }
}
