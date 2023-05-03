package net.icecubes.ultimategearport.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier URANIUM_INGOT = new ForgeTier(5, 2500, 15f,
            5.0f, 25, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.URANIUM_INGOT.get()));
}
