package com.finndog.mes.modinit;

import com.finndog.mes.MESCommon;
import com.finndog.mes.modinit.registry.RegistryEntry;
import com.finndog.mes.modinit.registry.ResourcefulRegistries;
import com.finndog.mes.modinit.registry.ResourcefulRegistry;
import com.finndog.mes.world.placements.MinusEightPlacement;
import com.finndog.mes.world.placements.SnapToLowerNonAirPlacement;
import com.finndog.mes.world.placements.UnlimitedCountPlacement;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public final class MESPlacements {
	public static final ResourcefulRegistry<PlacementModifierType<?>> PLACEMENT_MODIFIER = ResourcefulRegistries.create(Registry.PLACEMENT_MODIFIERS, MESCommon.MODID);

	public static final RegistryEntry<PlacementModifierType<MinusEightPlacement>> MINUS_EIGHT_PLACEMENT = PLACEMENT_MODIFIER.register("minus_eight_placement", () -> () -> MinusEightPlacement.CODEC);
	public static final RegistryEntry<PlacementModifierType<UnlimitedCountPlacement>> UNLIMITED_COUNT = PLACEMENT_MODIFIER.register("unlimited_count", () -> () -> UnlimitedCountPlacement.CODEC);
	public static final RegistryEntry<PlacementModifierType<SnapToLowerNonAirPlacement>> SNAP_TO_LOWER_NON_AIR_PLACEMENT = PLACEMENT_MODIFIER.register("snap_to_lower_non_air_placement", () -> () -> SnapToLowerNonAirPlacement.CODEC);
}
