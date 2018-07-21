package net.angusbeefgaming.mineplex.forcefield;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class ForcefieldCommand implements CommandExecutor {
	private Rank rankRequired = Rank.ADMIN;

	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		if(ForcefieldManager.hasForcefield(player)) {
			// If they already have it, remove it
			ForcefieldManager.disableForcefield(player);
			// Send a message and return true
			player.sendMessage(ChatColor.BLUE + "Prefrences> " + ChatColor.GRAY + "Hub Forcefield: " + ChatColor.RED + "Off");
			return true;
		}
		else {
			ForcefieldManager.enableForcefield(player);
			// Send a message and return true
			player.sendMessage(ChatColor.BLUE + "Prefrences> " + ChatColor.GRAY + "Hub Forcefield: " + ChatColor.GREEN + "On");
			return true;
		}
		
	}
}
