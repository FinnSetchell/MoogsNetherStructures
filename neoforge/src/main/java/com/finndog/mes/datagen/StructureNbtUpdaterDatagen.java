package com.finndog.mes.datagen;

import com.finndog.mes.MESCommon;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

// Source: https://github.com/BluSunrize/ImmersiveEngineering/blob/1.20.1/src/datagen/java/blusunrize/immersiveengineering/data/IEDataGenerator.java
@EventBusSubscriber(modid = MESCommon.MODID, bus = EventBusSubscriber.Bus.MOD)
public class StructureNbtUpdaterDatagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper exHelper = event.getExistingFileHelper();
        DataGenerator gen = event.getGenerator();
        final var output = gen.getPackOutput();

        if (event.includeServer()) {
            gen.addProvider(true, new StructureNbtUpdater("structures", MESCommon.MODID, exHelper, output));
        }
    }
}
