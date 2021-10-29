package com.Microsoft.AdminCommands.Moderation;

import com.Microsoft.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        if (!sender.hasPermission("FireFly-Utils.God"))return false;
        Player player = (Player) sender;

        if (args.length == 0){
            if (player.isInvulnerable()){
                Message.playerMessage(player,"&cGod Mode Disabled");
                player.setInvulnerable(false);
                return true;
            }else{
                Message.playerMessage(player, "&aGod Mode Enabled");
                player.setInvulnerable(true);
            }
        }

        if (args.length == 1){
            Player target = Bukkit.getPlayerExact(args[0]);
            assert target != null;
            if (target.isInvulnerable()){
                Message.playerMessage(player, "&cDisabled God Mode for This Person");
                target.setInvulnerable(false);
                return true;
            }else{
                Message.playerMessage(player,"&aGod Mode Enabled For This Person");
                target.setInvulnerable(true);
            }
        }

        return true;
    }
}
