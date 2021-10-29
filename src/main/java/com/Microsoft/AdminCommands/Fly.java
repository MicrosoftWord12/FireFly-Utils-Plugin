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
            isFlying(player);
            return true;
        }

        if (args.length == 1){
            Player target = Bukkit.getPlayerExact(args[0]);
            assert target != null;
            isFlying(target);
            return true;
        }


        return true;
    }

    public boolean isFlying(Player player){
        if (player.getAllowFlight()){
            if (player.isFlying()){
                Message.playerMessage(player, "&cWatch him drop from the sky");
                player.setAllowFlight(false);
                player.setFlying(false);
                return true;
            }

        }else if (!player.getAllowFlight()){
            if (!player.isFlying()){
                Message.playerMessage(player, "&aYou can now fly");
                player.setAllowFlight(true);
                player.setFlying(true);
                return true;
            }

        }
        return true;
    }
}

