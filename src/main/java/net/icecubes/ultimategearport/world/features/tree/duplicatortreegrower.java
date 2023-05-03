package net.icecubes.ultimategearport.world.features.tree;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import net.icecubes.ultimategearport.world.features.ModConfiguredFeatures;

import java.util.Random;

public class duplicatortreegrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204307_, boolean p_204308_) {
        return ModConfiguredFeatures.DUPLICATOR_TREE;
    }
}
