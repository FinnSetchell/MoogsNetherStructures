package com.finndog.mns.events.lifecycle;


import com.finndog.mns.events.base.EventHandler;

import java.util.function.Consumer;

public record SetupEvent(Consumer<Runnable> enqueue) {

    public static final EventHandler<SetupEvent> EVENT = new EventHandler<>();

    /**
     * Forge runs in parallel with other mods so we need to enqueue some things.
     */
    public void enqueueWork(Runnable runnable) {
        enqueue.accept(runnable);
    }
}