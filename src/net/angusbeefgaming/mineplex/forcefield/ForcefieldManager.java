package net.angusbeefgaming.mineplex.forcefield;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class ForcefieldManager {
	/**
	 * Forcefield Manager Class
	 * 
	 * Created by Atticus Zambrana
	 * 
	 * Handles everything with who has a forcefield.
	 */
	
	public static List<String> forcefieldPlayers = new ArrayList<String>();
	
	public static void enableForcefield(Player p) {
		if(!hasForcefield(p)) {
			forcefieldPlayers.add(p.getName());
		}
	}
	
	public static void disableForcefield(Player p) {
		if(hasForcefield(p)) {
			forcefieldPlayers.remove(p.getName());
		}
	}
	
	public static boolean hasForcefield(Player p) {
		boolean hasIt = false;
		for(String str : forcefieldPlayers) {
			if(str.equals(p.getName())) {
				hasIt = true;
			}
		}
		return hasIt;
	}
}
