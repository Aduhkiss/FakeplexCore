package net.angusbeefgaming.mineplex.antigrief;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class AntiGrief implements Listener {

	@EventHandler
	public void breakBlock(BlockBreakEvent event) {
		if(event.getPlayer().getGameMode() == GameMode.CREATIVE) {
			return;
		}
		else {
			event.setCancelled(true);
			return;
		}
	}
	
	@EventHandler
	public void placeBlock(BlockPlaceEvent event) {
		if(event.getPlayer().getGameMode() == GameMode.CREATIVE) {
			return;
		}
		else {
			event.setCancelled(true);
			return;
		}
	}
}
