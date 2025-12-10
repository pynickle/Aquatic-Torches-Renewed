package com.euphony.aquatic_torches_renewed.fabric;

import com.euphony.aquatic_torches_renewed.AquaticTorchesRenewed;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;

import java.util.function.Function;

import static com.euphony.aquatic_torches_renewed.fabric.ModBlocks.AQUATIC_WALL_TORCH;

public class ModItems {
    public static final Item AQUATIC_TORCH = register("aquatic_torch", (properties) -> new StandingAndWallBlockItem(ModBlocks.AQUATIC_TORCH, AQUATIC_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());

    public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(AquaticTorchesRenewed.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
    }
}
