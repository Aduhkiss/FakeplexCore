package net.angusbeefgaming.mineplex.gwen;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.md_5.bungee.api.ChatColor;

public class GwenManager {
	public static void report(String name, String reason) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(Permissions.isStaff(p)) {
				int rand = (int) (Math.random() * 3);
				if(rand == 0) {
					p.sendMessage("" + ChatColor.AQUA + ChatColor.MAGIC + "A" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "GWEN > " + ChatColor.GOLD + name + ChatColor.YELLOW + " suspected of " + ChatColor.GREEN + reason);
				}
				if(rand == 1) {
					p.sendMessage("" + ChatColor.AQUA + ChatColor.MAGIC + "A" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "GWEN > " + ChatColor.GOLD + name + ChatColor.YELLOW + " suspected of " + ChatColor.GOLD + reason);
				}
				if(rand == 2) {
					p.sendMessage("" + ChatColor.AQUA + ChatColor.MAGIC + "A" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "GWEN > " + ChatColor.GOLD + name + ChatColor.YELLOW + " suspected of " + ChatColor.RED + reason);
				}
			}
		}
	}
	
	public static void kickPlayer(Player p, String reason) {
		p.kickPlayer("" + ChatColor.RED + ChatColor.BOLD + "You were kicked by Mineplex Anti-Cheat\n" + ChatColor.WHITE + "[GWEN Cheat Detection]\n" + reason);
	}
}
