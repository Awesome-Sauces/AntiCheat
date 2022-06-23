package com.alpha.aplus;

import com.alpha.aplus.commands.command;
import com.alpha.aplus.events.EventHandler;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import net.citizensnpcs.api.CitizensAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class aplus  extends JavaPlugin {

    private ProtocolManager protocolManager;

    @Override
    public void onEnable() {

        protocolManager = ProtocolLibrary.getProtocolManager();


        // Disable all sound effects
        protocolManager.addPacketListener(
                new PacketAdapter(this, ListenerPriority.NORMAL,
                        PacketType.Play.Client.USE_ENTITY) {
                    @Override
                    public void onPacketSending(PacketEvent event) {
                        // Item packets (id: 0x29)
                        if (!CitizensAPI.getNPCRegistry().isNPC(event.getPlayer())) {
                            Bukkit.broadcastMessage(String.valueOf(event.getPacketType()));
                        }
                    }
                });


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
