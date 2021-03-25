package joshix.bluegalaxy.listeners;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import joshix.bluegalaxy.main.Main;

public class AFKListener implements Listener{
	
	HashMap<Player, Integer> timeSinceLastMove = new HashMap<Player, Integer>();
	
	public AFKListener() {
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
			@Override
            public void run() {
            	for(Player players : Bukkit.getOnlinePlayers()) {
            		if(!timeSinceLastMove.containsKey(players)) {
            			timeSinceLastMove.put(players, new Integer(0));
            		}
        			timeSinceLastMove.put(players, new Integer(timeSinceLastMove.get(players).intValue() + 1));

        			if(timeSinceLastMove.get(players) >= 300) {
        				if(!players.getScoreboardTags().contains("AFK")) {
        					players.setDisplayName("§7AFK - " + players.getDisplayName() + "§r");
        					players.setCustomName("§7AFK - " + players.getCustomName() + "§r");
        					players.setInvulnerable(true);
        					players.setCollidable(false);
        					players.setSilent(true);
        					
        					players.addScoreboardTag("AFK");
        					players.sendMessage("§7Du bist AFK");
        				}
        			}
        			if(players.getInventory().getHelmet().getItemMeta().hasCustomModelData()) {
        				if(players.getInventory().getHelmet().getType() == Material.BEACON) {
            				players.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 5, false, false));
            				players.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 40, 1, false, false));
            				players.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 40, 1, false, false));
            			} 
        				if(players.getInventory().getHelmet().getType() == Material.END_ROD) {
            				players.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 300, 5, false, false));
            			}
        			}
        		}
            }
        }, 0, 20); //20 ticks = 1 second
        
	}
	
	@EventHandler
	public void event(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		
		timeSinceLastMove.put(player, new Integer(0));
		
		if(player.getScoreboardTags().contains("AFK")) {
			player.setDisplayName(player.getDisplayName().replaceAll("§7AFK - ", ""));
			player.setCustomName(player.getCustomName().replaceAll("§7AFK - ", ""));
			player.setInvulnerable(false);
			player.setCollidable(true);
			player.setSilent(false);
			
			player.removeScoreboardTag("AFK");
			player.sendMessage("§7Du bist nicht mehr AFK");
		}
	}

}
