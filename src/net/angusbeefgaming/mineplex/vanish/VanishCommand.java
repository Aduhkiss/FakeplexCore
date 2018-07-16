package net.angusbeefgaming.mineplex.vanish;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.angusbeefgaming.mineplex.account.UserManager;
import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class VanishCommand implements CommandExecutor {
	
	private Rank rankRequired = Rank.TRAINEE;
	private Rank otherRank = Rank.YOUTUBE;
	
	public static Map<String, String> vanishedPlayers = new HashMap<String, String>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		if((!Permissions.hasRank(player, rankRequired) || (!Permissions.hasRank(player, otherRank)))) {
			Permissions.sendNoPermMessage(player, otherRank);
			return false;
		}
		
		if(UserManager.getUserFromPlayer(player).isVanished) {
			VanishManager.unvanishPlayer(player);
			return true;
		}
		else {
			VanishManager.vanishPlayer(player);
			return true;
		}
	}
	
}
