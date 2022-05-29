package com.alpha.aplus.checks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Reach {
    EntityDamageByEntityEvent event;

    public Reach(EntityDamageByEntityEvent event){
        this.event = event;
    }

    public void run(){


        Bukkit.broadcastMessage(ChatColor.YELLOW + "Reach " + ChatColor.GRAY + "called");
        boolean inRange = true;


        for(Entity entity : event.getEntity().getNearbyEntities(3.5, 3.5, 3.5)){
            if(entity.getType().equals(event.getDamager().getType())){
                if(event.getDamager().equals(entity)) inRange = false;
            }
        }

        if(inRange) Bukkit.broadcastMessage(ChatColor.RED + event.getDamager().getName() + ChatColor.GRAY + " flagged " + ChatColor.YELLOW + "Reach ");
    }
}
