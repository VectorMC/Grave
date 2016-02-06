package net.avicus.grave.event;

import lombok.Getter;
import lombok.ToString;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.joda.time.Instant;
import tc.oc.tracker.Lifetime;

@ToString(callSuper = true)
public class EntityDeathEvent extends EntityEvent {
    @Getter private final Location location;
    @Getter private final Lifetime lifetime;
    @Getter private final Instant time;

    public EntityDeathEvent(Entity entity, Location location, Lifetime lifetime, Instant time) {
        super(entity);
        this.location = location;
        this.lifetime = lifetime;
        this.time = time;
    }

    protected static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
