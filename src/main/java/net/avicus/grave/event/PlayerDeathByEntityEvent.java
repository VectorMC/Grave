package net.avicus.grave.event;

import lombok.ToString;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.joda.time.Instant;
import tc.oc.tracker.Lifetime;

@ToString(callSuper = true)
public class PlayerDeathByEntityEvent<T extends LivingEntity> extends PlayerDeathEvent {
    private final T cause;

    public PlayerDeathByEntityEvent(Player player, Location location, Lifetime lifetime, Instant time, T cause) {
        super(player, location, lifetime, time);
        this.cause = cause;
    }

    public T getCause() {
        return this.cause;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
