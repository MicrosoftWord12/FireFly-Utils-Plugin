package com.Microsoft.AdminCommands;

import com.Microsoft.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!player.hasPermission("FireFly-Utils.Gamemode")) return false;

        switch (label){
            case "gms":
                player.setGameMode(GameMode.SURVIVAL);
                Message.playerMessage(player, "&aYou are now in Survival Mode");
                break;

            case "gmc":
                player.setGameMode(GameMode.CREATIVE);
                Message.playerMessage(player, "&aYou are now in Creative Mode");
                break;


            case "gmsp":
                player.setGameMode(GameMode.SPECTATOR);
                Message.playerMessage(player, "&aYou are now in Spectator Mode");
                break;

            case "gma":
                player.setGameMode(GameMode.ADVENTURE);
                Message.playerMessage(player, "&aYou are now in Adventure Mode");
                break;
        }
        return true;
    }
}
