package com.Microsoft;

import com.Microsoft.AdminCommands.*;
import com.Microsoft.AdminCommands.Moderation.Ban;
import com.Microsoft.AdminCommands.Moderation.God;
import com.Microsoft.AdminCommands.Moderation.Kick;
import com.Microsoft.Server.Commands.SetDefaultSettings;
import com.Microsoft.Server.Listener.onServerPingList;
import com.Microsoft.Utils.Config;
import com.Microsoft.Utils.Message;
import org.bukkit.plugin.java.JavaPlugin;

public final class FireFlyUtils extends JavaPlugin {

    public static FireFlyUtils plugin;
    public Config config;

    @Override
    public void onEnable() {
        Message.serverStartMessage("&aFireFly-Utils Started");

//      Config Stuff
        getConfig().options().copyDefaults();
        saveDefaultConfig();

//        CustomConfig
//        config = new Config();
        Config.setup();
        Config.setDefault();
        Config.get().options().copyDefaults(true);
        Config.save();

//      Command Registration
        getCommand("SetDefaultSettings").setExecutor(new SetDefaultSettings());
        getCommand("Gamemode").setExecutor(new Gamemode());
        getCommand("Fly").setExecutor(new Fly());
        getCommand("Kill").setExecutor(new Kill());
        getCommand("Weather").setExecutor(new Weather());
        getCommand("Kick").setExecutor(new Kick());
        getCommand("Ban").setExecutor(new Ban());
        getCommand("God").setExecutor(new God());

//      Event Listeners
        getServer().getPluginManager().registerEvents(new onServerPingList(), this);
    }

    @Override
    public void onDisable() {
        Message.serverEndMessage("&cFireFly-Utils Ended");
        config.save();
    }



}
