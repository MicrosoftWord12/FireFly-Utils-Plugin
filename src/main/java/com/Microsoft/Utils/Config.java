package com.Microsoft.Utils;

import com.Microsoft.FireFlyUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Config {
//    public FireFlyUtils plugin;
//
//    public Config(FireFlyUtils plugin){
//        this.plugin = plugin;
//    }

    public static File file;
    public static FileConfiguration configFile;
    public FireFlyUtils plugin;

    public Config(FireFlyUtils plugin){
        this.plugin = plugin;
        this.plugin.saveDefaultConfig();
        plugin.getConfig().options().copyDefaults(true);
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("FireFly-Utils").getDataFolder(), "config.yml");
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




//    public static void setup(){
////        TODO CHANGED THE FILE NAME
//        file = new File(Bukkit.getServer().getPluginManager().getPlugin("FireFly-Utils").getDataFolder(), "config.yml");
//        if (!file.exists()){
//            try{
//                if(file.createNewFile()){
//                    Message.serverMessage("&aThe Configuration File Has Been Made");
//                }else{
//                    Message.serverMessage("&cThe Configuration File Has Not Been Made");
//                }
//            }catch (IOException ex){
//                ex.printStackTrace();
//            }
//        }
//        configFile = YamlConfiguration.loadConfiguration(file);
//    }

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

//    public static void setDefault() {
//        try{
//            get().addDefault("server-icon", "icon.png");
//            get().addDefault("server-motd-event", "This is a default server MOTD");
//            get().addDefault("server-player-event", 10);
////            configFile.createSection("Test");
//            configFile.save(file);
//        }catch (IOException ex){
//            ex.printStackTrace();
//        }
//    }




}
