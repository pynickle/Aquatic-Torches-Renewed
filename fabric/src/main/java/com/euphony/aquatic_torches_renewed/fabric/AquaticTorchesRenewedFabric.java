package com.euphony.aquatic_torches_renewed.fabric;

import com.euphony.aquatic_torches_renewed.AquaticTorchesRenewed;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public final class AquaticTorchesRenewedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AquaticTorchesRenewed.init();

        ModBlocks.initialize();
        ModItems.initialize();

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register((itemGroup) -> itemGroup.insertAfter(Items.REDSTONE_TORCH, ModItems.AQUATIC_TORCH));
    }
}
