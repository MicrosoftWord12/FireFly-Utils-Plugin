package com.Microsoft.Members;

import com.Microsoft.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Time implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!(sender.hasPermission("FireFly-utils.Time"))){
            Message.playerMessage(player, "&cYou do not have the required permissions");
        }

        World world = Bukkit.getWorld("world");
        assert world != null;

        switch (label){
            case "day":
                world.setFullTime(1000);
                Message.broadcastMessage("&aIt is now Day");
                break;

            case "night":
                world.setFullTime(18000);
                Message.broadcastMessage("&aIt is now Night");
                break;

            default:
                world.setTime(1000);
                Message.broadcastMessage("Time is set to the default time");
                break;
        }
        return true;
    }
}
