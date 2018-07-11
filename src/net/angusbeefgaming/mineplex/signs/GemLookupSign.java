package net.angusbeefgaming.mineplex.signs;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.UserDoesNotExistException;

import net.md_5.bungee.api.ChatColor;

public class GemLookupSign implements Listener {
	public void onPlayerInteract(PlayerInteractEvent ev) throws UserDoesNotExistException {
		Block block = ev.getClickedBlock();
		Economy api = new Economy();
		if(ev.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(block.getType() == Material.SIGN || block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN) {
				Sign sign = (Sign) ev.getClickedBlock().getState();
				if(sign.getLine(0).contains("[Gem Count]")) {
					ev.getPlayer().sendMessage(ChatColor.GREEN + "You have " + api.getMoney(ev.getPlayer().getName()) + " gems!");
				}
			}
		}
	}
}
