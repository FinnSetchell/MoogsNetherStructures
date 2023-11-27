package com.finndog.mns.modinit;

import com.finndog.mns.MNSCommon;
import com.finndog.mns.modinit.registry.RegistryEntry;
import com.finndog.mns.modinit.registry.ResourcefulRegistries;
import com.finndog.mns.modinit.registry.ResourcefulRegistry;
import com.finndog.mns.world.structures.pieces.LegacyOceanBottomSinglePoolElement;
import com.finndog.mns.world.structures.pieces.MirroringSingleJigsawPiece;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;


public final class MNSStructurePieces {
    public static final ResourcefulRegistry<StructurePoolElementType<?>> STRUCTURE_POOL_ELEMENT = ResourcefulRegistries.create(BuiltInRegistries.STRUCTURE_POOL_ELEMENT, MNSCommon.MODID);
    public static final ResourcefulRegistry<StructurePieceType> STRUCTURE_PIECE = ResourcefulRegistries.create(BuiltInRegistries.STRUCTURE_PIECE, MNSCommon.MODID);

    public static final RegistryEntry<StructurePoolElementType<MirroringSingleJigsawPiece>> MIRROR_SINGLE = STRUCTURE_POOL_ELEMENT.register("mirroring_single_pool_element", () -> () -> MirroringSingleJigsawPiece.CODEC);
    public static final RegistryEntry<StructurePoolElementType<LegacyOceanBottomSinglePoolElement>> LEGACY_OCEAN_BOTTOM = STRUCTURE_POOL_ELEMENT.register("legacy_ocean_bottom_single_pool_element", () -> () -> LegacyOceanBottomSinglePoolElement.CODEC);
}
