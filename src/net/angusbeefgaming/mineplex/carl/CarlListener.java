package net.angusbeefgaming.mineplex.carl;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class CarlListener implements Listener {
	
	Economy api = new Economy();
	MineplexCore plugin = MineplexCore.getInstance();

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		if(inv.getTitle().equalsIgnoreCase("Carl's Rewards")) {
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Get 500 Gems")) {
				if(event.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
					event.setCancelled(true);
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + event.getWhoClicked().getName() + " add carl.freegems");
					double oldMoney = 0;
					try {
						oldMoney = api.getMoney(event.getWhoClicked().getName());
					} catch (UserDoesNotExistException e1) {
						event.getWhoClicked().sendMessage(ChatColor.BLUE + "Carl> " + ChatColor.GRAY + "There was an error parsing your request! Pleasde Contact an Admin!");
						plugin.getLogger().info("ALERT! An Error Has Occured for Player " + event.getWhoClicked().getName() + " - Tried to get old Gem Count.");
						e1.printStackTrace();
					}
					try {
						api.setMoney(event.getWhoClicked().getName(), oldMoney + 500);
					} catch (NoLoanPermittedException e) {
						event.getWhoClicked().sendMessage(ChatColor.BLUE + "Carl> " + ChatColor.GRAY + "There was an error parsing your request! Pleasde Contact an Admin!");
						plugin.getLogger().info("ALERT! An Error Has Occured for Player " + event.getWhoClicked().getName() + " - Tried to give 500 Free Gems from Carl's Rewards.");
						e.printStackTrace();
						return;
					} catch (UserDoesNotExistException e) {
						event.getWhoClicked().sendMessage(ChatColor.BLUE + "Carl> " + ChatColor.GRAY + "There was an error parsing your request! Pleasde Contact an Admin!");
						plugin.getLogger().info("ALERT! An Error Has Occured for Player " + event.getWhoClicked().getName() + " - Tried to give 500 Free Gems from Carl's Rewards.");
						e.printStackTrace();
						return;
					}
					event.getWhoClicked().sendMessage(ChatColor.BLUE + "Carl> " + ChatColor.GRAY + "You have claimed your 500 Free Gems!");
					event.getWhoClicked().closeInventory();
					return;
				}
				if(event.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
					event.setCancelled(true);
					event.getWhoClicked().sendMessage(ChatColor.BLUE + "Carl> " + ChatColor.GRAY + "You have already claimed this reward!");
					return;
				}
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Claim Free Ultra Rank!")) {
				if(event.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
					event.getWhoClicked().sendMessage(ChatColor.BLUE + "Carl> " + ChatColor.GRAY + "You have claimed your Free Ultra Rank!");
					event.setCancelled(true);
					event.getWhoClicked().closeInventory();
					Permissions.updateRank(event.getWhoClicked().getName(), Rank.ULTRA);
					return;
					
				}
			}
			event.setCancelled(true);
			return;
		}
	}
}
