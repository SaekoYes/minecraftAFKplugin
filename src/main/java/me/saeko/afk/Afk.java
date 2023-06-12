package me.saeko.afk;

import me.saeko.afk.Commands.afkCommand;
import me.saeko.afk.Listeners.playerLeaveListener;
import me.saeko.afk.Listeners.playerMoveListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Afk extends JavaPlugin {

    private static Afk plugin = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getCommand("afk").setExecutor(new afkCommand());
        getServer().getPluginManager().registerEvents(new playerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new playerLeaveListener(), this);

    }

    public static Afk getPlugin() {
        return plugin;
    }

    List<Player> afkList = new ArrayList<>();

    public void addPlayer(Player p) {
        afkList.add(p);
    }

    public void removePlayer(Player p) {
        afkList.remove(p);
    }

    public boolean checkForPlayer(Player p) {
        afkList.contains(p);

        if (afkList.contains(p)) {
            return true;
        }
        else{
            return false;

        }
    }
}