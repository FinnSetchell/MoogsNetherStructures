package com.finndog.mns.neoforge;

import com.finndog.mns.MNSCommon;
import com.finndog.mns.events.lifecycle.RegisterReloadListenerEvent;
import com.finndog.mns.events.lifecycle.ServerGoingToStartEvent;
import com.finndog.mns.events.lifecycle.ServerGoingToStopEvent;
import com.finndog.mns.events.lifecycle.SetupEvent;
import com.finndog.mns.modinit.registry.neoforge.ResourcefulRegistriesImpl;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;


@Mod(MNSCommon.MODID)
public class MNSNeoforge {

    public MNSNeoforge(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(EventPriority.NORMAL, ResourcefulRegistriesImpl::onRegisterForgeRegistries);

        MNSCommon.init();

        modEventBus.addListener(MNSNeoforge::onSetup);

        IEventBus eventBus = NeoForge.EVENT_BUS;
        eventBus.addListener(MNSNeoforge::onServerStarting);
        eventBus.addListener(MNSNeoforge::onServerStopping);
        eventBus.addListener(MNSNeoforge::onAddReloadListeners);
    }

    private static void onSetup(FMLCommonSetupEvent event) {
        SetupEvent.EVENT.invoke(new SetupEvent(event::enqueueWork));
    }

    private static void onServerStarting(ServerAboutToStartEvent event) {
        ServerGoingToStartEvent.EVENT.invoke(new ServerGoingToStartEvent(event.getServer()));
    }

    private static void onServerStopping(ServerStoppingEvent event) {
        ServerGoingToStopEvent.EVENT.invoke(ServerGoingToStopEvent.INSTANCE);
    }

    private static void onAddReloadListeners(AddReloadListenerEvent event) {
        RegisterReloadListenerEvent.EVENT.invoke(new RegisterReloadListenerEvent((id, listener) -> event.addListener(listener)));
    }

}
