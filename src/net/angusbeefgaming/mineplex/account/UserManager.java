package net.angusbeefgaming.mineplex.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

public class UserManager {
	public static List<User> userStore = new ArrayList<User>();
	
	public static void setupNewUser(User u) {
		
	}
	
	public static User getUserFromPlayer(Player p) {
		for(User u : userStore) {
			if(u.getPlayer() == p) {
				return u;
			}
		}
		return null;
	}
}
