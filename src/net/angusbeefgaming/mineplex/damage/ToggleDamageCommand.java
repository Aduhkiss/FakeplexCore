package net.angusbeefgaming.mineplex.damage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class ToggleDamageCommand implements CommandExecutor {

	private Rank rankRequired = Rank.ADMIN;
	public static boolean playerDamageEnabled = false;
	public static boolean mobDamageEnabled = false;

	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		if(args.length < 1) {
			player.sendMessage(ChatColor.BLUE + "Settings> " + ChatColor.GRAY + "You must Define a type of damage to toggle!");
			return false;
		}
		
		if(args[0].equalsIgnoreCase("pvp")) {
			if(playerDamageEnabled) {
				playerDamageEnabled = false;
				player.sendMessage(ChatColor.BLUE + "Settings> " + ChatColor.GRAY + "PvP Damage: " + ChatColor.RED + "False");
				
			}
			else {
				playerDamageEnabled = true;
				player.sendMessage(ChatColor.BLUE + "Settings> " + ChatColor.GRAY + "PvP Damage: " + ChatColor.GREEN + "True");
			}
			return true;
		}
		if(args[0].equalsIgnoreCase("pve")) {
			if(mobDamageEnabled) {
				mobDamageEnabled = false;
				player.sendMessage(ChatColor.BLUE + "Settings> " + ChatColor.GRAY + "PvE Damage: " + ChatColor.RED + "False");
				
			}
			else {
				mobDamageEnabled = true;
				player.sendMessage(ChatColor.BLUE + "Settings> " + ChatColor.GRAY + "PvE Damage: " + ChatColor.GREEN + "True");
			}
			return true;
		}
		else {
			player.sendMessage(ChatColor.BLUE + "Settings> " + ChatColor.GRAY + "Damage Types (PVP/PVE)");
			return false;
		}
	}
}
