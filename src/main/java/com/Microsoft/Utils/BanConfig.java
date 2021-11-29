package com.Microsoft.Utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BanConfig {
    public static File banFile;
    public static FileConfiguration banCustom;

    public BanConfig(){
        banFile = new File(Bukkit.getServer().getPluginManager().getPlugin("FireFly-Utils").getDataFolder(), "data.yml");
        if (!banFile.exists()){
            try{
                if(banFile.createNewFile()){
                    Message.serverMessage("&aThe Ban Configuration File Has Been Made");
                }else{
                    Message.serverMessage("&cThe Ban Configuration File Has Not Been Made");
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        banCustom = YamlConfiguration.loadConfiguration(banFile);
    }

    public static void setBan(String player, String reason){
        try{
            List<String> playerName = new ArrayList<>(getBan().getStringList("BannedPlayers." + player + " .Reason" + reason));
            playerName.add(player);
            getBan().set("BannedPlayers." + playerName + ".Reason", reason);
//            getBan().set("BannedPlayers. " + player + " .Reason");
            getBan().save(banFile);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static FileConfiguration getBan(){
        return banCustom;
    }

}
