package joshi.bluegalaxy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import joshix.bluegalaxy.main.Main;

public class LobbyCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			ByteArrayDataOutput out = ByteStreams.newDataOutput();
			out.writeUTF("Connect");
			out.writeUTF("lobby");    
			//applies to the player you send it to. aka Kick To Server.
			player.sendPluginMessage(Main.instance, "BungeeCord", out.toByteArray());
			
		}
		return false;
	}

}
