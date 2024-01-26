package joshi.bluegalaxy.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class BackpackAutocomplete implements TabCompleter{

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		List<String> complete = new ArrayList<>();
		if(!sender.hasPermission("graygalaxy.admin")) {
			return null;
		}
		
		if(args.length == 1) {
			complete.add("clear");
			complete.add("see");
		} else if(args.length == 2) {
			return null;
		}
		
		return complete;
	}

}
