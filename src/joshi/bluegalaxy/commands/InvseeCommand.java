package joshi.bluegalaxy.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvseeCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(!player.hasPermission("graygalaxy.admin")) {
				player.sendMessage("§8Du darfst das nicht machen");
				return false;
			}
			if(args.length == 0) {
				player.sendMessage("§8Bitte benutze §6/inv <spieler>");
			} else {
				Player target = Bukkit.getPlayer(args[0]);
				Inventory inv = target.getInventory();
				player.openInventory(inv);
			}
		}
		return false;
	}

}
