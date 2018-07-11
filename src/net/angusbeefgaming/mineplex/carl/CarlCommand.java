package net.angusbeefgaming.mineplex.carl;

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

public class CarlCommand implements CommandExecutor {
	ItemStack Item1;
	
	private Rank rankRequired = Rank.ALL;

	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		Inventory inv = Bukkit.createInventory(null, 54, "Carl's Rewards");
		
		ItemStack Item1Y = nameItem(Material.EMERALD_BLOCK, "Get 500 Gems");
		ItemStack Item1N = nameItem(Material.REDSTONE_BLOCK, "Get 500 Gems");
		
		ItemStack Item2Y = nameItem(Material.EMERALD_BLOCK, "Claim Free Ultra Rank!");
		ItemStack Item2N = nameItem(Material.REDSTONE_BLOCK, "You already have Ultra Rank!");
		
		if(player.hasPermission("carl.freegems")) {
			inv.setItem(10, Item1N);
		}
		else {
			inv.setItem(10, Item1Y);
		}
		
		if(Permissions.hasRank(player, Rank.ULTRA)) {
			inv.setItem(12, Item2N);
		}
		else {
			inv.setItem(12, Item2Y);
		}
		
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
