package net.angusbeefgaming.mineplex.account;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class RankEvent implements Listener {
	MineplexCore plugin = MineplexCore.getInstance();

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		String targetName = plugin.rankStore.get(player.getName());
		
		
		if(inv.getTitle().equalsIgnoreCase("Update Player Rank")) {
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Remove Current Rank")) {
				Permissions.updateRank(targetName, Rank.ALL);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to No Rank!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to No Rank!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Ultra Rank")) {
				Permissions.updateRank(targetName, Rank.ULTRA);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Ultra!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Ultra!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Hero Rank")) {
				Permissions.updateRank(targetName, Rank.HERO);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Hero!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Hero!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Legend Rank")) {
				Permissions.updateRank(targetName, Rank.LEGEND);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Legend!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Legend!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Titan Rank")) {
				Permissions.updateRank(targetName, Rank.TITAN);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Titan!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Titan!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Eternal Rank")) {
				Permissions.updateRank(targetName, Rank.ETERNAL);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Eternal!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Eternal!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Trainee Rank")) {
				Permissions.updateRank(targetName, Rank.TRAINEE);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Trainee!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Trainee!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Moderator Rank")) {
				Permissions.updateRank(targetName, Rank.MOD);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Mod!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Mod!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Sr Mod Rank")) {
				Permissions.updateRank(targetName, Rank.SRMOD);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Sr Mod!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Sr Mod!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Admin Rank")) {
				Permissions.updateRank(targetName, Rank.ADMIN);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Admin!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Admin!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Owner Rank")) {
				Permissions.updateRank(targetName, Rank.OWNER);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Owner!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Owner!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Developer Rank")) {
				Permissions.updateRank(targetName, Rank.DEV);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Developer!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Developer!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Builder Rank")) {
				Permissions.updateRank(targetName, Rank.BUILDER);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Builder!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Builder!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Support Rank")) {
				Permissions.updateRank(targetName, Rank.SUPPORT);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Support!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Support!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Map Lead Rank")) {
				Permissions.updateRank(targetName, Rank.MAPLEAD);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Map Lead!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Map Lead!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Media Rank")) {
				Permissions.updateRank(targetName, Rank.MEDIA);
				player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + targetName + "'s rank has been Updated to Media!");
				if(Bukkit.getPlayer(targetName) != null) {
					Bukkit.getPlayer(targetName).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Media!");
				}
				event.setCancelled(true);
				player.closeInventory();
			}
			else {
				return;
			}
			
			
		}
		else {
			return;
		}
	}
}
