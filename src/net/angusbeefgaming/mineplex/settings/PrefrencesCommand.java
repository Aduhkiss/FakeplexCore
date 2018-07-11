package net.angusbeefgaming.mineplex.settings;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class PrefrencesCommand implements CommandExecutor {
	private Rank rankRequired = Rank.ALL;

	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		Inventory inv = Bukkit.createInventory(null, 54, "Prefrences");
		
		ItemStack user = nameItem(Material.PAPER, ChatColor.YELLOW + "User Prefrences");
		ItemStack game = nameItem(Material.REDSTONE_COMPARATOR, ChatColor.YELLOW + "Game Mechanic Prefrences");
		ItemStack misc = nameItem(Material.COMPASS, ChatColor.YELLOW + "Miscellaneous Prefrences");
		ItemStack social = nameItem(Material.RED_ROSE, ChatColor.YELLOW + "Social Prefrences");
		
		ItemStack exclusive = nameItem(Material.DIAMOND, ChatColor.YELLOW + "Exclusive Prefrences");
		
		inv.setItem(18, user);
		inv.setItem(20, game);
		inv.setItem(22, exclusive);
		inv.setItem(24, misc);
		inv.setItem(26, social);
		
		player.openInventory(inv);
		return true;
	}
	
    private ItemStack nameItem(ItemStack item, String name) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	item.setItemMeta(meta);
    	return item;
    }

    private ItemStack nameItem(Material item, String name) {
    	return nameItem(new ItemStack(item), name);
    }
}
