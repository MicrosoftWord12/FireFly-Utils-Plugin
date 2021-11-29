package com.Microsoft;

import com.Microsoft.AdminCommands.*;
import com.Microsoft.AdminCommands.Moderation.Ban;
import com.Microsoft.AdminCommands.Moderation.God;
import com.Microsoft.AdminCommands.Moderation.Invisible;
import com.Microsoft.AdminCommands.Moderation.Kick;
import com.Microsoft.Members.Time;
import com.Microsoft.Members.Weather;
import com.Microsoft.Server.Listener.OnPlayerJoin;
import com.Microsoft.Server.Listener.OnServerPingList;
import com.Microsoft.Utils.BanConfig;
import com.Microsoft.Utils.Config;
import com.Microsoft.Utils.Message;
import org.bukkit.plugin.java.JavaPlugin;

public final class FireFlyUtils extends JavaPlugin {

    public Config config;
    public BanConfig banConfig;

    @Override
    public void onEnable() {
        Message.serverStartMessage("&aFireFly-Utils Started");

//      Config Stuff
        config = new Config(this);
        banConfig = new BanConfig();


//      Command Registration
        getCommand("Invisible").setExecutor(new Invisible());
        getCommand("Time").setExecutor(new Time());
        getCommand("Gamemode").setExecutor(new Gamemode());
        getCommand("Fly").setExecutor(new Fly());
        getCommand("Kill").setExecutor(new Kill());
        getCommand("Weather").setExecutor(new Weather());
        getCommand("Kick").setExecutor(new Kick());
        getCommand("ban").setExecutor(new Ban());
        getCommand("God").setExecutor(new God());

//      Event Listeners
        getServer().getPluginManager().registerEvents(new OnServerPingList(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
    }

    @Override
    public void onDisable() {
        Message.serverEndMessage("&cFireFly-Utils Ended");
        Config.save();
    }



}
