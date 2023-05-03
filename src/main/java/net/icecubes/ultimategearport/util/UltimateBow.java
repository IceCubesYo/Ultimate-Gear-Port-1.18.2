package net.icecubes.ultimategearport.util;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class UltimateBow extends BowItem {

    public UltimateBow(Properties properties) {
        super(properties);

    }

    @SuppressWarnings("deprecation")
    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        releaseUsing(pStack, pLevel, pLivingEntity, 1000);
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }
}
