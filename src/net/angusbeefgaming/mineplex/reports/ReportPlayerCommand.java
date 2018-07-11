package net.angusbeefgaming.mineplex.reports;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class ReportPlayerCommand implements CommandExecutor {
	private Rank rankRequired = Rank.ALL;
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		if(args.length < 1) {
			player.sendMessage(ChatColor.BLUE + "Reports> " + ChatColor.GRAY + "Invalid Player to Report!");
			return false;
		}
		if(args.length < 2) {
			player.sendMessage(ChatColor.BLUE + "Reports> " + ChatColor.GRAY + "Provide a Reason for this report!");
			return false;
		}
		
        StringBuilder message = new StringBuilder();

        for(int i = 1; i < args.length; ++i) {
           message = message.append(args[i] + " ");
        }
        
        //ReportsManager.addReport(new Report(player, args[0], message.toString()));
        player.sendMessage(ChatColor.BLUE + "Reports> " + ChatColor.GRAY + "You have reported " + args[0] + " for " + message.toString() + ".");
        
        for(Player p : Bukkit.getOnlinePlayers()) {
        	if(Permissions.isStaff(p)) {
        		p.sendMessage(ChatColor.BLUE + "Reports> " + ChatColor.YELLOW + args[0] + ChatColor.GRAY + " has been reported by " + ChatColor.YELLOW + player.getName() + ChatColor.GRAY + "for " + ChatColor.YELLOW + message.toString());
        	}
        }
        return true;
        
	}
}
