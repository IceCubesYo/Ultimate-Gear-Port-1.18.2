package net.icecubes.ultimategearport.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import static net.minecraft.commands.arguments.blocks.BlockStateArgument.getBlock;

public class MinersDream extends Item {
    public MinersDream(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
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
            BlockPos startPos = pos.relative(face);
            Direction left = face.getClockWise();
            Direction right = face.getCounterClockWise();

            for (int x = -5; x <= 5; ++x) {
                for (int y = -1; y <= 5; ++y) {
                    for (int z = 0; z >= -50; --z) {
                        BlockPos newPos = startPos.relative(face, z).relative(left, x).relative(Direction.UP, y);
                        Block block = world.getBlockState(newPos).getBlock();
                        if (block != Blocks.BEDROCK && block != Blocks.BARRIER && block != Blocks.END_PORTAL && block != Blocks.END_PORTAL_FRAME && block
                                != Blocks.NETHER_PORTAL && block != Blocks.COMMAND_BLOCK && block != Blocks.CHAIN_COMMAND_BLOCK && block
                                != Blocks.REPEATING_COMMAND_BLOCK && block != Blocks.STRUCTURE_BLOCK && block != Blocks.JIGSAW && block
                                != Blocks.STRUCTURE_VOID && block != Blocks.MOVING_PISTON && block != Blocks.PISTON_HEAD && block
                                != Blocks.PISTON && block != Blocks.END_GATEWAY && block != Blocks.END_ROD && block != Blocks.END_STONE && block
                                != Blocks.END_STONE_BRICKS && block != Blocks.END_STONE_BRICK_SLAB && block != Blocks.END_STONE_BRICK_STAIRS && block
                                != Blocks.END_STONE_BRICK_WALL && block != Blocks.LAVA && !Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block).get()).is(Tags.Blocks.ORES)) {
                            world.destroyBlock(newPos, false);
                        }
                        else if (block == Blocks.LAVA) {
                            world.setBlock(newPos, Blocks.AIR.defaultBlockState(), 3);
                        }
                    }
                }
            }
        }

        return InteractionResult.SUCCESS;
    }
}