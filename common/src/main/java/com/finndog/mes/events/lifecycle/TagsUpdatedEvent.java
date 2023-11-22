package com.finndog.mes.events.lifecycle;

import com.finndog.mes.events.base.EventHandler;
import net.minecraft.core.RegistryAccess;

public record TagsUpdatedEvent(RegistryAccess registryAccess, boolean fromPacket) {

    public static final EventHandler<TagsUpdatedEvent> EVENT = new EventHandler<>();
}
