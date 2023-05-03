package net.icecubes.ultimategearport.world.features;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> URANIUM_ORE_PLACED = PlacementUtils.register("uranium_ore_placed",
            ModConfiguredFeatures.URANIUM_ORE, ModOrePlacemeant.commonOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> TITANIUM_ORE_PLACED = PlacementUtils.register("titanium_ore_placed",
            ModConfiguredFeatures.TITANIUM_ORE, ModOrePlacemeant.commonOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> DUPLICATOR_TREE_PLACED = PlacementUtils.register("duplicator_tree_placed",
            ModConfiguredFeatures.DUPLICATOR_TREE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2)));
}
