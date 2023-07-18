package org.minejewels.jewelsvoidtp.listeners;

import net.abyssdev.abysslib.listener.AbyssListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.minejewels.jewelsvoidtp.JewelsVoidTP;

public class PlayerDeath extends AbyssListener<JewelsVoidTP> {

    private final String spawnCommand;

    public PlayerDeath(final JewelsVoidTP plugin) {
        super(plugin);

        this.spawnCommand = plugin.getSettingsConfig().getString("spawn-command");
    }

    @EventHandler
    public void onDeath(final PlayerDeathEvent event) {

        final Player player = event.getEntity();

        player.performCommand(this.spawnCommand);
    }
}
