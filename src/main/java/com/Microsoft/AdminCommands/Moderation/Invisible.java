package com.Microsoft.AdminCommands.Moderation;

import com.Microsoft.Utils.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invisible implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!(sender.hasPermission("FireFly-Utils.Invisible"))){
            Message.playerMessage(player, "&cYou do not have the required permissions");
            return false;
        }
        if (player.isInvisible()){
            Message.playerMessage(player, "&cInvisibility Disabled");
            player.setInvisible(false);
        }else{
            Message.playerMessage(player, "&aInvisibility Enabled");
            player.setInvisible(true);
        }
        return true;
    }
}
