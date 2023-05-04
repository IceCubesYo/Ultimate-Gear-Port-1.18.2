package util;

import net.icecubes.ultimategearport.ultimategearport;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> URANIUM_ORE = forgetag("ores/uranium");
        public static final TagKey<Block> TITANIUM_ORE = forgetag("ores/titanium");
        public static final TagKey<Block> STORAGE_BLOCKS = forgetag("storage_blocks/uranium");
        public static final TagKey<Block> STORAGE_BLOCKS_TITANIUM = forgetag("storage_blocks/titanium");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ultimategearport.MOD_ID, name));
        }

        private static TagKey<Block> forgetag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        public static final TagKey<Item> INGOT_URANIUM = forgetag("ingots/uranium");
        public static final TagKey<item> NUGGET_URANIUM = forgetag("nuggets/uranium");

        public static final TagKey<Item> INGOT_TITANIUM = forgetag("ingots/titanium");
        public static final TagKey<item> NUGGET_TITANIUM = forgetag("nuggets/titanium");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ultimategearport.MOD_ID, name));
        }

        private static TagKey<Item> forgetag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
