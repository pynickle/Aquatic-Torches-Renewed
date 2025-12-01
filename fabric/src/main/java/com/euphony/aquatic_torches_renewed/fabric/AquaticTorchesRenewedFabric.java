package com.euphony.aquatic_torches_renewed.fabric;

import com.euphony.aquatic_torches_renewed.AquaticTorchesRenewed;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public final class AquaticTorchesRenewedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AquaticTorchesRenewed.init();

        ModBlocks.initialize();
        ModItems.initialize();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register((itemGroup) -> itemGroup.addAfter(Items.REDSTONE_TORCH, ModItems.AQUATIC_TORCH));
    }
}
