package com.alpha.aplus.checks;

import com.alpha.aplus.utils.AABB;
import com.alpha.aplus.utils.BoundingBox;
import com.alpha.aplus.utils.Ray;
import com.alpha.aplus.utils.RayTrace;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Killaura {
    EntityDamageByEntityEvent event;

    public Killaura(EntityDamageByEntityEvent event){
        this.event = event;
    }

    public void run(){
        if(!(event.getDamager() instanceof Player)) return;

        Player player = getTargetPlayer((Player) event.getDamager(), 4);
        if(player == null){
            Bukkit.broadcastMessage(ChatColor.RED + ((Player) event.getDamager()).getDisplayName() + ChatColor.GRAY + " flagged " + ChatColor.YELLOW + "Killaura" );
        }

    }


    // Returns first player in the specified player's line of sight
// up to max blocks away, or null if none.
    private Player getTargetPlayer(Player player, int max) {
        List<Player> possible = player.getNearbyEntities(max, max, max).stream().filter(entity -> entity instanceof Player).map(entity -> (Player) entity)/*.filter(player::hasLineOfSight)*/.collect(Collectors.toList());
        Ray ray = Ray.from(player);
        double d = -1;
        Player closest = null;
        for (Player player1 : possible) {
            double dis = AABB.from(player1).collidesD(ray, 0, max);
            if (dis != -1) {
                if (dis < d || d == -1) {
                    d = dis;
                    closest = player1;
                }
            }
        }
        return closest;
    }
}
