package net.angusbeefgaming.mineplex.common;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.angusbeefgaming.mineplex.settings.PrefsManager;
import net.md_5.bungee.api.ChatColor;

public class OpenPanelCommand implements CommandExecutor {
	MineplexCore plugin = MineplexCore.getInstance();
	ItemStack pmItem;
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(args.length < 1) {
			return false;
		}
		if(args[0].equalsIgnoreCase("userPrefs")) {
			Inventory userPrefs = Bukkit.createInventory(null, 54, "User Prefrences");
			boolean userPms = PrefsManager.userPms(player);
			boolean chatToggle = PrefsManager.userChat(player);
			
			ItemStack back = nameItem(Material.BED, ChatColor.GREEN + "Go Back");

			ItemStack pmItemY = nameItem(Material.MAP, "Private Messaging (ON)");
			ItemStack pmItemN = nameItem(Material.MAP, "Private Messaging (OFF)");
			
			ItemStack chatItemY = nameItem(Material.MAP, "Player Chat (ON)");
			ItemStack chatItemN = nameItem(Material.MAP, "Player Chat (OFF)");
			
			userPrefs.setItem(4, back);
			//userPrefs.setItem(12, chatItem);
			// PM's Item
			if(userPms == true) {
				userPrefs.setItem(10, pmItemY);
			}
			else {
				userPrefs.setItem(10, pmItemN);
			}
			
			// Player Chat Item
			if(chatToggle == true) {
				userPrefs.setItem(12, chatItemY);
			}
			else {
				userPrefs.setItem(12, chatItemN);
			}
			
			player.openInventory(userPrefs);
			return true;
		}
		if(args[0].equalsIgnoreCase("exclusives")) {
			Inventory userPrefs = Bukkit.createInventory(null, 54, "Exclusive Prefrences");
			
			ItemStack back = nameItem(Material.BED, ChatColor.GREEN + "Go Back");

			//
			
			player.openInventory(userPrefs);
			return true;
		}
		return false;
	}
    private static ItemStack nameItem(ItemStack item, String name) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	item.setItemMeta(meta);
    	return item;
    }

    private static ItemStack nameItem(Material item, String name) {
    	return nameItem(new ItemStack(item), name);
    }
}
