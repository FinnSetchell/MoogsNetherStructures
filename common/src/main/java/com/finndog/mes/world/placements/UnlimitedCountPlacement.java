package com.finndog.mes.world.placements;

import com.finndog.mes.modinit.MESPlacements;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.placement.RepeatingPlacement;

public class UnlimitedCountPlacement extends RepeatingPlacement {
    public static final MapCodec<UnlimitedCountPlacement> CODEC = IntProvider.NON_NEGATIVE_CODEC.fieldOf("count").xmap(UnlimitedCountPlacement::new, countPlacement -> countPlacement.count);
    private final IntProvider count;

    private UnlimitedCountPlacement(IntProvider intProvider) {
        this.count = intProvider;
    }

    public static UnlimitedCountPlacement of(IntProvider intProvider) {
        return new UnlimitedCountPlacement(intProvider);
    }

    public static UnlimitedCountPlacement of(int i) {
        return of(ConstantInt.of(i));
    }

    @Override
    protected int count(RandomSource random, BlockPos blockPos) {
        return this.count.sample(random);
    }

    @Override
    public PlacementModifierType<?> type() {
        return MESPlacements.UNLIMITED_COUNT.get();
    }
}
