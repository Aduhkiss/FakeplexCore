package net.angusbeefgaming.mineplex.pm;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.account.UserManager;
import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.angusbeefgaming.mineplex.settings.PrefsManager;
import net.md_5.bungee.api.ChatColor;

public class MessageCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(args.length < 1) {
			player.sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "Please enter a player to message.");
			return false;
		}
		if(args.length < 2) {
			player.sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "Please enter a message to send.");
			return false;
		}
		
		Player target = Bukkit.getPlayer(args[0]);
		
		if(target == null) {
			player.sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "That player is not online!");
			return false;
		}
		
        StringBuilder message = new StringBuilder();

        for(int i = 1; i < args.length; ++i) {
           message = message.append(args[i] + " ");
        }
        
        
        if(!PrefsManager.userPms(player)) {
        	player.sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "You have Private Messaging Disabled!");
        	return false;
        }
        if(!PrefsManager.userPms(target)) {
        	player.sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "That Player has Private Messaging Disabled!");
        	return false;
        }
        
        player.sendMessage("" + ChatColor.GOLD + ChatColor.BOLD + player.getDisplayName() + ChatColor.GOLD + ChatColor.BOLD + " > " + ChatColor.GOLD + ChatColor.BOLD + target.getDisplayName() + ChatColor.YELLOW + ChatColor.BOLD + " " + message.toString());
        target.sendMessage("" + ChatColor.GOLD + ChatColor.BOLD + player.getDisplayName() + ChatColor.GOLD + ChatColor.BOLD + " > " + ChatColor.GOLD + ChatColor.BOLD + target.getDisplayName() + ChatColor.YELLOW + ChatColor.BOLD + " " + message.toString());
        
        // Send the Message to any staff that have social spy enabled
        for(Player p : Bukkit.getOnlinePlayers()) {
        	if(Permissions.hasRank(p, Rank.TRAINEE)) {
        		if(UserManager.getUserFromPlayer(p).socialSpy) {
        			p.sendMessage(ChatColor.YELLOW + "[SocialSpy] " + ChatColor.GOLD + ChatColor.BOLD + player.getDisplayName() + ChatColor.GOLD + ChatColor.BOLD + " > " + ChatColor.GOLD + ChatColor.BOLD + target.getDisplayName() + ChatColor.YELLOW + ChatColor.BOLD + " " + message.toString());
        		}
        	}
        }
        return true;
		
	}

}
