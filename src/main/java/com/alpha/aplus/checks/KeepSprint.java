package com.alpha.aplus.checks;


import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class KeepSprint {
    EntityDamageByEntityEvent event;

    public KeepSprint(EntityDamageByEntityEvent event) {
        this.event = event;

    }

}
