package com.finndog.mns.modinit;

import com.finndog.mns.MNSCommon;
import com.finndog.mns.modinit.registry.RegistryEntry;
import com.finndog.mns.modinit.registry.ResourcefulRegistries;
import com.finndog.mns.modinit.registry.ResourcefulRegistry;
import com.finndog.mns.world.structures.GenericJigsawStructure;
import com.finndog.mns.world.structures.GenericNetherJigsawStructure;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.StructureType;


public final class MNSStructures {
    public static final ResourcefulRegistry<StructureType<?>> STRUCTURE_TYPE = ResourcefulRegistries.create(Registry.STRUCTURE_TYPES, MNSCommon.MODID);

    public static RegistryEntry<StructureType<GenericJigsawStructure>> GENERIC_JIGSAW_STRUCTURE = STRUCTURE_TYPE.register("mns_generic_jigsaw_structure", () -> () -> GenericJigsawStructure.CODEC);
    public static RegistryEntry<StructureType<GenericNetherJigsawStructure>> GENERIC_NETHER_JIGSAW_STRUCTURE = STRUCTURE_TYPE.register("mns_generic_nether_jigsaw_structure", () -> () -> GenericNetherJigsawStructure.CODEC);
}


