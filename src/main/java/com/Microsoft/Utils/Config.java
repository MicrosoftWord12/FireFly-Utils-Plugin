package com.Microsoft.Utils;

import com.Microsoft.FireFlyUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
//    public FireFlyUtils plugin;
//
//    public Config(FireFlyUtils plugin){
//        this.plugin = plugin;
//    }

    public static File file;
    public static FileConfiguration configFile;

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("FireFly-Utils").getDataFolder(), "PluginConfig.yml");
        if (!file.exists()){
            try{
                if(file.createNewFile()){
                    Message.serverMessage("&aThe Configuration File Has Been Made");
                }else{
                    Message.serverMessage("&cThe Configuration File Has Not Been Made");
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        configFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return configFile;
    }

    public static void save(){
        try{
            configFile.save(file);
        }catch (IOException ex){
            Message.serverMessage(String.format("%s failed to save", ex));
        }
    }

    public static void setDefault() {
        try{
            configFile.addDefault("server-icon", "icon.png");
            configFile.addDefault("server-motd-event", "This is a default server MOTD");
            configFile.addDefault("server-player-max", "5");
            configFile.createSection("Test");
            configFile.save(file);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
