package net.avicus.grave.event;

import lombok.ToString;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.joda.time.Instant;
import tc.oc.tracker.Lifetime;

@ToString(callSuper = true)
public class EntityDeathByPlayerEvent extends EntityDeathByEntityEvent<Player> {
    public EntityDeathByPlayerEvent(Entity entity, Location location, Lifetime lifetime, Instant time, Player cause) {
        super(entity, location, lifetime, time, cause);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
