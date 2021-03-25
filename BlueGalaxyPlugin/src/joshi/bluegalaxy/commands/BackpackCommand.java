package joshi.bluegalaxy.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import joshix.bluegalaxy.main.Main;

public class BackpackCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(args.length == 0) {
				if(Main.backpack.containsKey(player)) {
					player.openInventory(Main.backpack.get(player));
				} else {
					Main.backpack.put(player, Bukkit.createInventory(null, 3*9, player.getName()));
					player.openInventory(Main.backpack.get(player));
				}
			} else if(args.length == 1) {
				if(!player.hasPermission("graygalaxy.admin")) {
					player.sendMessage("§8Du darfst das nicht machen");
					return false;
				}
				if(args[0].equalsIgnoreCase("clear")) {
					Main.backpack.clear();
					player.sendMessage("§8Alle Backpacks wurden gecleared.");
				} else{
					player.sendMessage("§8Bitte benutze §6/backpack");
				}
			} else if(args.length == 2){
				if(!player.hasPermission("graygalaxy.admin")) {
					player.sendMessage("§8Du darfst das nicht machen");
					return false;
				}
				if(args[0].equalsIgnoreCase("clear")) {
					Main.backpack.remove(Bukkit.getPlayer(args[1]));
					player.sendMessage("§8Das Backpack von §6" + args[1] + " §8wurde gecleared.");
				} else if(args[0].equalsIgnoreCase("see")) {
					if(Main.backpack.containsKey(player)) {
						player.openInventory(Main.backpack.get(Bukkit.getPlayer(args[1])));
					} else {
						Main.backpack.put(Bukkit.getPlayer(args[1]), Bukkit.createInventory(null, 3*9, Bukkit.getPlayer(args[1]).getName()));
						player.openInventory(Main.backpack.get(Bukkit.getPlayer(args[1])));
					}
				}
			}
			
			
		}
		return false;
	}

}
