package net.angusbeefgaming.mineplex.account;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

public class UserManager {
	public static Map<UUID, User> UserStore = new HashMap<UUID, User>();
	
	public static void setupNewUser(User u) {
		
	}
	
	public static User getUserFromPlayer(Player p) {
		for(Map.Entry<UUID, User> entry : UserStore.entrySet()) {
			if(entry.getValue().getPlayer() == p) {
				return entry.getValue();
			}
		}
		return null;
	}
}
