package org.minejewels.jewelsvoidtp.listeners;

import net.abyssdev.abysslib.listener.AbyssListener;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.minejewels.jewelsvoidtp.JewelsVoidTP;

public class PlayerMove extends AbyssListener<JewelsVoidTP> {

    private final String realmCommand, spawnCommand, spawnWorld;

    public PlayerMove(final JewelsVoidTP plugin) {
        super(plugin);

        this.realmCommand = plugin.getSettingsConfig().getString("realm-command");
        this.spawnCommand = plugin.getSettingsConfig().getString("spawn-command");
        this.spawnWorld = plugin.getSettingsConfig().getString("spawn-world");
    }

    @EventHandler
    public void onMove(final PlayerMoveEvent event) {
        final double fromY = event.getFrom().getY();

        final Player player = event.getPlayer();

        if(player.getLocation().getBlock().getType() != Material.AIR) return;

        if (fromY > -10) return;

        if(player.getLocation().getWorld().getName().equalsIgnoreCase(this.spawnWorld)) {
            this.plugin.getMessageCache().sendMessage(player, "messages.spawn-tp");
            player.performCommand(this.spawnCommand);
            return;
        }

        player.performCommand(this.realmCommand);
        this.plugin.getMessageCache().sendMessage(player, "messages.realm-tp");
    }
}
