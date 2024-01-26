package joshix.bluegalaxy.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import joshix.bluegalaxy.main.Main;

@SuppressWarnings("deprecation")
public class Listerners implements Listener{
	
	
	@EventHandler
	public void event(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta headMeta = (SkullMeta) playerHead.getItemMeta();
		headMeta.setDisplayName(ChatColor.DARK_GREEN + "Profil");
		headMeta.setCustomModelData(1);
		headMeta.setOwningPlayer(player);
		playerHead.setItemMeta(headMeta);
		player.getInventory().setItem(8, playerHead);
		
		ItemStack compass = new ItemStack(Material.COMPASS);
		CompassMeta compassMeta = (CompassMeta) compass.getItemMeta();
		compassMeta.setDisplayName("§6Navigation");
		compassMeta.addEnchant(Enchantment.ARROW_INFINITE, 50, true);
		compassMeta.setCustomModelData(1);
		compassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		compass.setItemMeta(compassMeta);
		player.getInventory().setItem(0, compass);
		player.chat("Moin Leute, ich bin wieder da!");
		event.setJoinMessage("");
	}
	
	@EventHandler
	public void event(PlayerDeathEvent event) {
		event.setKeepInventory(true);
	}
	
	@EventHandler
	public void event(PlayerQuitEvent event) {
		event.getPlayer().removeScoreboardTag("AFK");
		event.getPlayer().removeScoreboardTag("GOD");
	}

	@EventHandler
	public void event(PlayerInteractEvent event) {
		if(event.getItem().getType() == Material.PLAYER_HEAD && event.getItem().getItemMeta().getCustomModelData() == 1) {
			
			OpenProfile(event.getPlayer());
			event.setCancelled(true);
		} else if(event.getItem().getType() == Material.COMPASS && event.getItem().getItemMeta().getCustomModelData() == 1) {
			
			OpenNavigation(event.getPlayer());
			event.setCancelled(true);
		} 
	}
	
	@EventHandler
	public void event(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		
		if(event.getCurrentItem().getType() == Material.LEATHER_HELMET && event.getCurrentItem().getItemMeta().getCustomModelData() == 1) {
			
			OpenHeads(player);
			event.setCancelled(true);
			return;
		} else if(event.getCurrentItem().getType() == Material.GOLDEN_BOOTS && event.getCurrentItem().getItemMeta().getCustomModelData() == 1) {
			
			OpenShoes(player);
			event.setCancelled(true);
			return;
		} else if(event.getCurrentItem().getType() == Material.BEACON && event.getCurrentItem().getItemMeta().getCustomModelData() == 2) {
			
			ItemStack beacon = new ItemStack(Material.BEACON);
			ItemMeta beaconMeta = beacon.getItemMeta();
			beaconMeta.setCustomModelData(2);
			beacon.setItemMeta(beaconMeta);
			player.getInventory().setHelmet(beacon);
			event.setCancelled(true);
			OpenProfile(player);
			return;
		} else if(event.getCurrentItem().getType() == Material.WHITE_STAINED_GLASS_PANE && event.getCurrentItem().getItemMeta().hasCustomModelData()) {
			
			ItemStack air = new ItemStack(Material.AIR);
			int data = event.getCurrentItem().getItemMeta().getCustomModelData();
			switch (data) {
				case 2:
					player.getInventory().setHelmet(air);
					break;
				case 3:
					player.getInventory().setBoots(air);
					player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
					player.removePotionEffect(PotionEffectType.REGENERATION);
					break;
			}
			OpenProfile(player);
			event.setCancelled(true);
			return;
		} else if(event.getCurrentItem().getType() == Material.END_ROD && event.getCurrentItem().getItemMeta().getCustomModelData() == 2) {
			
			ItemStack endrod = new ItemStack(Material.END_ROD);
			ItemMeta endrodMeta = endrod.getItemMeta();
			endrodMeta.setCustomModelData(3);
			endrod.setItemMeta(endrodMeta);
			player.getInventory().setHelmet(endrod);
			OpenProfile(player);
			event.setCancelled(true);
			return;
		} else if(event.getCurrentItem().getType() == Material.GOLDEN_BOOTS && event.getCurrentItem().getItemMeta().getCustomModelData() == 2) {
			
			ItemStack gucci = new ItemStack(Material.GOLDEN_BOOTS);
			ItemMeta gucciMeta = gucci.getItemMeta();
			gucciMeta.setDisplayName( "§bGucci Sneaker" );
			gucciMeta.addEnchant(Enchantment.SOUL_SPEED, 3, true);
			gucciMeta.addEnchant(Enchantment.PROTECTION_FALL, 5, true);
			gucciMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
			gucciMeta.setCustomModelData(3);
			player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
			player.removePotionEffect(PotionEffectType.REGENERATION);
			gucci.setItemMeta(gucciMeta);
			player.getInventory().setBoots(gucci);
			OpenProfile(player);
			event.setCancelled(true);
			return;
		} else if(event.getCurrentItem().getType() == Material.NETHERITE_BOOTS && event.getCurrentItem().getItemMeta().getCustomModelData() == 2) {
			
			ItemStack warrior = new ItemStack(Material.NETHERITE_BOOTS);
			ItemMeta warriorMeta = warrior.getItemMeta();
			warriorMeta.setDisplayName( "§bKämpferstiefel" );
			warriorMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
			warriorMeta.setCustomModelData(3);
			warrior.setItemMeta(warriorMeta);
			player.getInventory().setBoots(warrior);
			OpenProfile(player);
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 9, false, false));
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 5, false, false));
			event.setCancelled(true);
			return;
		} else if(event.getCurrentItem().getType() == Material.BARRIER && event.getCurrentItem().getItemMeta().hasCustomModelData()) {
			
			OpenProfile(player);
			event.setCancelled(true);
			return;
		} else if(event.getCurrentItem().getType() == Material.CAMPFIRE && event.getCurrentItem().getItemMeta().getCustomModelData() == 1) {
			
			player.teleport(Main.lobbySpawn);
			event.setCancelled(true);
			return;
		} else if(event.getCurrentItem().getType() == Material.RED_BED && event.getCurrentItem().getItemMeta().getCustomModelData() == 1) {
			
			player.teleport(Main.bedwarsSpawn);
			event.setCancelled(true);
			return;
		} else if(event.getCurrentItem().getType() == Material.GRASS_BLOCK && event.getCurrentItem().getItemMeta().getCustomModelData() == 1) {
			
			player.teleport(Main.farmSpawn);
			event.setCancelled(true);
			return;
		} else if(event.getCurrentItem().getType() == Material.IRON_SWORD && event.getCurrentItem().getItemMeta().getCustomModelData() == 1) {
			
			player.teleport(Main.murderSpawn);
			event.setCancelled(true);
			return;
		}
		
		if(event.getCurrentItem().getItemMeta().hasCustomModelData()) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void event(PlayerDropItemEvent event) {
		if(event.getItemDrop().getItemStack().getItemMeta().hasCustomModelData()) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void event(EntityPlaceEvent event) {
		if(event.getEntityType() == EntityType.ARMOR_STAND) {
			ArmorStand arm = (ArmorStand) event.getEntity();
			arm.setArms(true);
		}
	}
	
	@EventHandler
	public void event(PlayerInteractEntityEvent event) {
		
		if(event.getPlayer().getItemInHand().getType() == Material.NAME_TAG) {
			ArmorStand arm = (ArmorStand) event.getRightClicked();
			arm.setCustomName(event.getPlayer().getItemInHand().getItemMeta().getDisplayName());
			arm.setCustomNameVisible(true);
			event.getPlayer().getItemInHand().setAmount(event.getPlayer().getItemInHand().getAmount() - 1);
			event.setCancelled(true);
		}
		
	}
	
	void OpenProfile(Player player) {
		Inventory inv = Bukkit.createInventory(null, 3 * 9, ChatColor.YELLOW + "Profil");
		
		ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta playerHeadMeta = (SkullMeta) playerHead.getItemMeta();
		playerHeadMeta.setDisplayName( "§b" + player.getDisplayName() );
		playerHeadMeta.setOwningPlayer(player);
		playerHeadMeta.setCustomModelData(1);
		playerHead.setItemMeta(playerHeadMeta);
		inv.setItem(13, playerHead);
		
		ItemStack heads = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta headsMeta = (LeatherArmorMeta) heads.getItemMeta();
		headsMeta.setDisplayName( "§2Hüte" );
		headsMeta.setColor(Color.GREEN);
		headsMeta.setCustomModelData(1);
		heads.setItemMeta(headsMeta);
		inv.setItem(11, heads);
		
		ItemStack shoes = new ItemStack(Material.GOLDEN_BOOTS);
		ItemMeta shoesMeta = shoes.getItemMeta();
		shoesMeta.setDisplayName( "§2Schuhe" );
		shoesMeta.setCustomModelData(1);
		shoes.setItemMeta(shoesMeta);
		inv.setItem(15, shoes);
		
		player.openInventory(inv);
	}
	
	void OpenHeads(Player player) {
		Inventory inv = Bukkit.createInventory(null, InventoryType.DROPPER, ChatColor.YELLOW + "Hüte");
		
		ItemStack air = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
		ItemMeta airMeta = air.getItemMeta();
		airMeta.setDisplayName( "§7Nichts" );
		airMeta.setCustomModelData(2);
		air.setItemMeta(airMeta);
		inv.setItem(1, air);
		
		ItemStack unicorn = new ItemStack(Material.END_ROD);
		ItemMeta unicornMeta = unicorn.getItemMeta();
		unicornMeta.setDisplayName( "§dEinhorn" );
		List<String> unicornlore = new ArrayList<>();
		unicornlore.add("§8Fühl dich wie ein Einhorn");
		unicornlore.add("§b+2 Nachtsicht");
		unicornMeta.setLore(unicornlore);
		unicornMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
		unicornMeta.setCustomModelData(2);
		unicorn.setItemMeta(unicornMeta);
		inv.setItem(3, unicorn);
		
		ItemStack astronaut = new ItemStack(Material.BEACON);
		ItemMeta astronautMeta = astronaut.getItemMeta();
		List<String> astronautlore = new ArrayList<>();
		astronautlore.add("§8Bezwinge die Gravitation");
		astronautlore.add("§b+4 Jump Boost");
		astronautlore.add("§b+5 Slow Falling");
		astronautMeta.setLore(astronautlore);
		astronautMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
		astronautMeta.setDisplayName( "§9Astronaut" );
		astronautMeta.setCustomModelData(2);
		astronaut.setItemMeta(astronautMeta);
		inv.setItem(5, astronaut);
		
		ItemStack back = new ItemStack(Material.BARRIER);
		ItemMeta backMeta = back.getItemMeta();
		backMeta.setDisplayName( "§4Zurück" );
		backMeta.setCustomModelData(2);
		back.setItemMeta(backMeta);
		inv.setItem(7, back);
		
		player.openInventory(inv);
	}
	
	void OpenShoes(Player player) {
		Inventory inv = Bukkit.createInventory(null, InventoryType.DROPPER, ChatColor.YELLOW + "Schuhe");
		
		ItemStack air = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
		ItemMeta airMeta = air.getItemMeta();
		airMeta.setDisplayName( "§7Nichts" );
		airMeta.setCustomModelData(3);
		air.setItemMeta(airMeta);
		inv.setItem(1, air);
		
		ItemStack gucci = new ItemStack(Material.GOLDEN_BOOTS);
		ItemMeta gucciMeta = gucci.getItemMeta();
		gucciMeta.setDisplayName( "§6Gucci Sneaker" );
		List<String> guccilore = new ArrayList<>();
		guccilore.add("§8Sei der coolste auf dem Server");
		guccilore.add("§b+5 Speed");
		gucciMeta.setLore(guccilore);
		gucciMeta.addEnchant(Enchantment.SOUL_SPEED, 3, true);
		gucciMeta.setCustomModelData(2);
		gucci.setItemMeta(gucciMeta);
		inv.setItem(3, gucci);
		
		ItemStack warrior = new ItemStack(Material.NETHERITE_BOOTS);
		ItemMeta warriorMeta = warrior.getItemMeta();
		warriorMeta.setDisplayName( "§7Kämpferstiefel" );
		List<String> warriorlore = new ArrayList<>();
		warriorlore.add("§8Bekomme krasse Kräfte");
		warriorlore.add("§b+40 Health");
		warriorlore.add("§b+4 Regeneration");
		warriorMeta.setLore(warriorlore);
		warriorMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		warriorMeta.setCustomModelData(2);
		warrior.setItemMeta(warriorMeta);
		inv.setItem(5, warrior);
		
		ItemStack back = new ItemStack(Material.BARRIER);
		ItemMeta backMeta = back.getItemMeta();
		backMeta.setDisplayName( "§4Zurück" );
		backMeta.setCustomModelData(2);
		back.setItemMeta(backMeta);
		inv.setItem(7, back);
		
		player.openInventory(inv);
	}
	
	void OpenNavigation(Player player) {
		Inventory inv = Bukkit.createInventory(null, 3*9, ChatColor.YELLOW + "Navigation");
		
		ItemStack lobby = new ItemStack(Material.CAMPFIRE);
		ItemMeta lobbyMeta = lobby.getItemMeta();
		lobbyMeta.setDisplayName( "§7Lobby" );
		lobbyMeta.setCustomModelData(1);
		lobby.setItemMeta(lobbyMeta);
		inv.setItem(4, lobby);
		
		ItemStack bedwars = new ItemStack(Material.RED_BED);
		ItemMeta bedwarsMeta = bedwars.getItemMeta();
		bedwarsMeta.setDisplayName( "§4Bedwars" );
		bedwarsMeta.setCustomModelData(1);
		bedwars.setItemMeta(bedwarsMeta);
		inv.setItem(15, bedwars);
		
		ItemStack murder = new ItemStack(Material.IRON_SWORD);
		ItemMeta murderMeta = murder.getItemMeta();
		murderMeta.setDisplayName( "§6Murder Mysterie" );
		murderMeta.setCustomModelData(1);
		murder.setItemMeta(murderMeta);
		inv.setItem(11, murder);
		
		ItemStack farm = new ItemStack(Material.GRASS_BLOCK);
		ItemMeta farmMeta = farm.getItemMeta();
		farmMeta.setDisplayName( "§2Farmwelt" );
		farmMeta.setCustomModelData(1);
		farm.setItemMeta(farmMeta);
		inv.setItem(22, farm);
		
		player.openInventory(inv);
	}

}
