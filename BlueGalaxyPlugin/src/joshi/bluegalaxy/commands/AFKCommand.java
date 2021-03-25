package joshi.bluegalaxy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AFKCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(player.getScoreboardTags().contains("AFK")) {

				player.setDisplayName(player.getDisplayName().replaceAll("§7AFK - ", ""));
				player.setCustomName(player.getCustomName().replaceAll("§7AFK - ", ""));
				player.setInvulnerable(false);
				player.setCollidable(true);
				player.setSilent(false);
				
				player.removeScoreboardTag("AFK");
				player.sendMessage("§7Du bist nicht mehr AFK");
			} else {
				player.setDisplayName("§7AFK - " + player.getDisplayName() + "§r");
				player.setCustomName("§7AFK - " + player.getCustomName() + "§r");
				player.setInvulnerable(true);
				player.setCollidable(false);
				player.setSilent(true);
				
				player.addScoreboardTag("AFK");
				player.sendMessage("§7Du bist AFK");
				
			}
		}
		return false;
	}

}
