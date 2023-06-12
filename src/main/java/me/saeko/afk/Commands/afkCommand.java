package me.saeko.afk.Commands;

import me.saeko.afk.Afk;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class afkCommand implements CommandExecutor {
    Afk mainClass = Afk.getPlugin();

    //Command that makes a player go afk if they do /afk and unafks them if they movez
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        Bukkit.broadcastMessage(p.getDisplayName() + " has gone afk");
        mainClass.checkForPlayer(p);
        mainClass.addPlayer(p);

        return true;
    }
}