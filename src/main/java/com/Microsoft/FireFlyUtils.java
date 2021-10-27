package com.Microsoft;

import com.Microsoft.AdminCommands.*;
import com.Microsoft.AdminCommands.Moderation.Ban;
import com.Microsoft.AdminCommands.Moderation.Kick;
import com.Microsoft.Utils.Message;
import org.bukkit.plugin.java.JavaPlugin;

public final class FireFlyUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        Message.serverMessage("&aFireFly-Utils Started");

//      Config Stuff
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

//      Command Registration
        getCommand("Gamemode").setExecutor(new Gamemode());
        getCommand("Fly").setExecutor(new Fly());
        getCommand("Kill").setExecutor(new Kill());
        getCommand("Weather").setExecutor(new Weather());
        getCommand("Kick").setExecutor(new Kick());
        getCommand("Ban").setExecutor(new Ban());



    }

    @Override
    public void onDisable() {
        Message.serverMessage("&cFireFly-Utils Ended");
    }



}
