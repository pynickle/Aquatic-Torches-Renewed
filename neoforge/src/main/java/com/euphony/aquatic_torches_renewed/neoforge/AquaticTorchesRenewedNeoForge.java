package com.euphony.aquatic_torches_renewed.neoforge;

import com.euphony.aquatic_torches_renewed.AquaticTorchesRenewed;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(AquaticTorchesRenewed.MOD_ID)
@EventBusSubscriber(modid = AquaticTorchesRenewed.MOD_ID)
public final class AquaticTorchesRenewedNeoForge {
    public AquaticTorchesRenewedNeoForge(IEventBus bus) {
        AquaticTorchesRenewed.init();

        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
    }

    //MyItemsClass.MY_ITEM is a Supplier<? extends Item>, MyBlocksClass.MY_BLOCK is a Supplier<? extends Block>
    @SubscribeEvent // on the mod event bus
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        // Is this the tab we want to add to?
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.insertAfter(Items.REDSTONE_TORCH.getDefaultInstance(), ModItems.AQUATIC_TORCH_ITEM.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
