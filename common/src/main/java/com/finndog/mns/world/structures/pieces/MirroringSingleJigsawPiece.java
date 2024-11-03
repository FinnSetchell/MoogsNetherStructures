package com.finndog.mns.world.structures.pieces;

import com.finndog.mns.mixins.structures.SinglePoolElementAccessor;
import com.finndog.mns.modinit.MNSStructurePieces;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MirroringSingleJigsawPiece extends SinglePoolElement {
    public static final MapCodec<MirroringSingleJigsawPiece> CODEC = RecordCodecBuilder.mapCodec((jigsawPieceInstance) ->
            jigsawPieceInstance.group(
                            templateCodec(),
                            processorsCodec(),
                            projectionCodec(),
                            mirrorCodec(),
                            overrideLiquidSettingsCodec())
                    .apply(jigsawPieceInstance, MirroringSingleJigsawPiece::new));

    protected static <E extends MirroringSingleJigsawPiece> RecordCodecBuilder<E, Mirror> mirrorCodec() {
        return Codec.STRING.fieldOf("mirror")
                .xmap(Mirror::valueOf, Mirror::toString)
                .forGetter((jigsawPieceInstance) -> jigsawPieceInstance.mirror);
    }

    protected final Mirror mirror;

    public MirroringSingleJigsawPiece(SinglePoolElement singleJigsawPiece, Mirror mirror, Optional<LiquidSettings> liquidSettings) {
        this(((SinglePoolElementAccessor)singleJigsawPiece).mns_getTemplate(), ((SinglePoolElementAccessor)singleJigsawPiece).mns_getProcessors(), singleJigsawPiece.getProjection(), mirror, liquidSettings);
    }

    protected MirroringSingleJigsawPiece(Either<ResourceLocation, StructureTemplate> locationTemplateEither, Holder<StructureProcessorList> processorListSupplier, StructureTemplatePool.Projection placementBehaviour, Mirror mirror, Optional<LiquidSettings> liquidSettings) {
        super(locationTemplateEither, processorListSupplier, placementBehaviour, liquidSettings);
        this.mirror = mirror;
    }

    private StructureTemplate getTemplate(StructureTemplateManager templateManager) {
        return this.template.map(templateManager::getOrCreate, Function.identity());
    }

    @Override
    public List<StructureTemplate.StructureBlockInfo> getShuffledJigsawBlocks(StructureTemplateManager templateManager, BlockPos blockPos, Rotation rotation, RandomSource random) {
        StructureTemplate template = this.getTemplate(templateManager);
        ObjectArrayList<StructureTemplate.StructureBlockInfo> list = template.filterBlocks(blockPos, (new StructurePlaceSettings()).setRotation(rotation).setMirror(mirror), Blocks.JIGSAW, true);
        Util.shuffle(list, random);
        return list;
    }

    @Override
    public BoundingBox getBoundingBox(StructureTemplateManager templateManager, BlockPos blockPos, Rotation rotation) {
        StructureTemplate template = this.getTemplate(templateManager);
        return template.getBoundingBox((new StructurePlaceSettings()).setRotation(rotation).setMirror(this.mirror), blockPos);
    }

    @Override
    public boolean place(StructureTemplateManager templateManager,
                         WorldGenLevel worldGenLevel,
                         StructureManager StructureTemplateManager,
                         ChunkGenerator chunkGenerator,
                         BlockPos blockPos,
                         BlockPos blockPos1,
                         Rotation rotation,
                         BoundingBox mutableBoundingBox,
                         RandomSource random,
                         LiquidSettings liquidSettings,
                         boolean doNotReplaceJigsaw)
    {
        StructureTemplate template = this.getTemplate(templateManager);
        StructurePlaceSettings placementsettings = this.getSettings(rotation, mutableBoundingBox, liquidSettings, doNotReplaceJigsaw);
        if (!template.placeInWorld(worldGenLevel, blockPos, blockPos1, placementsettings, random, 18)) {
            return false;
        } else {
            for(StructureTemplate.StructureBlockInfo template$blockinfo : StructureTemplate.processBlockInfos(worldGenLevel, blockPos, blockPos1, placementsettings, this.getDataMarkers(templateManager, blockPos, rotation, false))) {
                this.handleDataMarker(worldGenLevel, template$blockinfo, blockPos, rotation, random, mutableBoundingBox);
            }

            return true;
        }
    }

    @Override
    protected StructurePlaceSettings getSettings(Rotation rotation, BoundingBox mutableBoundingBox, LiquidSettings liquidSettings, boolean doNotReplaceJigsaw) {
        StructurePlaceSettings placementsettings = new StructurePlaceSettings();
        placementsettings.setBoundingBox(mutableBoundingBox);
        placementsettings.setRotation(rotation);
        placementsettings.setMirror(mirror);
        placementsettings.setIgnoreEntities(false);
        placementsettings.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
        placementsettings.setFinalizeEntities(true);
        placementsettings.setLiquidSettings(this.overrideLiquidSettings.orElse(liquidSettings));
        if (!doNotReplaceJigsaw) {
            placementsettings.addProcessor(JigsawReplacementProcessor.INSTANCE);
        }

        this.processors.value().list().forEach(placementsettings::addProcessor);
        this.getProjection().getProcessors().forEach(placementsettings::addProcessor);
        return placementsettings;
    }

    @Override
    public StructurePoolElementType<?> getType() {
        return MNSStructurePieces.MIRROR_SINGLE.get();
    }

    @Override
    public String toString() {
        return "Mirror_Single[" + this.template + "]";
    }
}
