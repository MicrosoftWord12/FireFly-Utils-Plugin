package com.Microsoft.Server.Listener;

import com.Microsoft.FireFlyUtils;
import com.Microsoft.Utils.Config;
import com.Microsoft.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.util.CachedServerIcon;

import java.io.File;
import java.util.Objects;

public class OnServerPingList implements Listener {

    @EventHandler
    public void onServerPing(ServerListPingEvent e) {


        // Icon Image
        Object serverIconImage = Config.get().get("server-icon");
        assert serverIconImage != null;

        // MOTD
        String serverMotd = Config.get().getString("server-motd-event");
        assert serverMotd != null;

        // Maximum Amount of Players
        int setMaxPlayers = Config.get().getInt("server-player-max");

        try{
//            CachedServerIcon iconFile = Bukkit.loadServerIcon(new File(serverIconImage));
//            e.setServerIcon(iconFile);
            e.setServerIcon(Bukkit.loadServerIcon(new File("icon.png")));
            System.out.println(Config.get().getString("server-motd-event"));

        }catch (Exception iconEx){
            Message.serverMessage("&cThe Icon file failed to load");
            System.out.println(Config.get().getString("server-icon"));
        }
        e.setMotd(ChatColor.translateAlternateColorCodes('&', serverMotd));
        e.setMaxPlayers(setMaxPlayers);



    }


}
