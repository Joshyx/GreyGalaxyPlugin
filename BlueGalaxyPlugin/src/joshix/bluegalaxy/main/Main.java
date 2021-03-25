package joshix.bluegalaxy.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import joshi.bluegalaxy.commands.BackpackCommand;
import joshi.bluegalaxy.commands.ECCommand;
import joshi.bluegalaxy.commands.GodCommand;
import joshi.bluegalaxy.commands.InfoCommand;
import joshi.bluegalaxy.commands.AFKCommand;
import joshi.bluegalaxy.commands.BackpackAutocomplete;
import joshi.bluegalaxy.commands.InvseeCommand;
import joshi.bluegalaxy.commands.LobbyCommand;
import joshi.bluegalaxy.commands.MuteCommand;
import joshi.bluegalaxy.commands.RickrollCommand;
import joshix.bluegalaxy.listeners.AFKListener;
import joshix.bluegalaxy.listeners.Listerners;
import joshix.bluegalaxy.recipes.Recipes;
/*
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
*/
public class Main extends JavaPlugin{
	
	//public static JDA dcApi; 
	public static Main instance;
	
	
	public static Location lobbySpawn;
	public static Location bedwarsSpawn;
	public static Location murderSpawn;
	public static Location farmSpawn;
	
	public static HashMap<Player, Inventory> backpack = new HashMap<>();

	public void onEnable(){
		/*
		try {
			dcApi = JDABuilder.createDefault("ODA1MDk0ODIyNDg2MzQzNjgx.YBV4-w.m46_cJQAvu1-U0WWXCUu8RXKRH4").build();
		} catch(Exception e){
			System.out.println("Falsches Token");
		}
		
		dcApi.getPresence().setActivity(Activity.streaming("Blue Galaxy", "https://blue-galaxy.eu"));
		*/
		instance = this;
		
		getCommand("greygalaxy").setExecutor(new InfoCommand());
		getCommand("gg").setExecutor(new InfoCommand());
		getCommand("lobby").setExecutor(new LobbyCommand());
		getCommand("backpack").setExecutor(new BackpackCommand());
		getCommand("backpack").setTabCompleter(new BackpackAutocomplete());
		getCommand("bp").setExecutor(new BackpackCommand());
		getCommand("bp").setTabCompleter(new BackpackAutocomplete());
		getCommand("inv").setExecutor(new InvseeCommand());
		getCommand("ec").setExecutor(new ECCommand());
		getCommand("enderchest").setExecutor(new ECCommand());
		getCommand("rickroll").setExecutor(new RickrollCommand());
		getCommand("god").setExecutor(new GodCommand());
		getCommand("afk").setExecutor(new AFKCommand());
		getCommand("mute").setExecutor(new MuteCommand());
		getCommand("mute").setTabCompleter(new MuteCommand());
		
		Recipes.addRecipes();
		
		getServer().getPluginManager().registerEvents(new Listerners(), this);
		getServer().getPluginManager().registerEvents(new AFKListener(), this);
		getServer().getPluginManager().registerEvents(new MuteCommand(), this);
		
		lobbySpawn = new Location(Bukkit.getWorld("world"), -22.5, 65, 138.5, 180, 0);
		bedwarsSpawn = new Location(Bukkit.getWorld("bedwars"), -192.5, 4, 119.5, 180, 0);
		farmSpawn = new Location(Bukkit.getWorld("farmwelt"), -99.5, 64, -197, 0, 0);
		murderSpawn = new Location(Bukkit.getWorld("murdermystery"), -144.5, 4, -128.5, 180, 0);
	}
	
}
