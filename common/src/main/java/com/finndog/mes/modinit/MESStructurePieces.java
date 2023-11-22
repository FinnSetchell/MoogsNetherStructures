package com.finndog.mes.modinit;

import com.finndog.mes.MESCommon;
import com.finndog.mes.modinit.registry.RegistryEntry;
import com.finndog.mes.modinit.registry.ResourcefulRegistries;
import com.finndog.mes.modinit.registry.ResourcefulRegistry;
import com.finndog.mes.world.structures.pieces.LegacyOceanBottomSinglePoolElement;
import com.finndog.mes.world.structures.pieces.MirroringSingleJigsawPiece;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;


public final class MESStructurePieces {
    public static final ResourcefulRegistry<StructurePoolElementType<?>> STRUCTURE_POOL_ELEMENT = ResourcefulRegistries.create(Registry.STRUCTURE_POOL_ELEMENT, MESCommon.MODID);
    public static final ResourcefulRegistry<StructurePieceType> STRUCTURE_PIECE = ResourcefulRegistries.create(Registry.STRUCTURE_PIECE, MESCommon.MODID);

    public static final RegistryEntry<StructurePoolElementType<MirroringSingleJigsawPiece>> MIRROR_SINGLE = STRUCTURE_POOL_ELEMENT.register("mirroring_single_pool_element", () -> () -> MirroringSingleJigsawPiece.CODEC);
    public static final RegistryEntry<StructurePoolElementType<LegacyOceanBottomSinglePoolElement>> LEGACY_OCEAN_BOTTOM = STRUCTURE_POOL_ELEMENT.register("legacy_ocean_bottom_single_pool_element", () -> () -> LegacyOceanBottomSinglePoolElement.CODEC);
}
