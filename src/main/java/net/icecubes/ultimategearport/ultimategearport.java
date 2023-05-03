package net.icecubes.ultimategearport;

import net.icecubes.ultimategearport.block.ModBlocks;
import net.icecubes.ultimategearport.effects.MobEffects;
import net.icecubes.ultimategearport.item.ModItems;
import net.icecubes.ultimategearport.util.ModItemProperties;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ultimategearport.MOD_ID)
public class ultimategearport {
    public static final String MOD_ID = "ultimategearport";

    public static final Logger LOGGER = LogManager.getLogger();

    public ultimategearport() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        MobEffects.register(eventBus);

        eventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.APPLE_LEAVES.get(), RenderType.cutout());

        ModItemProperties.addCustomItemProperties();
    }
}
