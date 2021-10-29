package com.Microsoft.AdminCommands.Moderation;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pardon implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        if (!sender.hasPermission("FireFly.Unban")) return false;
        BanList banList = Bukkit.getBanList(BanList.Type.NAME);
        if (args.length == 1){
            Player target = Bukkit.getPlayerExact(args[0]);
            banList.pardon(target.getDisplayName());
        }











        return true;
    }
}
