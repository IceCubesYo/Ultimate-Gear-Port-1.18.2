package net.icecubes.ultimategearport.tabs;

import net.icecubes.ultimategearport.item.ModItems;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModCreativeModeTab {

    public static CreativeModeTab ultimategear_TAB = new CreativeModeTab("ultimategearport") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.URANIUM_INGOT.get());
        }
    };
}
