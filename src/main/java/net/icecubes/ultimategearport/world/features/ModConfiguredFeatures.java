package net.icecubes.ultimategearport.world.features;

import net.icecubes.ultimategearport.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_URANIUM_ORE = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.URANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_URANIUM_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> URANIUM_ORE = FeatureUtils.register("uranium_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_URANIUM_ORE, 9));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_TITANIUM_ORE = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TITANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TITANIUM_ORE = FeatureUtils.register("titanium_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_TITANIUM_ORE, 9));

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DUPLICATOR_TREE =
            FeatureUtils.register("duplicator_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.DUPLICATORTREE_LOG.get()),
                    new StraightTrunkPlacer(3, 2, 0),
                    BlockStateProvider.simple(ModBlocks.APPLE_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), 1),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> DUPLICATOR_TREE_CHECKED = PlacementUtils.register("duplicator_tree_checked", DUPLICATOR_TREE,
            PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> DUPLICATOR_TREE_SPAWN =
            FeatureUtils.register("duplicator_tree_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(DUPLICATOR_TREE_CHECKED,
                            0.5F)), DUPLICATOR_TREE_CHECKED));


}
