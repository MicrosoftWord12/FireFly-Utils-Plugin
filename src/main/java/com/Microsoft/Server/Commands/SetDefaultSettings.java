package com.Microsoft.Server.Commands;

import com.Microsoft.Utils.Config;
import com.Microsoft.Utils.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetDefaultSettings implements CommandExecutor {
//    public Config config;
//
//    public SetDefaultSettings(Config config) {
//        this.config = config;
//    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (sender.getName().equalsIgnoreCase("MrSoftware")){
            Message.broadcastMessage("&6The Server's Configuration File has been reset");
            Message.serverMessage("&6The Server's Configuration File has been reset");
            Config.setDefault();
        }else{
            Message.playerMessage(player, "&6You are not the server owner");
            Message.serverMessage(String.format("&c%s tried to reset configuration", player.getDisplayName()));
        }
        return true;
    }
}
