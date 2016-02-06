package net.avicus.grave.listener;

import net.avicus.grave.GravePlugin;
import net.avicus.grave.event.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.joda.time.Instant;
import tc.oc.tracker.Lifetime;
import tc.oc.tracker.Lifetimes;

public class PlayerListener implements Listener {
    private final GravePlugin grave;

    public PlayerListener(GravePlugin grave) {
        this.grave = grave;
    }
    
    @EventHandler
    public void onEntityDeath(org.bukkit.event.entity.EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        Lifetime lifetime = Lifetimes.getLifetime(entity);
        Location location = entity.getLocation();
        Instant time = lifetime.getEnd();

        EntityDeathEvent call;

        if (lifetime.getLastDamage() == null || lifetime.getLastDamage().getInfo().getResolvedDamager() == null) {
            if (entity instanceof Player)
                call = new PlayerDeathEvent((Player) entity, location, lifetime, time);
            else
                call = new EntityDeathEvent(entity, location, lifetime, time);
        }
        else {

            LivingEntity cause = lifetime.getLastDamage().getInfo().getResolvedDamager();

            if (entity instanceof Player) {
                if (cause instanceof Player)
                    call = new PlayerDeathByPlayerEvent((Player) entity, location, lifetime, time, (Player) cause);
                else
                    call = new PlayerDeathByEntityEvent<>((Player) entity, location, lifetime, time, cause);
            }
            else {
                if (cause instanceof Player)
                    call = new EntityDeathByPlayerEvent(entity, location, lifetime, time, (Player) cause);
                else
                    call = new EntityDeathByEntityEvent<>(entity, location, lifetime, time, cause);
            }
        }

        grave.callEvent(call);
    }
}
