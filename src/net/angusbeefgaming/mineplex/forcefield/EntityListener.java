package net.angusbeefgaming.mineplex.forcefield;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import net.angusbeefgaming.mineplex.Util.Maths;

public class EntityListener implements Listener {
	/*
	 * Event Handlers for the Forcefield. Apply KB when you are close
	 * 
	 * Created by Atticus Zambrana
	 */
	
	@EventHandler
	public void move(PlayerMoveEvent e) {
		// First, make sure player has a forcefield
		if(!ForcefieldManager.hasForcefield(e.getPlayer())) return;
		
		// Then grab how far all players are from this player
		for(Player pla : Bukkit.getOnlinePlayers()) {
			// Check if the Player is 5 blocks or closer
			if(getDistance(e.getPlayer(), pla) <= 5) {
				// Attempt to Knock0 them back
				float knockback = 2f;
				pla.setVelocity(e.getPlayer().getVelocity().add(e.getPlayer().getLocation().toVector().subtract(pla.getLocation().toVector()).normalize().multiply(knockback)));
			}
		}
	}
	
	private int getDistance(Player pl1, Player pl2) {
		int pl1X = (int) pl1.getLocation().getX();
		int pl1Z = (int) pl1.getLocation().getZ();
		
		int pl2X = (int) pl2.getLocation().getX();
		int pl2Z = (int) pl2.getLocation().getZ();
		
		int hold1 = pl1Z - pl2Z;
		int hold2 = pl1X - pl2X;
		
		int hold3 = (int) Maths.squareNum(hold1);
		int hold4 = (int) Maths.squareNum(hold2);
		
		int number = hold3 + hold4;
		
		return (int) Math.sqrt(number);
	}
}
