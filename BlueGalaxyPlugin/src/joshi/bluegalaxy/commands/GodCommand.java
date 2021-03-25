package joshi.bluegalaxy.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(!player.hasPermission("graygalaxy.admin")) {
				player.sendMessage("§8Nur die Admins sind §6Götter");
				return false;
			}
			
			if(player.getScoreboardTags().contains("GOD")) {
				for(Player players : Bukkit.getOnlinePlayers()) {
					players.showPlayer(player);
				}
				player.setInvulnerable(false);
				player.setCollidable(true);
				player.setSilent(false);
				player.setAllowFlight(false);
				player.setFlying(false);
				player.removeScoreboardTag("GOD");
				player.sendMessage("§8Du bist kein §6Gott §8mehr");
			} else {
				for(Player players : Bukkit.getOnlinePlayers()) {
					players.hidePlayer(player);
				}
				player.setInvulnerable(true);
				player.setCollidable(false);
				player.setSilent(true);
				player.setAllowFlight(true);
				player.setFlying(true);
				player.setFoodLevel(20);
				player.addScoreboardTag("GOD");
				player.sendMessage("§8Du bist ein §6Gott");
			}
		}
		return false;
	}

}
