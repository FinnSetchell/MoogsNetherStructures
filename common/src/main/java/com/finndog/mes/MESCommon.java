package com.finndog.mes;

import com.finndog.mes.events.lifecycle.RegisterReloadListenerEvent;
import com.finndog.mes.events.lifecycle.ServerGoingToStartEvent;
import com.finndog.mes.events.lifecycle.ServerGoingToStopEvent;
import com.finndog.mes.events.lifecycle.SetupEvent;
import com.finndog.mes.misc.pooladditions.PoolAdditionMerger;
import com.finndog.mes.modinit.MESPlacements;
import com.finndog.mes.modinit.MESProcessors;
import com.finndog.mes.modinit.MESStructurePieces;
import com.finndog.mes.modinit.MESStructurePlacementType;
import com.finndog.mes.modinit.MESStructures;
import com.finndog.mes.modinit.MESTags;
import com.finndog.mes.utils.AsyncLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MESCommon {
    public static final String MODID = "mes";
    public static final Logger LOGGER = LogManager.getLogger();

    public static void init() {
        MESTags.initTags();

        MESStructures.STRUCTURE_TYPE.init();
        MESPlacements.PLACEMENT_MODIFIER.init();
        MESProcessors.STRUCTURE_PROCESSOR.init();
        MESStructurePieces.STRUCTURE_PIECE.init();
        MESStructurePieces.STRUCTURE_POOL_ELEMENT.init();
        MESStructurePlacementType.STRUCTURE_PLACEMENT_TYPE.init();

        SetupEvent.EVENT.addListener(MESCommon::setup);
        RegisterReloadListenerEvent.EVENT.addListener(MESCommon::registerDatapackListener);
        ServerGoingToStartEvent.EVENT.addListener(MESCommon::serverAboutToStart);
        ServerGoingToStopEvent.EVENT.addListener(MESCommon::onServerStopping);
    }

    private static void setup(final SetupEvent event) {
    }

    private static void serverAboutToStart(final ServerGoingToStartEvent event) {
        PoolAdditionMerger.mergeAdditionPools(event);

        AsyncLocator.handleServerAboutToStartEvent();
    }

    private static void onServerStopping(final ServerGoingToStopEvent event) {
        AsyncLocator.handleServerStoppingEvent();
    }

    public static void registerDatapackListener(final RegisterReloadListenerEvent event) {
    }
}
