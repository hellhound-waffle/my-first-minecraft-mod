package waffle.myfirstmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import waffle.myfirstmod.item.ModItems;

public class MyFirstMod implements ModInitializer {
	public static final String MOD_ID = "my-first-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Let's add some waffles!!!");
		ModItems.registerModItems();
	}
}