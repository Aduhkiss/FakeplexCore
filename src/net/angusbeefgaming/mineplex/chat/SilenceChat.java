package net.angusbeefgaming.mineplex.chat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class SilenceChat implements CommandExecutor {
	
	Rank rankRequired = Rank.SRMOD;
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		if(ChatManager.chatEnabled) {
			ChatManager.silenceChat();
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "Chat has been silenced by " + player.getDisplayName());
			}
		}
		else {
			ChatManager.activateChat();
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "Chat is no longer silenced.");
			}
		}
		return true;
	}

}
