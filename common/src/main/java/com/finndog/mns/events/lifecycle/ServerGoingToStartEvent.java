package com.finndog.mns.events.lifecycle;

import com.finndog.mns.events.base.EventHandler;
import net.minecraft.server.MinecraftServer;

public record ServerGoingToStartEvent(MinecraftServer server) {

    public static final EventHandler<ServerGoingToStartEvent> EVENT = new EventHandler<>();

    /*
    This is needed as intellij complains about the server field needing to be used in a try resource block.
     */
    public MinecraftServer getServer() {
        return server;
    }
}
