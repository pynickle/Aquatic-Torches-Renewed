package com.euphony.aquatic_torches_renewed.neoforge;

import com.euphony.aquatic_torches_renewed.AquaticTorchBlock;
import com.euphony.aquatic_torches_renewed.AquaticTorchesRenewed;
import com.euphony.aquatic_torches_renewed.AquaticWallTorchBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AquaticTorchesRenewed.MOD_ID);

    public static final DeferredBlock<AquaticTorchBlock> AQUATIC_TORCH = BLOCKS.registerBlock("aquatic_torch", (properties) -> new AquaticTorchBlock(ParticleTypes.FLAME, properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).lightLevel(state -> 15));
    public static final DeferredBlock<AquaticWallTorchBlock> AQUATIC_WALL_TORCH = BLOCKS.registerBlock("aquatic_wall_torch", (properties) -> new AquaticWallTorchBlock(ParticleTypes.FLAME, properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).lightLevel(state -> 15).overrideLootTable(AQUATIC_TORCH.get().getLootTable()));
}
