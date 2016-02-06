package net.avicus.grave.event;

import lombok.Getter;
import lombok.ToString;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.joda.time.Instant;
import tc.oc.tracker.Lifetime;

@ToString(callSuper = true)
public class PlayerDeathEvent extends EntityDeathEvent {
    @Getter private final Player player;

    public PlayerDeathEvent(Player player, Location location, Lifetime lifetime, Instant time) {
        super(player, location, lifetime, time);
        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
