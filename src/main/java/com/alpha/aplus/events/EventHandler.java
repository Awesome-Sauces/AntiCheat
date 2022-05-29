package com.alpha.aplus.events;

import com.alpha.aplus.checks.Killaura;
import com.alpha.aplus.checks.Reach;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventHandler implements Listener {
    @org.bukkit.event.EventHandler
    public void registerFlags(EntityDamageByEntityEvent event){
        if(event.getDamager() instanceof Player){
            new Reach(event).run();
            new Killaura(event).run();
        }
    }
}
