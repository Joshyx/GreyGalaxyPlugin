package joshi.bluegalaxy.commands;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class BlockCommand implements CommandExecutor, Listener {
	
	HashMap<Player, List<Player>> blockedPlayers = new HashMap<Player, List<Player>>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		
		Player target = Bukkit.getPlayer(args[0]);
		if(blockedPlayers.get(player).contains(target)) {
			blockedPlayers.get(player).remove(target);
			player.sendMessage( "§6" + args[0] + " §8ist jetzt nicht mehr geblockt.");
		} else {
			blockedPlayers.get(player).add(target);
			player.sendMessage( "§6" + args[0] + " §8ist jetzt geblockt.");
		}
		return false;
	}

}
