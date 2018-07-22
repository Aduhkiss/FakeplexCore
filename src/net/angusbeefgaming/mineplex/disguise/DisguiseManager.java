package net.angusbeefgaming.mineplex.disguise;

import org.bukkit.entity.Player;
import org.inventivetalent.nicknamer.api.NickNamerAPI;

public class DisguiseManager {
	/*
	 * Disguise Manager System
	 * 
	 * Created by Atticus Zambrana
	 */
	public static void nickPlayer(Player player, String target) {
		NickNamerAPI.getNickManager().setNick(player.getUniqueId(), target);
		NickNamerAPI.getNickManager().setSkin(player.getUniqueId(), target);
		player.setDisplayName(target);
		NickNamerAPI.getNickManager().refreshPlayer(player);
		System.out.println("Fakeplex Disguise > " + player.getName() + " has just disguised as " + target + "!");
	}
	
	public static void unNickPlayer(Player player) {
		NickNamerAPI.getNickManager().removeNick(player.getUniqueId());
		NickNamerAPI.getNickManager().removeSkin(player.getUniqueId());
		NickNamerAPI.getNickManager().refreshPlayer(player);
		player.setDisplayName(player.getName());
		System.out.println("Fakeplex Disguise > " + player.getName() + " has removed their disguise!");
	}
}
