package net.angusbeefgaming.mineplex.settings;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import net.md_5.bungee.api.ChatColor;

public class PrefrencesHandler implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		
		if(inv.getTitle().equalsIgnoreCase("Prefrences")) {
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "User Prefrences")) {
				event.setCancelled(true);
				event.getWhoClicked().closeInventory();
				Bukkit.dispatchCommand(event.getWhoClicked(), "panelopen userPrefs");
				return;
			}
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Exclusive Prefrences")) {
				event.setCancelled(true);
				event.getWhoClicked().closeInventory();
				Bukkit.dispatchCommand(event.getWhoClicked(), "panelopen exclusives");
				return;
			}
			
			event.setCancelled(true);
			return;
			
		}
		if(inv.getTitle().equalsIgnoreCase("User Prefrences")) {
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Go Back")) {
				event.setCancelled(true);
				event.getWhoClicked().closeInventory();
				Bukkit.dispatchCommand(event.getWhoClicked(), "prefs");
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Private Messaging (ON)")) {
				event.setCancelled(true);
				PrefsManager.user_pms.put((Player) event.getWhoClicked(), false);
				event.getWhoClicked().sendMessage(ChatColor.BLUE + "Prefs> " + ChatColor.GRAY + "Private Messaging has been toggled Off.");
				event.getWhoClicked().closeInventory();
				Bukkit.dispatchCommand(event.getWhoClicked(), "panelopen userPrefs");
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Private Messaging (OFF)")) {
				event.setCancelled(true);
				PrefsManager.user_pms.put((Player) event.getWhoClicked(), true);
				event.getWhoClicked().sendMessage(ChatColor.BLUE + "Prefs> " + ChatColor.GRAY + "Private Messaging has been toggled On.");
				event.getWhoClicked().closeInventory();
				Bukkit.dispatchCommand(event.getWhoClicked(), "panelopen userPrefs");
				return;
			}
			event.setCancelled(true);
			return;
			
		}
	}
}
