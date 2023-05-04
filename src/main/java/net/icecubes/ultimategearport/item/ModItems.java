package net.icecubes.ultimategearport.item;


import net.icecubes.ultimategearport.item.custom.MinersDream;
import net.icecubes.ultimategearport.item.custom.ModArmorItem;
import net.icecubes.ultimategearport.item.custom.UltimatePickaxe;
import net.icecubes.ultimategearport.tabs.ModCreativeModeTab;
import net.icecubes.ultimategearport.ultimategearport;
import net.icecubes.ultimategearport.item.custom.UltimateBow;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ultimategearport.MOD_ID);

    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()));

    public static final RegistryObject<Item> URANIUM_NUGGET = ITEMS.register("uranium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()));

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()));

    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()));

    public static final RegistryObject<Item> ULTIMATE_SWORD = ITEMS.register("ultimate_sword",
            () -> new SwordItem(ModTiers.URANIUM_INGOT, 34, -2.6f,
                    new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()){
                @Override
                public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
                    super.onCraftedBy(stack, worldIn, playerIn);
                    stack.enchant(Enchantments.SHARPNESS, 5);
                    stack.enchant(Enchantments.SMITE, 5);
                    stack.enchant(Enchantments.BANE_OF_ARTHROPODS, 5);
                    stack.enchant(Enchantments.KNOCKBACK, 3);
                    stack.enchant(Enchantments.MOB_LOOTING, 3);
                    stack.enchant(Enchantments.UNBREAKING, 3);
                    stack.enchant(Enchantments.FIRE_ASPECT, 2);
                }
            });
    public static final RegistryObject<Item> ULTIMATE_PICKAXE = ITEMS.register("ultimate_pickaxe",
            () -> new UltimatePickaxe(ModTiers.URANIUM_INGOT, 32, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()){
                @Override
                public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
                    super.onCraftedBy(stack, worldIn, playerIn);
                    stack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
                    stack.enchant(Enchantments.BLOCK_FORTUNE, 5);
                }
            });
    public static final RegistryObject<Item> ULTIMATE_AXE = ITEMS.register("ultimate_axe",
            () -> new AxeItem(ModTiers.URANIUM_INGOT, 33, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()){
                @Override
                public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
                    super.onCraftedBy(stack, worldIn, playerIn);
                    stack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
                }
            });
    public static final RegistryObject<Item> ULTIMATE_SHOVEL = ITEMS.register("ultimate_shovel",
            () -> new ShovelItem(ModTiers.URANIUM_INGOT, 31, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()){
                @Override
                public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
                    super.onCraftedBy(stack, worldIn, playerIn);
                    stack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
                }
            });
    public static final RegistryObject<Item> ULTIMATE_HOE = ITEMS.register("ultimate_hoe",
            () -> new HoeItem(ModTiers.URANIUM_INGOT, -5, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()){
                @Override
                public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
                    super.onCraftedBy(stack, worldIn, playerIn);
                    stack.enchant(Enchantments.BLOCK_EFFICIENCY, 2);
                }
            });
    public static final RegistryObject<Item> ULTIMATE_BOW = ITEMS.register("ultimate_bow",
            () -> new UltimateBow(new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant().durability(1328)){
                @Override
                public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
                    super.onCraftedBy(stack, worldIn, playerIn);
                    stack.enchant(Enchantments.POWER_ARROWS, 5);
                    stack.enchant(Enchantments.FLAMING_ARROWS, 3);
                    stack.enchant(Enchantments.PUNCH_ARROWS, 2);
                    stack.enchant(Enchantments.INFINITY_ARROWS, 1);
                }
            });

    public static final RegistryObject<Item> ULTIMATE_HELMET = ITEMS.register("ultimate_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ULTIMATE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()) {
                @Override
                public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
                    super.onCraftedBy(stack, worldIn, playerIn);
                    stack.enchant(Enchantments.ALL_DAMAGE_PROTECTION, 5);
                    stack.enchant(Enchantments.FIRE_PROTECTION, 5);
                    stack.enchant(Enchantments.BLAST_PROTECTION, 5);
                    stack.enchant(Enchantments.PROJECTILE_PROTECTION, 5);
                    stack.enchant(Enchantments.RESPIRATION, 2);
                    stack.enchant(Enchantments.AQUA_AFFINITY, 3);
                }
            });
    public static final RegistryObject<Item> ULTIMATE_CHESTPLATE = ITEMS.register("ultimate_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ULTIMATE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()){
                @Override
                public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
                    super.onCraftedBy(stack, worldIn, playerIn);
                    stack.enchant(Enchantments.ALL_DAMAGE_PROTECTION, 5);
                    stack.enchant(Enchantments.FIRE_PROTECTION, 5);
                    stack.enchant(Enchantments.BLAST_PROTECTION, 5);
                    stack.enchant(Enchantments.PROJECTILE_PROTECTION, 5);
                }
            });
    public static final RegistryObject<Item> ULTIMATE_LEGGINGS = ITEMS.register("ultimate_leggings",
            () -> new ArmorItem(ModArmorMaterials.ULTIMATE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()){
                @Override
                public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
                    super.onCraftedBy(stack, worldIn, playerIn);
                    stack.enchant(Enchantments.ALL_DAMAGE_PROTECTION, 5);
                    stack.enchant(Enchantments.FIRE_PROTECTION, 5);
                    stack.enchant(Enchantments.BLAST_PROTECTION, 5);
                    stack.enchant(Enchantments.PROJECTILE_PROTECTION, 5);
                }
            });
    public static final RegistryObject<Item> ULTIMATE_BOOTS = ITEMS.register("ultimate_boots",
            () -> new ArmorItem(ModArmorMaterials.ULTIMATE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB).fireResistant()){
                @Override
                public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
                    super.onCraftedBy(stack, worldIn, playerIn);
                    stack.enchant(Enchantments.ALL_DAMAGE_PROTECTION, 5);
                    stack.enchant(Enchantments.FIRE_PROTECTION, 5);
                    stack.enchant(Enchantments.BLAST_PROTECTION, 5);
                    stack.enchant(Enchantments.PROJECTILE_PROTECTION, 5);
                    stack.enchant(Enchantments.FALL_PROTECTION, 3);
                }
            });

    public static final RegistryObject<Item> MINERS_DREAM = ITEMS.register("miners_dream",
            () -> new MinersDream(new Item.Properties().tab(ModCreativeModeTab.ultimategear_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}