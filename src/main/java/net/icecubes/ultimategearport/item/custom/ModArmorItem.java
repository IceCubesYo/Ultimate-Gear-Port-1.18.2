package net.icecubes.ultimategearport.item.custom;

import java.util.Map;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;

import net.icecubes.ultimategearport.effects.MobEffects;
import net.icecubes.ultimategearport.item.ModArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, Supplier<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, Supplier<MobEffectInstance>>()
                    .put(ModArmorMaterials.ULTIMATE,
                            () -> new MobEffectInstance(MobEffects.FEED.get(), 100, 1, false, false, false))
                    .build();

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (ArmorMaterial armorMaterial : MATERIAL_TO_EFFECT_MAP.keySet()) {
            if (hasCorrectArmorOn(armorMaterial, player)) {
                addStatusEffectForMaterial(player, armorMaterial, MATERIAL_TO_EFFECT_MAP.get(armorMaterial));
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial armorMaterial,
                                            Supplier<MobEffectInstance> statusEffectSupplier) {
        boolean hasPlayerEffect = player.hasEffect(statusEffectSupplier.get().getEffect());

        if (hasCorrectArmorOn(armorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(statusEffectSupplier.get());
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
