package com.Microsoft.AdminCommands;

import com.Microsoft.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kill implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!player.hasPermission("FireFly-Utils.Kill")) return false;

        if (args.length == 0){
            Message.playerMessage(player, "&dHahaha lol ur dead :)");
            player.setHealth(0);
            return true;
        }

        if (args.length == 1){
            Message.playerMessage(player, "&d hahaha I see a war brewing :)");
            Player target = Bukkit.getPlayerExact(args[0]);
            target.setHealth(0);
        }

        System.out.println("test");


        return true;
    }
}
