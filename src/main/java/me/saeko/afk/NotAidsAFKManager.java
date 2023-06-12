package me.saeko.afk;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Map;

public class NotAidsAFKManager implements Listener {

    Map<Player, Integer> afkTimers = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        resetTimer(player);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Bukkit.getScheduler().cancelTask(afkTimers.get(player));
        resetTimer(player);
    }

    public void resetTimer(final Player p) {
        afkTimers.put(p, Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("Afk"),new Runnable() {

            @Override
            public void run() {


            }
        }, 60000)); // Time
    }
}