package net.angusbeefgaming.mineplex.settings;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class PrefsManager {
	
	public static Map<Player, Boolean> user_pms = new HashMap<Player, Boolean>();
	public static Map<Player, Boolean> user_chat = new HashMap<Player, Boolean>();
	
	public static Map<Player, Boolean> exclu_staff = new HashMap<Player, Boolean>();
	
	public static boolean exclusiveStaffChat(Player p) {
		if(exclu_staff.get(p) == null) {
			exclu_staff.put(p, true);
		}
		if(exclu_staff.get(p) == true) {
			return true;
		}
		return false;
	}
	
	public static boolean userPms(Player p) {
		if(user_pms.get(p) == null) {
			user_pms.put(p, true);
			return true;
		}
		if(user_pms.get(p) == true) {
			return true;
		}
		return false;
	}
	
	public static boolean userChat(Player p) {
		if(user_chat.get(p) == null) {
			user_chat.put(p, true);
			return true;
		}
		if(user_chat.get(p) == true) {
			return true;
		}
		return false;
	}
}
