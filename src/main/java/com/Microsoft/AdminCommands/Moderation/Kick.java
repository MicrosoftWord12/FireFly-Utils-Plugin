package com.Microsoft.AdminCommands.Moderation;

import com.Microsoft.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {

    public String reason = "";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        Player target = Bukkit.getPlayerExact(args[0]);

        for (int i = 1; i < args.length; i++){
            reason += args[i] + " ";
        }

        Message.playerMessage(player, String.format("&6You kicked %s for %s", target.getDisplayName(), reason));
        Message.serverKickMessage(String.format("&c%s kicked %s for %s", player.getDisplayName(), target.getDisplayName(), reason));
        target.kickPlayer(reason);






        return true;
    }
}
