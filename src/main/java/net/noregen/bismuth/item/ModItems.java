package net.noregen.bismuth.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.noregen.bismuth.Bismuth;

public class ModItems {

    public static final Item RAW_MORGANITE = registerItem("raw_morganite",
            new Item(new FabricItemSettings()));
    public static final Item MORGANITE = registerItem("morganite",
            new Item(new FabricItemSettings()));
    public static final Item HORNBLENDE = registerItem("hornblende",
            new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Bismuth.MOD_ID, name), item);
    }

    private static void addItemsToItemGroup(){
        addToItemGroup(ModItemGroup.BISMUTH, MORGANITE);
        addToItemGroup(ModItemGroup.BISMUTH, RAW_MORGANITE);
        addToItemGroup(ModItemGroup.BISMUTH, HORNBLENDE);
    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems(){
        Bismuth.LOGGER.debug("Registering Mod Items for " + Bismuth.MOD_ID);

        addItemsToItemGroup();
    }
}
