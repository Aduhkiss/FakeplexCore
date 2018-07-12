package net.angusbeefgaming.mineplex.account;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.angusbeefgaming.mineplex.server.ServerType;
import net.angusbeefgaming.mineplex.settings.PrefsManager;
import net.md_5.bungee.api.ChatColor;

public class PlayerJoinLeave implements Listener {
	@EventHandler
	public void playerJoin(PlayerJoinEvent event) {
		event.setJoinMessage(ChatColor.DARK_GRAY + "Join> " + ChatColor.GRAY + event.getPlayer().getDisplayName());
		if(!(MineplexCore.getInstance().myServerType == ServerType.KITPVP)) {
			event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), 0, 78, -32));
		}
		PrefsManager.user_pms.put(event.getPlayer(), true);
		
		UserManager.UserStore.put(event.getPlayer().getUniqueId(), new User(event.getPlayer()));
		if(event.getPlayer().getGameMode() == GameMode.CREATIVE) {
			event.getPlayer().setGameMode(GameMode.SURVIVAL);
			event.getPlayer().sendMessage(ChatColor.BLUE + "Game Mode> " + ChatColor.GRAY + event.getPlayer().getDisplayName() + "'s Game Mode: " + ChatColor.RED + "False");
		}
	}
	
	@EventHandler
	public void playerLeave(PlayerQuitEvent event) {
		event.setQuitMessage(ChatColor.DARK_GRAY + "Quit> " + ChatColor.GRAY + event.getPlayer().getDisplayName());
		UserManager.UserStore.put(event.getPlayer().getUniqueId(), null);
	}
}
