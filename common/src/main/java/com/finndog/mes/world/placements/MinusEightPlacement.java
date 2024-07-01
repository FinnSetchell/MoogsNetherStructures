package com.finndog.mes.world.placements;

import com.finndog.mes.modinit.MESPlacements;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.stream.Stream;

public class MinusEightPlacement extends PlacementModifier {
	private static final MinusEightPlacement INSTANCE = new MinusEightPlacement();
	public static final MapCodec<MinusEightPlacement> CODEC = MapCodec.unit(() -> INSTANCE);

	public static MinusEightPlacement subtractedEight() {
		return INSTANCE;
	}

	@Override
	public Stream<BlockPos> getPositions(PlacementContext placementContext, RandomSource random, BlockPos blockPos) {
		return Stream.of(new BlockPos(blockPos.getX() - 8, blockPos.getY(), blockPos.getZ() - 8));
	}

	@Override
	public PlacementModifierType<?> type() {
		return MESPlacements.MINUS_EIGHT_PLACEMENT.get();
	}
}
