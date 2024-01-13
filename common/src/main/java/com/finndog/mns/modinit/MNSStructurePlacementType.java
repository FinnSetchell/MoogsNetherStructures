package com.finndog.mns.modinit;

import com.finndog.mns.MNSCommon;
import com.finndog.mns.modinit.registry.RegistryEntry;
import com.finndog.mns.modinit.registry.ResourcefulRegistries;
import com.finndog.mns.modinit.registry.ResourcefulRegistry;
import com.finndog.mns.world.structures.placements.AdvancedRandomSpread;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;


public final class MNSStructurePlacementType {
    public static final ResourcefulRegistry<StructurePlacementType<?>> STRUCTURE_PLACEMENT_TYPE = ResourcefulRegistries.create(Registry.STRUCTURE_PLACEMENT_TYPE, MNSCommon.MODID);

    public static final RegistryEntry<StructurePlacementType<AdvancedRandomSpread>> ADVANCED_RANDOM_SPREAD = STRUCTURE_PLACEMENT_TYPE.register("advanced_random_spread", () -> () -> AdvancedRandomSpread.CODEC);
}
