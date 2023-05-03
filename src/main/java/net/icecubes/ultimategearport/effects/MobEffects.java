package net.icecubes.ultimategearport.effects;

import net.icecubes.ultimategearport.ultimategearport;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MobEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ultimategearport.MOD_ID);

    public static final RegistryObject<MobEffect> FEED = MOB_EFFECTS.register("feed",
            () -> new FeedEffect(MobEffectCategory.BENEFICIAL));

    public static void register(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }

}
