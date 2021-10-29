package com.Microsoft.Server.Listener;

import com.Microsoft.FireFlyUtils;
import com.Microsoft.Utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.util.CachedServerIcon;

import java.io.File;

public class onServerPingList implements Listener {
//    public Config config;
//    public FireFlyUtils plugin;
//
//    public onServerPingList(Config config, FireFlyUtils plugin){
//        this.config = config;
//        this.plugin = plugin;
//    }

    @EventHandler
    public void onServerPing(ServerListPingEvent e) throws Exception {


        // Icon Image
        String serverIconImage = Config.get().getString("server-icon");
        assert serverIconImage != null;

        CachedServerIcon iconFile = Bukkit.loadServerIcon(new File(Bukkit.getServer().getPluginManager().getPlugin("FireFlu-Utils").getDataFolder(), serverIconImage));

        // MOTD
        String serverMotd = Config.get().getString("server-motd-event");
        assert serverMotd != null;

        // Maximum Amount of Players
        int setMaxPlayers = Config.get().getInt("server-player-max");

        e.setMotd(ChatColor.translateAlternateColorCodes('&', serverMotd));
        e.setMaxPlayers(setMaxPlayers);
        e.setServerIcon(iconFile);


    }


}
