package net.angusbeefgaming.mineplex.chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ChatManager {
	public static boolean chatEnabled = true;
	
	public static void silenceChat(Player player) {
		chatEnabled = false;
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(player == Bukkit.getConsoleSender()) {
				p.sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "Chat has been silenced");
			}
			p.sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "Chat has been silenced by " + ChatColor.GREEN + player.getDisplayName());
		}
	}
	
	public static void activateChat() {
		chatEnabled = true;
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "Chat is no longer silenced.");
		}
	}
}
