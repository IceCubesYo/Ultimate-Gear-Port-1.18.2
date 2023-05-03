package net.icecubes.ultimategearport.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class FeedEffect extends MobEffect {
    public FeedEffect(MobEffectCategory category) {
        super(category, 0);
    }

    private final int EAT_INTERVAL = 10;

    private int eatTimer = EAT_INTERVAL;

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level.isClientSide()) {
            eatTimer--;
            if (eatTimer <= 0) {
                ((Player)pLivingEntity).getFoodData().eat(1, 1.0F);
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

}