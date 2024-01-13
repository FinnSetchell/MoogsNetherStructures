package com.finndog.mns.modinit;

import com.finndog.mns.MNSCommon;
import com.finndog.mns.modinit.registry.RegistryEntry;
import com.finndog.mns.modinit.registry.ResourcefulRegistries;
import com.finndog.mns.modinit.registry.ResourcefulRegistry;
import com.finndog.mns.world.placements.MinusEightPlacement;
import com.finndog.mns.world.placements.SnapToLowerNonAirPlacement;
import com.finndog.mns.world.placements.UnlimitedCountPlacement;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public final class MNSPlacements {
	public static final ResourcefulRegistry<PlacementModifierType<?>> PLACEMENT_MODIFIER = ResourcefulRegistries.create(Registry.PLACEMENT_MODIFIERS, MNSCommon.MODID);

	public static final RegistryEntry<PlacementModifierType<MinusEightPlacement>> MINUS_EIGHT_PLACEMENT = PLACEMENT_MODIFIER.register("minus_eight_placement", () -> () -> MinusEightPlacement.CODEC);
	public static final RegistryEntry<PlacementModifierType<UnlimitedCountPlacement>> UNLIMITED_COUNT = PLACEMENT_MODIFIER.register("unlimited_count", () -> () -> UnlimitedCountPlacement.CODEC);
	public static final RegistryEntry<PlacementModifierType<SnapToLowerNonAirPlacement>> SNAP_TO_LOWER_NON_AIR_PLACEMENT = PLACEMENT_MODIFIER.register("snap_to_lower_non_air_placement", () -> () -> SnapToLowerNonAirPlacement.CODEC);
}
