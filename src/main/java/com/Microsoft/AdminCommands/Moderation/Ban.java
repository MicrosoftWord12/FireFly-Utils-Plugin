package com.Microsoft.AdminCommands.Moderation;

import com.Microsoft.Utils.Message;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Ban implements CommandExecutor {

    String reason = "";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!player.hasPermission("FireFly-Utils.Ban")) return false;
        Player target = Bukkit.getPlayerExact(args[0]);
        BanList banList = Bukkit.getBanList(BanList.Type.NAME);
        for (int i = 1; i < args.length; i++){
            reason += args[i] + " ";
        }
        // Banning the player
        assert target != null;
        if (!target.isOnline()){
            Message.playerMessage(player, "&cThis player isn't online");
            return true;
        }else if (target.isBanned()){
            Message.playerMessage(player, "&cThis player is Banned");
            return true;
        }
        Message.serverBanMessage(String.format("&a%s has been Banned by %s for %s", target.getDisplayName(), player.getDisplayName(), reason));
        banList.addBan(target.getDisplayName(), reason, null, player.getDisplayName());
        target.kickPlayer(reason);
        return true;
    }
}
