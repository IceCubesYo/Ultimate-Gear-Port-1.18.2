package net.icecubes.ultimategearport.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UltimatePickaxe extends PickaxeItem {

    private boolean smeltingEnabled = false;

    public UltimatePickaxe(Tier pTier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(pTier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!state.isAir()) {
            Block block = state.getBlock();
            int exp = block.getExpDrop(state, level, pos, 0, 0);
            level.removeBlock(pos, false);
            if (block instanceof OreBlock && smeltingEnabled) {
                List<ItemStack> drops = Block.getDrops(state, (ServerLevel) level, pos, null, entityLiving, stack);
                if (!drops.isEmpty()) {
                    ItemStack smeltedStack = smelt(drops.get(0), (ServerPlayer) entityLiving);
                    if (!level.isClientSide) {
                        level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), smeltedStack));
                        ((ServerPlayer) entityLiving).giveExperiencePoints(exp);
                        level.gameEvent(entityLiving, GameEvent.BLOCK_DESTROY, pos);
                        state.spawnAfterBreak((ServerLevel) level, pos, ItemStack.EMPTY);
                    }
                    return true;
                }
            }
            List<ItemStack> drops = Block.getDrops(state, (ServerLevel) level, pos, null, entityLiving, stack);
            if (!drops.isEmpty()) {
                ItemStack dropStack = drops.get(0);
                if (!level.isClientSide) {
                    level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), dropStack));
                    ((ServerPlayer) entityLiving).giveExperiencePoints(exp);
                    level.gameEvent(entityLiving, GameEvent.BLOCK_DESTROY, pos);
                    state.spawnAfterBreak((ServerLevel) level, pos, ItemStack.EMPTY);
                }
                return true;
            }
        }
        return false;
    }

    private ItemStack smelt(ItemStack stack, ServerPlayer player) {
        RecipeManager recipeManager = Objects.requireNonNull(player.getServer()).getRecipeManager();
        Inventory inventory = new Inventory(player);
        inventory.setItem(0, stack);
        Optional<SmeltingRecipe> recipe = recipeManager.getRecipeFor(RecipeType.SMELTING, inventory, player.level);
        if (recipe.isPresent()) {
            ItemStack smeltedStack = recipe.get().getResultItem().copy();
            smeltedStack.setCount(stack.getCount());
            return smeltedStack;
        }
        return stack;
    }

    private static final long COOLDOWN_TIME_MS = 500;

    private long lastInteractionTime = 0;
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        long currentTime = System.currentTimeMillis();
        if (player.isCrouching() && currentTime - lastInteractionTime >= COOLDOWN_TIME_MS) {
            smeltingEnabled = !smeltingEnabled;
            Component message = Component.nullToEmpty(smeltingEnabled ? "§a§lSmelting ENABLED" : "§c§lSmelting DISABLED");
            player.displayClientMessage(message, true);
            lastInteractionTime = currentTime;
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }
        return super.use(level, player, hand);
    }


}