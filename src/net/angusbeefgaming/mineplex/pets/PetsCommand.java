package net.angusbeefgaming.mineplex.pets;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;

public class PetsCommand implements CommandExecutor, Listener {
	
	Rank requiredRank = Rank.DEV;
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!Permissions.hasRank(player, requiredRank)) {
			Permissions.sendNoPermMessage(player, requiredRank);
			return false;
		}
		
		Inventory inv = Bukkit.createInventory(null, 27, "Select Pet");
		
		ItemStack cowPet = nameItem(Material.APPLE, "Cow Pet");
		
		inv.setItem(0, cowPet);
		
		player.openInventory(inv);
		return true;
	}
	
	@EventHandler
	public void invClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		if(!inv.getTitle().equals("Select Pet")) return;
		if(e.getCurrentItem() == null) return;
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals("Cow Pet")) {
			e.setCancelled(true);
		}
		e.setCancelled(true);
		return;
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
