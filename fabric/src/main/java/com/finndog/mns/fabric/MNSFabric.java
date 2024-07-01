package com.finndog.mns.fabric;

import com.finndog.mns.MNSCommon;
import com.finndog.mns.events.lifecycle.RegisterReloadListenerEvent;
import com.finndog.mns.events.lifecycle.ServerGoingToStartEvent;
import com.finndog.mns.events.lifecycle.ServerGoingToStopEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.server.packs.PackType;

public class MNSFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        MNSCommon.init();

        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            ServerGoingToStartEvent.EVENT.invoke(new ServerGoingToStartEvent(server));

        });

        ServerLifecycleEvents.SERVER_STOPPING.register(server ->
                ServerGoingToStopEvent.EVENT.invoke(ServerGoingToStopEvent.INSTANCE));

        RegisterReloadListenerEvent.EVENT.invoke(new RegisterReloadListenerEvent((id, listener) ->
                ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricReloadListener(id, listener))));
    }
}
