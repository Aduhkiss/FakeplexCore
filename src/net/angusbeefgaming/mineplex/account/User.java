package net.angusbeefgaming.mineplex.account;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.md_5.bungee.api.ChatColor;

public class User {
	private MineplexCore plugin = MineplexCore.getInstance();
	private Player player;
	// User Settings
	public boolean pms;
	public boolean pubChat;
	public boolean socialSpy;
	private boolean isAuthed = false;
	public String authCode;
	
	public boolean isVanished;
	
	
	public User(Player _player) {
		this.player = _player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public String getName() {
		return getPlayer().getName();
	}
	
	public String getDisguisedName() {
		return getPlayer().getDisplayName();
	}
	
	public void setGameMode(GameMode g) {
		getPlayer().setGameMode(g);
	}
	
	public void sendMessage(String module, String body) {
		getPlayer().sendMessage(ChatColor.BLUE + module + "> " + ChatColor.GRAY + body);
	}
	
	public void toggleSocialSpy() {
		if(socialSpy) {
			socialSpy = false;
		}
		else {
			socialSpy = true;
		}
	}
	
	public void authenticateUser() {
		if(!isAuthed) {
			isAuthed = true;
		}
	}
	
	public boolean isUserAuthed() {
		return isAuthed;
	}

}
