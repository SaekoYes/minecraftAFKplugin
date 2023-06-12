package me.saeko.afk.Listeners;

import me.saeko.afk.Afk;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class playerMoveListener implements Listener {

    Afk mainClass = Afk.getPlugin();
    //thing that makes sure a player unafks if they move <3
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(mainClass.checkForPlayer(p)) {
            mainClass.removePlayer(p);
            Bukkit.broadcastMessage(p.getDisplayName() + " is no longer afk");

        }
    }
}
