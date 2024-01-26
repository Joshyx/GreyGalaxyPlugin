package joshix.bluegalaxy.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import joshix.bluegalaxy.main.Main;

public class Recipes {
	
	public static void addRecipes() {
		ItemStack item = new ItemStack(Material.ITEM_FRAME);

        ItemMeta meta = item.getItemMeta();
        NamespacedKey key = new NamespacedKey(Main.getPlugin(Main.class), "invisible");

        meta.setDisplayName("§6Unsichtbarer Itemframe");

        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("EEE", "ESE", "EEE");

        recipe.setIngredient('E', Material.GLASS_PANE);
        recipe.setIngredient('S', Material.ITEM_FRAME);

        Bukkit.addRecipe(recipe);
	}

}
