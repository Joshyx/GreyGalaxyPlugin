package joshi.bluegalaxy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class InfoCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		sender.sendMessage("§8------------------------------------------------");
		sender.sendMessage("§8Hallo, wir sind das Gray-Galaxy Team.");
		sender.sendMessage("§8Hast du Fragen, Wünsche oder Ideen um den Server");
		sender.sendMessage("§8zu verbessern, join doch unserem Discord:");
		sender.sendMessage("§6§ohttps://discord.gg/WncfRaGmHf");
		sender.sendMessage("");
		sender.sendMessage("§6§n§lCommands:");
		
		sender.sendMessage("§8-§6/rickroll: §8Rickrolle den Server!");
		sender.sendMessage("§8-§6/lobby: §8Teleportier dich zur Lobby");
		sender.sendMessage("§8-§6/enderchest §8oder §6/ec: §8Öffne deine Enderchest");
		sender.sendMessage("§8-§6/backpack §8oder §6/bp: §8Öffne dein Backpack");
		sender.sendMessage("§8-§6/afk: §8Gehe AFK bzw. wieder online");
		sender.sendMessage("");
		
		sender.sendMessage("§6§nAdmimcommands:");
		sender.sendMessage("§8-§6/mute <spieler>: §8Mute bzw. entmute einen Spieler");
		sender.sendMessage("§8-§6/mute list: §8Liste alle gemuteten Spieler auf");
		sender.sendMessage("§8-§6/inv <spieler>: §8Schau dir das Inventar eines Spielers an");
		sender.sendMessage("§8-§6/bp clear: §8Lösche alle Backpacks");
		sender.sendMessage("§8-§6/bp clear <spieler>: §8Lösche das Backpack eines Spielers");
		sender.sendMessage("§8-§6/bp see <spieler>: §8Schau dir das Backpack eines Spielers an");
		sender.sendMessage("§8-§6/god: §8Werde zum §6§lGOTT");
		sender.sendMessage("§8------------------------------------------------");
		
		return false;
	}

}
