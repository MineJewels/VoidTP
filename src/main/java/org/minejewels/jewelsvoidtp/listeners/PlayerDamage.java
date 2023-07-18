package org.minejewels.jewelsvoidtp.listeners;

import net.abyssdev.abysslib.listener.AbyssListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.minejewels.jewelsvoidtp.JewelsVoidTP;

public class PlayerDamage extends AbyssListener<JewelsVoidTP> {

    public PlayerDamage(final JewelsVoidTP plugin) {
        super(plugin);
    }

    @EventHandler
    public void onFall(final EntityDamageEvent event) {
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        event.setCancelled(true);
    }
}
