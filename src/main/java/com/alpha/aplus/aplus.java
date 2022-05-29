package com.alpha.aplus;

import com.alpha.aplus.commands.command;
import com.alpha.aplus.events.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class aplus  extends JavaPlugin {

    @Override
    public void onEnable() {
        command commands = new command();
        getServer().getPluginManager().registerEvents(new EventHandler(),this);
        getCommand("aplus").setExecutor(commands);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[aPlus] plugin is enabled");

        aplus plugin = this;

        new BukkitRunnable() {

            @Override
            public void run() {

            }
        }.runTaskTimer(plugin, 3600, 3600);

        new BukkitRunnable() {

            @Override
            public void run() {

            }
        }.runTaskTimer(plugin, 1, 1);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {


            }
        }, 0L, 12000L); //0 Tick initial delay, 20 Tick (1 Second) between repeats

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Redux] plugin is disabled");

    }

}
