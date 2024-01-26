package joshi.bluegalaxy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RickrollCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.getServer().broadcastMessage("§8RevoX hat ein neues Video hochgeladen!§6 https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		return false;
	}

}
