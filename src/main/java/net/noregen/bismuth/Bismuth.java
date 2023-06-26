package net.noregen.bismuth;

import net.fabricmc.api.ModInitializer;
import net.noregen.bismuth.item.ModItemGroup;
import net.noregen.bismuth.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bismuth implements ModInitializer {
	public static final String MOD_ID = "bismuth";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();

	}
}
