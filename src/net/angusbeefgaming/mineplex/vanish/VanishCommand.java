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
import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class VanishCommand implements CommandExecutor {
	
	private Rank rankRequired = Rank.TRAINEE;
	
	public static Map<String, String> vanishedPlayers = new HashMap<String, String>();
	private MineplexCore plugin = MineplexCore.getInstance();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		if(vanishedPlayers.get(player.getName()) == null) {
			vanishedPlayers.put(player.getName(), "unvanished");
		}
		if(vanishedPlayers.get(player.getName()).equals("vanished")) {
			// Player is not currently vanished
			unvanishPlayer(player, plugin);
			vanishedPlayers.put(player.getName(), "unvanished");
			player.sendMessage("     " + ChatColor.GOLD + ChatColor.BOLD + "You are no Longer Incognito!     ");
			player.sendMessage("You can be seen by all players now!");
			for(Player pl : Bukkit.getOnlinePlayers()) {
				if(!Permissions.hasRank(pl, Rank.ADMIN)) {
					pl.sendMessage(ChatColor.DARK_GRAY + "Join> " + ChatColor.GRAY + player.getName());
				}
			}
			return true;
		}
		else {
			// Player is currently vanished
			vanishPlayer(player, plugin);
			vanishedPlayers.put(player.getName(), "vanished");
			player.playEffect(player.getLocation(), Effect.ENDERDRAGON_GROWL, null);
			player.sendMessage("     " + ChatColor.GOLD + ChatColor.BOLD + "You are now Incognito!     ");
			player.sendMessage("While in this mode, only players with" + ChatColor.RED + ChatColor.BOLD + " Admin+" + ChatColor.RESET + " Can see you!");
			for(Player pl : Bukkit.getOnlinePlayers()) {
				if(!Permissions.hasRank(pl, Rank.ADMIN)) {
					pl.sendMessage(ChatColor.DARK_GRAY + "Quit> " + ChatColor.GRAY + player.getName());
				}
			}
			return true;
		}
		
	}
	
	public static void vanishPlayer(Player p, JavaPlugin plugin) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			if(!Permissions.hasRank(pl, Rank.ADMIN)) {
				pl.hidePlayer(plugin, p);
			}
		}
		vanishedPlayers.put(p.getName(), "vanished");
	}
	
	public static void unvanishPlayer(Player p, JavaPlugin plugin) {
		if(vanishedPlayers.get(p.getName()).equals(new String("vanished"))) {
			for(Player pl : Bukkit.getOnlinePlayers()) {
				pl.showPlayer(plugin, p);
			}
			vanishedPlayers.put(p.getName(), "unvanished");
		}
	}
}
