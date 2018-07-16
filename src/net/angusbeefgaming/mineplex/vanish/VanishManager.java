package net.angusbeefgaming.mineplex.vanish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.angusbeefgaming.mineplex.account.UserManager;
import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class VanishManager {
	public static void vanishPlayer(Player player) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			if(!Permissions.hasRank(pl, Rank.ADMIN)) {
				pl.hidePlayer(MineplexCore.getInstance(), player);
			}
		}
		player.sendMessage("");
		player.sendMessage(ChatColor.GOLD + "You are now vanished!");
		player.sendMessage("Only " + ChatColor.RED + "Admin+" + ChatColor.WHITE + "Can see you!");
		player.sendMessage("");
		player.sendMessage("");
		UserManager.getUserFromPlayer(player).isVanished = true;
	}
	
	public static void unvanishPlayer(Player player) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			pl.showPlayer(MineplexCore.getInstance(), player);
		}
		player.sendMessage("");
		player.sendMessage(ChatColor.GOLD + "You are no longer vanished!");
		player.sendMessage("You can be seen by everyone Now!");
		player.sendMessage("");
		player.sendMessage("");
		UserManager.getUserFromPlayer(player).isVanished = false;
	}
}
