package net.noregen.bismuth.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.datafixer.fix.BlockEntityKeepPackedFix;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.noregen.bismuth.Bismuth;
import net.noregen.bismuth.item.ModItemGroup;

public class ModBlocks {

    public static final Block HORNBLENDE_BLOCK = registerBlock("hornblende_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.BISMUTH);
    public static final Block HORNBLENDE_ORE = registerBlock("hornblende_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.BISMUTH);
    public static final Block DEEPSLATE_HORNBLENDE_ORE = registerBlock("deepslate_hornblende_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.BISMUTH);
    public static final Block MORGANITE_BLOCK = registerBlock("morganite_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(4.0f).requiresTool()),ModItemGroup.BISMUTH);
    public static final Block MORGANITE_ORE = registerBlock("morganite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(2, 6)),ModItemGroup.BISMUTH);
    public static final Block DEEPSLATE_MORGANITE_ORE = registerBlock("deepslate_morganite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(2, 6)),ModItemGroup.BISMUTH);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Bismuth.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Bismuth.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        Bismuth.LOGGER.info("Registering Mod Blocks for " + Bismuth.MOD_ID);
    }
}
