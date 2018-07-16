package net.angusbeefgaming.mineplex.vanish;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.angusbeefgaming.mineplex.account.User;
import net.angusbeefgaming.mineplex.account.UserManager;
import net.md_5.bungee.api.ChatColor;

public class PlayerEvents implements Listener {
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		if(UserManager.getUserFromPlayer(e.getPlayer()).isVanished) {
			e.getPlayer().sendMessage(ChatColor.GREEN + "You are still invisible!");
		}
		for(User u : UserManager.userStore) {
			if(u.isVanished) {
				e.getPlayer().hidePlayer(MineplexCore.getInstance(), u.getPlayer());
			}
		}
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent e) {
		for(User u : UserManager.userStore) {
			e.getPlayer().showPlayer(MineplexCore.getInstance(), u.getPlayer());
		}
	}

}
