package net.noregen.bismuth.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.noregen.bismuth.Bismuth;

public class ModItemGroup {
    public static ItemGroup BISMUTH;

    public static void registerItemGroups(){
        BISMUTH = FabricItemGroup.builder(new Identifier(Bismuth.MOD_ID, "bismuth"))
                .displayName(Text.literal("Bismuth"))
                .icon(() -> new ItemStack(ModItems.MORGANITE)).build();
    }

}
