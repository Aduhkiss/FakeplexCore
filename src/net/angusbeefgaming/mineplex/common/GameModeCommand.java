package net.angusbeefgaming.mineplex.common;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class GameModeCommand implements CommandExecutor {
	private Rank rankRequired = Rank.BUILDER;

	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		if(args.length >= 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target == null) {
				player.sendMessage(ChatColor.BLUE + "Online Player Search> " + ChatColor.YELLOW + "0" + ChatColor.GRAY + " matches for " + "[" + ChatColor.YELLOW + args[0] + ChatColor.GRAY + "].");
				return false;
			}
			if(target.getGameMode() == GameMode.CREATIVE) {
				target.setGameMode(GameMode.SURVIVAL);
				target.sendMessage(ChatColor.BLUE + "Game Mode> " + ChatColor.GRAY + target.getName() + " Creative Mode: " + ChatColor.RED + "False");
				player.sendMessage(ChatColor.BLUE + "Game Mode> " + ChatColor.GRAY + target.getName() + " Creative Mode: " + ChatColor.RED + "False");
				return true;
			}
			else {
				target.setGameMode(GameMode.CREATIVE);
				target.sendMessage(ChatColor.BLUE + "Game Mode> " + ChatColor.GRAY + target.getName() + " Creative Mode: " + ChatColor.GREEN + "True");
				player.sendMessage(ChatColor.BLUE + "Game Mode> " + ChatColor.GRAY + target.getName() + " Creative Mode: " + ChatColor.GREEN + "True");
				return true;
			}
		}
		else {
			if(player.getGameMode() == GameMode.CREATIVE) {
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(ChatColor.BLUE + "Game Mode> " + ChatColor.GRAY + player.getDisplayName() + " Creative Mode: " + ChatColor.RED + "False");
				return true;
			}
			else {
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(ChatColor.BLUE + "Game Mode> " + ChatColor.GRAY + player.getDisplayName() + " Creative Mode: " + ChatColor.GREEN + "True");
				return true;
			}
		}
	}
}
