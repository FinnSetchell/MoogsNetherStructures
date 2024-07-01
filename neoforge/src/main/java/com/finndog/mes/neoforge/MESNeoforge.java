package com.finndog.mes.neoforge;

import com.finndog.mes.MESCommon;
import com.finndog.mes.events.lifecycle.RegisterReloadListenerEvent;
import com.finndog.mes.events.lifecycle.ServerGoingToStartEvent;
import com.finndog.mes.events.lifecycle.ServerGoingToStopEvent;
import com.finndog.mes.events.lifecycle.SetupEvent;
import com.finndog.mes.modinit.registry.neoforge.ResourcefulRegistriesImpl;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;


@Mod(MESCommon.MODID)
public class MESNeoforge {

    public static IEventBus modEventBusTempHolder = null;

    public MESNeoforge(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(EventPriority.NORMAL, ResourcefulRegistriesImpl::onRegisterForgeRegistries);

        modEventBusTempHolder = modEventBus;
        MESCommon.init();
        modEventBusTempHolder = null;

        modEventBus.addListener(MESNeoforge::onSetup);

        IEventBus eventBus = NeoForge.EVENT_BUS;
        eventBus.addListener(MESNeoforge::onServerStarting);
        eventBus.addListener(MESNeoforge::onServerStopping);
        eventBus.addListener(MESNeoforge::onAddReloadListeners);
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
