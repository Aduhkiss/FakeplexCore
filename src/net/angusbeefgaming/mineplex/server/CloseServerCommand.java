package net.angusbeefgaming.mineplex.server;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;

public class CloseServerCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!Permissions.hasRank((Player) sender, Rank.ADMIN)) {
			return false;
		}
		MineplexCore.getInstance().sendAllHub();
		Bukkit.shutdown();
		return true;
	}
}
