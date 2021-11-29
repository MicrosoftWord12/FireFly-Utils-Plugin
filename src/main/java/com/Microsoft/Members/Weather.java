package com.Microsoft.Members;

import com.Microsoft.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Weather implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        World world = Bukkit.getWorld("world");
        switch (args[0]){
            case "storm":
                world.setStorm(true);
                Message.broadcastMessage("&aIt is now Storming");
                break;

            case "thunder":
                world.setThundering(true);
                Message.broadcastMessage("&aIt is now thundering");
                break;

            case "clear":
                world.setClearWeatherDuration(864000);
                Message.broadcastMessage("&aIt is now hopefully sunny");

            default:
                world.setClearWeatherDuration(864000);
                Message.broadcastMessage("&aIt is now hopefully sunny");
        }



        return true;
    }
}

