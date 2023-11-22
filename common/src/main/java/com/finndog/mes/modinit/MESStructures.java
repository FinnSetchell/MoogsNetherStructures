package com.finndog.mes.modinit;

import com.finndog.mes.MESCommon;
import com.finndog.mes.modinit.registry.RegistryEntry;
import com.finndog.mes.modinit.registry.ResourcefulRegistries;
import com.finndog.mes.modinit.registry.ResourcefulRegistry;
import com.finndog.mes.world.structures.GenericJigsawStructure;
import com.finndog.mes.world.structures.GenericNetherJigsawStructure;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.StructureType;


public final class MESStructures {
    public static final ResourcefulRegistry<StructureType<?>> STRUCTURE_TYPE = ResourcefulRegistries.create(BuiltInRegistries.STRUCTURE_TYPE, MESCommon.MODID);

    public static RegistryEntry<StructureType<GenericJigsawStructure>> GENERIC_JIGSAW_STRUCTURE = STRUCTURE_TYPE.register("mes_generic_jigsaw_structure", () -> () -> GenericJigsawStructure.CODEC);
    public static RegistryEntry<StructureType<GenericNetherJigsawStructure>> GENERIC_NETHER_JIGSAW_STRUCTURE = STRUCTURE_TYPE.register("mes_generic_nether_jigsaw_structure", () -> () -> GenericNetherJigsawStructure.CODEC);
}


