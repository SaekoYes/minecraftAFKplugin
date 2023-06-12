package me.saeko.afk.Listeners;

import me.saeko.afk.Afk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerLeaveListener implements Listener {

    Afk mainClass = Afk.getPlugin();

    //thing that removes the player from the afk array list when they leave
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(mainClass.checkForPlayer(p)){
            mainClass.removePlayer(p);
        }
    }
}
