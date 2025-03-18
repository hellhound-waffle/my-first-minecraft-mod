package waffle.myfirstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import waffle.myfirstmod.MyFirstMod;

public class ModItems {

    public static final FoodComponent FOOD_COMPONENT = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 90 * 20, 1), 1.0f)
            .alwaysEdible()
            .saturationModifier(12.8f)
            .nutrition(7)
            .build();

    private static Item.Settings settings = new Item.Settings().food(FOOD_COMPONENT);
    private static final Item WAFFLE = registerItem("waffle", new Item(settings));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MyFirstMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MyFirstMod.LOGGER.info("Registering mod items for " + MyFirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(WAFFLE);
        });

        FuelRegistry.INSTANCE.add(WAFFLE, 6*20);

    }
}
