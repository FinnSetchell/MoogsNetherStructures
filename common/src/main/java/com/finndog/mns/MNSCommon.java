package com.finndog.mns;

import com.finndog.mns.events.lifecycle.RegisterReloadListenerEvent;
import com.finndog.mns.events.lifecycle.ServerGoingToStartEvent;
import com.finndog.mns.events.lifecycle.ServerGoingToStopEvent;
import com.finndog.mns.events.lifecycle.SetupEvent;
import com.finndog.mns.modinit.MNSPlacements;
import com.finndog.mns.modinit.MNSProcessors;
import com.finndog.mns.modinit.MNSStructurePieces;
import com.finndog.mns.modinit.MNSStructurePlacementType;
import com.finndog.mns.modinit.MNSStructures;
import com.finndog.mns.modinit.MNSTags;
import com.finndog.mns.utils.AsyncLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MNSCommon {
    public static final String MODID = "mns";
    public static final Logger LOGGER = LogManager.getLogger();

    public static void init() {
        MNSTags.initTags();

        MNSStructures.STRUCTURE_TYPE.init();
        MNSPlacements.PLACEMENT_MODIFIER.init();
        MNSProcessors.STRUCTURE_PROCESSOR.init();
        MNSStructurePieces.STRUCTURE_PIECE.init();
        MNSStructurePieces.STRUCTURE_POOL_ELEMENT.init();
        MNSStructurePlacementType.STRUCTURE_PLACEMENT_TYPE.init();

        SetupEvent.EVENT.addListener(MNSCommon::setup);
        RegisterReloadListenerEvent.EVENT.addListener(MNSCommon::registerDatapackListener);
        ServerGoingToStartEvent.EVENT.addListener(MNSCommon::serverAboutToStart);
        ServerGoingToStopEvent.EVENT.addListener(MNSCommon::onServerStopping);
    }

    private static void setup(final SetupEvent event) {
    }

    private static void serverAboutToStart(final ServerGoingToStartEvent event) {

        AsyncLocator.handleServerAboutToStartEvent();
    }

    private static void onServerStopping(final ServerGoingToStopEvent event) {
        AsyncLocator.handleServerStoppingEvent();
    }

    public static void registerDatapackListener(final RegisterReloadListenerEvent event) {
    }
}
