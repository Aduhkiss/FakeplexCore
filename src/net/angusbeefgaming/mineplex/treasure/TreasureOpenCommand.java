package net.angusbeefgaming.mineplex.treasure;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;

public class TreasureOpenCommand implements CommandExecutor {
	
	MineplexCore plugin = MineplexCore.getInstance();
	Rank rankRequired = Rank.DEV;
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!Permissions.hasRank(player, rankRequired)) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		Inventory inv = Bukkit.createInventory(null, 54, "Open Treasure");
		
		// Test
		
		return true;
	}
}
