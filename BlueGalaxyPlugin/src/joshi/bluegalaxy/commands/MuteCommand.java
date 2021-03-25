package joshi.bluegalaxy.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class MuteCommand implements CommandExecutor, Listener, TabCompleter {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		
		if(!player.hasPermission("graygalaxy.admin")) {
			player.sendMessage("§8Du darfst das nicht machen");
			return false;
		}
		
		if(args.length != 1) {
			player.sendMessage("§8Bitte gebe einen Spieler an.");
			return false;
		}
		
		if(args[0].equalsIgnoreCase("list")) {
			String mutedList = "";
			
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(p.getScoreboardTags().contains("MUTE")) {
					mutedList += p.getName() + ", ";
				}
			}
			player.sendMessage("§8Gemutete Spieler: §6" + mutedList);
			return false;
		}
		
		Player target = Bukkit.getPlayer(args[0]);
		if(target.getScoreboardTags().contains("MUTE")) {
			target.removeScoreboardTag("MUTE");
			target.sendMessage("§8Du bist jetzt nicht mehr gemuted.");
			player.sendMessage( "§6" + args[0] + " §8ist jetzt nicht mehr gemuted");
		} else {
			target.addScoreboardTag("MUTE");
			target.sendMessage("§8Du bist jetzt gemuted.");
			player.sendMessage( "§6" + args[0] + " §8ist jetzt gemuted.");
		}
		return false;
	}
	
	@EventHandler
	public void event(PlayerChatEvent event) {
		if(event.getPlayer().getScoreboardTags().contains("MUTE")) {
			event.getPlayer().sendMessage("§8Deine Nachricht wurde nicht verschickt, da du gemuted bist.");
			event.setCancelled(true);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if(!sender.hasPermission("graygalaxy.admin")) {
			return null;
		}
		List<String> list = new ArrayList<>();
		
		for(Player player : sender.getServer().getOnlinePlayers()) {
			list.add(player.getName());
		}
		list.add("list");
		return list;
	}

}
