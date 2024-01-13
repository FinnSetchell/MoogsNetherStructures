package com.finndog.mns.modinit;

import com.finndog.mns.MNSCommon;
import com.finndog.mns.modinit.registry.RegistryEntry;
import com.finndog.mns.modinit.registry.ResourcefulRegistries;
import com.finndog.mns.modinit.registry.ResourcefulRegistry;
import com.finndog.mns.world.processors.WaterloggingFixProcessor;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public final class MNSProcessors {
    public static final ResourcefulRegistry<StructureProcessorType<?>> STRUCTURE_PROCESSOR = ResourcefulRegistries.create(Registry.STRUCTURE_PROCESSOR, MNSCommon.MODID);

    public static final RegistryEntry<StructureProcessorType<WaterloggingFixProcessor>> WATERLOGGING_FIX_PROCESSOR = STRUCTURE_PROCESSOR.register("waterlogging_fix_processor", () -> () -> WaterloggingFixProcessor.CODEC);
}