package net.angusbeefgaming.mineplex.reports;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class ReportsManager {
	
	public static Report[] reports;
	
	public static void addReport(Report r) {
		reports[findNextSpot()] = r;
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(Permissions.hasRank(p, Rank.TRAINEE)) {
				p.sendMessage(ChatColor.BLUE + "Reports> " + ChatColor.GRAY + r.getTarget() + " has been reported by " + r.getReporter().getName() + " for " + r.getReason());
			}
		}
		return;
	}
	
	public static int findNextSpot() {
		for(int i = 0; i < reports.length; i++) {
			if(reports[i] == null) {
				return i;
			}
		}
		return -1;
	}
	

}
