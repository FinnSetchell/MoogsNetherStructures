package com.finndog.mns.world.structures.pieces;

import com.finndog.mns.modinit.MNSStructurePieces;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.Optional;

public class LegacyOceanBottomSinglePoolElement extends SinglePoolElement {
    public static final MapCodec<LegacyOceanBottomSinglePoolElement> CODEC = RecordCodecBuilder.mapCodec(
            (legacyOceanBottomSinglePoolElementInstance) -> legacyOceanBottomSinglePoolElementInstance
                    .group(templateCodec(),
                            processorsCodec(),
                            projectionCodec(),
                            overrideLiquidSettingsCodec())
                    .apply(legacyOceanBottomSinglePoolElementInstance, LegacyOceanBottomSinglePoolElement::new));

    protected LegacyOceanBottomSinglePoolElement(Either<ResourceLocation, StructureTemplate> resourceLocationStructureTemplateEither, Holder<StructureProcessorList> structureProcessorListHolder, StructureTemplatePool.Projection projection, Optional<LiquidSettings> liquidSettings) {
        super(resourceLocationStructureTemplateEither, structureProcessorListHolder, projection, liquidSettings);
    }

    @Override
    protected StructurePlaceSettings getSettings(Rotation rotation, BoundingBox mutableBoundingBox, LiquidSettings liquidSettings, boolean doNotReplaceJigsaw) {
        StructurePlaceSettings structureplacesettings = super.getSettings(rotation, mutableBoundingBox, liquidSettings, doNotReplaceJigsaw);
        structureplacesettings.popProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
        structureplacesettings.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
        return structureplacesettings;
    }

    public StructurePoolElementType<?> getType() {
        return MNSStructurePieces.LEGACY_OCEAN_BOTTOM.get();
    }

    public String toString() {
        return "LegacyOceanBottomSingle[" + this.template + "]";
    }
}