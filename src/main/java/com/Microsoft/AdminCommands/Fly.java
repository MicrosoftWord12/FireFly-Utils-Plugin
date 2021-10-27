package com.Microsoft.AdminCommands;

import com.Microsoft.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!player.hasPermission("FireFly-Utils.Fly")) return false;


        if (args.length == 0){
            if (player.isFlying()){
                Message.playerMessage(player, "&cYou are already Flying");
                player.setFlying(false);
                return false;
            }

            player.setFlying(true);
            Message.playerMessage(player, "&aYou can now fly");
        }

        if (args.length == 1){
            Player target = Bukkit.getPlayerExact(args[0]);

            if (target.isFlying()){
                Message.playerMessage(player, "&cThis player is already Flying");
                player.setFlying(false);
                return false;
            }

            target.setFlying(true);
            Message.playerMessage(player, "&aYou can now fly");
        }







        return true;
    }
}
