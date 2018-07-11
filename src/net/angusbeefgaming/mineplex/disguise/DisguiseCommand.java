package net.angusbeefgaming.mineplex.disguise;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class DisguiseCommand implements CommandExecutor {
	private Rank rankRequired = Rank.YOUTUBE;

	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		if(args.length < 1) {
			player.sendMessage(ChatColor.BLUE + "Usage> " + ChatColor.YELLOW + "/disguise <Playername>");
			return false;
		}
		
		try {
			DisguiseManager.nickPlayer(player, args[0]);
		}
		catch(Exception e) {
			e.printStackTrace();
			player.sendMessage(ChatColor.BLUE + "Disguise> " + ChatColor.RED + "There was an error parsing your request.");
			return false;
		}
		player.sendMessage(ChatColor.BLUE + "Disguise> " + ChatColor.GRAY + "Disguise Active: " + ChatColor.WHITE + args[0]);
		
		return true;
	}
}
