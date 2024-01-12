package com.finndog.mns.events.lifecycle;


import com.finndog.mns.events.base.EventHandler;

public class ServerGoingToStopEvent {

    public static final ServerGoingToStopEvent INSTANCE = new ServerGoingToStopEvent();

    public static final EventHandler<ServerGoingToStopEvent> EVENT = new EventHandler<>();

    private ServerGoingToStopEvent() {}
}
