package net.angusbeefgaming.mineplex.common;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.World;

import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Permissions {
	
	/**
	 * Send the Given Player the No Permissions Message for the Given Rank
	 * @param player
	 * @param rank
	 */
	public static void sendNoPermMessage(Player player, Rank rank) {
		player.sendMessage(ChatColor.BLUE + "Permissions> " + ChatColor.GRAY + "This requires Permission Rank [" + ChatColor.BLUE + rank.toString() + ChatColor.GRAY + "].");
	}
	
	/**
	 * Update the Given player's rank with the Given Rank
	 * @param target
	 * @param rank
	 */
	public static void updateRank(String target, Rank rank) {
		if(rank == Rank.ALL) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + target + " group set \"No Rank\"");
		}
		else {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + target + " group set " + rank.toString());
		}
	}
	
	/**
	 * Check if the given player is a Staff Member
	 * @param player
	 * @return boolean
	 */
	public static boolean isStaff(Player p) {
		if(hasRank(p, Rank.TRAINEE)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Check if the given player has the given rank
	 * @param player
	 * @param rank
	 * @return boolean
	 */
	public static boolean hasRank(Player player, Rank rank) {
		if(rank == Rank.ALL) {
			if(player.hasPermission("rank.all")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.ULTRA) {
			if(player.hasPermission("rank.ultra")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.HERO) {
			if(player.hasPermission("rank.hero")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.LEGEND) {
			if(player.hasPermission("rank.legend")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.TITAN) {
			if(player.hasPermission("rank.titan")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.ETERNAL) {
			if(player.hasPermission("rank.eternal")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.YOUTUBE) {
			if(player.hasPermission("rank.youtube")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.TWITCH) {
			if(player.hasPermission("rank.twitch")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.SUPPORT) {
			if(player.hasPermission("rank.support")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.TRAINEE) {
			if(player.hasPermission("rank.trainee")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.MOD) {
			if(player.hasPermission("rank.mod")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.SRMOD) {
			if(player.hasPermission("rank.srmod")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.BUILDER) {
			if(player.hasPermission("rank.builder")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.MAPLEAD) {
			if(player.hasPermission("rank.maplead")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.MEDIA) {
			if(player.hasPermission("rank.media")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.ADMIN) {
			if(player.hasPermission("rank.admin")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.DEV) {
			if(player.hasPermission("rank.dev")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.LEADER) {
			if(player.hasPermission("rank.leader")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.OWNER) {
			if(player.hasPermission("rank.owner")) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
