package com.euphony.aquatic_torches_renewed;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

public class AquaticTorchBlock extends TorchBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty FLOWING_WATER = IntegerProperty.create("water_level", 1, 8);


    public AquaticTorchBlock(SimpleParticleType particleType, Properties properties) {
        super(particleType, properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        FluidState fluidstate = placeContext.getLevel().getFluidState(placeContext.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER || fluidstate.getType() == Fluids.FLOWING_WATER;
        boolean is_flowing = fluidstate.getType() == Fluids.FLOWING_WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, flag).setValue(FLOWING_WATER, is_flowing ? fluidstate.getAmount() : 8);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(WATERLOGGED).add(FLOWING_WATER);
    }

    public FluidState getFluidState(BlockState blockState) {
        if (blockState.getValue(WATERLOGGED) && blockState.getValue(FLOWING_WATER) == 8) {
            return Fluids.WATER.getSource(false);
        } else if (blockState.getValue(WATERLOGGED) && blockState.getValue(FLOWING_WATER) != 8) {
            return Fluids.WATER.getFlowing(blockState.getValue(FLOWING_WATER), false);
        }
        return Fluids.EMPTY.defaultFluidState();
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource random) {
        double d0 = (double) blockPos.getX() + 0.5D;
        double d1 = (double) blockPos.getY() + 0.7D;
        double d2 = (double) blockPos.getZ() + 0.5D;
        level.addParticle(ParticleTypes.UNDERWATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        level.addParticle(ParticleTypes.GLOW_SQUID_INK, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}
