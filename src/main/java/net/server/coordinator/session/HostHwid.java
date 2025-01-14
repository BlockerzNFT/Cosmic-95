package net.server.coordinator.session;

import net.server.Server;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

record HostHwid(Hwid hwid, Instant expiry) {
    static HostHwid createWithDefaultExpiry(Hwid hwid) {
        return new HostHwid(hwid, getDefaultExpiry());
    }

    private static Instant getDefaultExpiry() {
        return Instant.ofEpochMilli(Server.getInstance().getCurrentTime() + TimeUnit.DAYS.toMillis(7));
    }
}
