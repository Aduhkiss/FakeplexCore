package net.angusbeefgaming.mineplex.damage;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.angusbeefgaming.mineplex.server.ServerType;

public class DamageListener implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		
		if(MineplexCore.getInstance().myServerType == ServerType.KITPVP) {
			return;
		}
		
		if(event.getCause() == DamageCause.VOID) {
			event.getEntity().teleport(new Location(event.getEntity().getWorld(), 0, 78, -32));
			event.setCancelled(true);
			return;
		}
		
		
		if(!(event.getEntity() instanceof Player)) {
			if(ToggleDamageCommand.mobDamageEnabled) {
				return;
			}
			else {
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getCause() == DamageCause.VOID) {
			event.getEntity().teleport(new Location(event.getEntity().getWorld(), 0, 78, -32));
			event.setCancelled(true);
			return;
		}
		
		if(ToggleDamageCommand.playerDamageEnabled) {
			return;
		}
		else {
			event.setCancelled(true);
			return;
		}
	}
}
