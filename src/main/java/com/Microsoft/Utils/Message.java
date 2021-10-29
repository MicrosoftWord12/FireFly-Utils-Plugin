package com.Microsoft.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Message {

    public static void serverMessage(String message){
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[FireFly-Utils] " + message));
    }

    public static void serverBanMessage(String message){
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[FireFly-Utils] " + message));
    }

    public static void serverPardonMessage(String message){
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[FireFly-Utils] " + message));
    }

    public static void serverKickMessage(String message){
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[FireFly-Utils] " + message));
    }

    public static void playerMessage(Player player, String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void broadcastMessage(String message){
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void serverStartMessage(String message){
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[FireFly-Utils] " + message));
    }

    public static void serverEndMessage(String message){
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[FireFly-Utils] " + message));
    }


}
