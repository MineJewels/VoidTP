package org.minejewels.jewelsvoidtp;

import lombok.Getter;
import net.abyssdev.abysslib.config.AbyssConfig;
import net.abyssdev.abysslib.plugin.AbyssPlugin;
import net.abyssdev.abysslib.text.MessageCache;
import org.minejewels.jewelsvoidtp.listeners.PlayerDamage;
import org.minejewels.jewelsvoidtp.listeners.PlayerDeath;
import org.minejewels.jewelsvoidtp.listeners.PlayerMove;

@Getter
public final class JewelsVoidTP extends AbyssPlugin {

    private final AbyssConfig settingsConfig = this.getAbyssConfig("settings");
    private final AbyssConfig langConfig = this.getAbyssConfig("lang");

    private final MessageCache messageCache = new MessageCache(this.langConfig);

    @Override
    public void onEnable() {
        this.loadMessages(this.messageCache, this.langConfig);

        new PlayerMove(this);
        new PlayerDamage(this);
        new PlayerDeath(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
