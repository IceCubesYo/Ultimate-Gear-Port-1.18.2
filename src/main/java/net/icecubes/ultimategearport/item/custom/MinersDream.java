package net.icecubes.ultimategearport.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class MinersDream extends Item {
    public MinersDream(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player == null) {
            return InteractionResult.PASS;
        }

        ItemStack stack = context.getItemInHand();
        BlockPos pos = context.getClickedPos();
        Direction face = context.getClickedFace();
        Level world = context.getLevel();

        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
        }

        if (!world.isClientSide()) {
            for (int x = -5; x <= 5; ++x) {
                for (int y = 0; y <= 5; ++y) {
                    for (int z = 0; z <= 50; ++z) {
                        BlockPos newPos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                        if (face == Direction.NORTH) {
                            newPos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() - z);
                        } else if (face == Direction.EAST) {
                            newPos = new BlockPos(pos.getX() + z, pos.getY() + y, pos.getZ() + x);
                        } else if (face == Direction.WEST) {
                            newPos = new BlockPos(pos.getX() - z, pos.getY() + y, pos.getZ() + x);
                        } else if (face == Direction.UP) {
                            newPos = new BlockPos(pos.getX() + x, pos.getY() + z, pos.getZ() + y);
                        } else if (face == Direction.DOWN) {
                            newPos = new BlockPos(pos.getX() + x, pos.getY() - z, pos.getZ() + y);
                        }

                        Block block = world.getBlockState(newPos).getBlock();
                        if ((world.isEmptyBlock(newPos.above()) || block == Blocks.WATER || block == Blocks.LAVA) && block != Blocks.BEDROCK && block != Blocks.BARRIER && block != Blocks.END_PORTAL && block != Blocks.END_PORTAL_FRAME && block != Blocks.NETHER_PORTAL && block != Blocks.COMMAND_BLOCK && block != Blocks.CHAIN_COMMAND_BLOCK && block != Blocks.REPEATING_COMMAND_BLOCK && block != Blocks.STRUCTURE_BLOCK && block != Blocks.JIGSAW && block != Blocks.STRUCTURE_VOID && block != Blocks.MOVING_PISTON && block != Blocks.PISTON_HEAD && block != Blocks.PISTON && block != Blocks.END_GATEWAY && block != Blocks.END_ROD && block != Blocks.END_STONE && block != Blocks.END_STONE_BRICKS && block != Blocks.END_STONE_BRICK_SLAB && block != Blocks.END_STONE_BRICK_STAIRS && block != Blocks.END_STONE_BRICK_WALL) {
                            world.setBlockAndUpdate(newPos, Blocks.AIR.defaultBlockState());
                        }
                    }
                }
            }
        }

        return InteractionResult.SUCCESS;
    }
}