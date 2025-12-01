package com.euphony.aquatic_torches_renewed.neoforge;

import com.euphony.aquatic_torches_renewed.AquaticTorchesRenewed;
import net.minecraft.core.Direction;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AquaticTorchesRenewed.MOD_ID);

    public static final DeferredItem<StandingAndWallBlockItem> AQUATIC_TORCH_ITEM = ITEMS.registerItem("aquatic_torch",
            (properties) -> new StandingAndWallBlockItem(ModBlocks.AQUATIC_TORCH.get(), ModBlocks.AQUATIC_WALL_TORCH.get(), Direction.DOWN, properties));
}
