package net.angusbeefgaming.mineplex.chat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.angusbeefgaming.mineplex.settings.PrefsManager;
import net.md_5.bungee.api.ChatColor;

public class onChatEvent implements Listener {
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		if(Permissions.hasRank(event.getPlayer(), Rank.TRAINEE)) {
			return;
		}
		if(ChatManager.chatEnabled) {
			return;
		}
		else {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "Shh! Chat is currently silenced right now!");
			return;
		}
	}
	
	@EventHandler
	public void onChat2(AsyncPlayerChatEvent e) {
		if(!PrefsManager.userChat(e.getPlayer())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.BLUE + "Chat> " + ChatColor.GRAY + "You have public chat disabled!");
		}
	}

}
