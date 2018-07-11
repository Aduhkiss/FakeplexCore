package net.angusbeefgaming.mineplex.gems;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class GemCommand implements CommandExecutor {
	
	private Rank rankRequired = Rank.ADMIN;
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		double oldAmount = 0;
		
		Economy api = new Economy();
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		if(args.length < 1) {
			player.sendMessage(ChatColor.BLUE + "Gems> " + ChatColor.GRAY + "Invalid Player!");
			return false;
		}
		if(args.length < 2) {
			player.sendMessage(ChatColor.BLUE + "Gems> " + ChatColor.GRAY + "Invalid Gem Amount!");
			return false;
		}
		
		try {
			oldAmount = api.getMoney(args[0]);
		} catch (UserDoesNotExistException e) {
			player.sendMessage(ChatColor.BLUE + "Offline Player Search> " + ChatColor.GRAY + "[" + ChatColor.YELLOW + "0" + ChatColor.GRAY + "] Matches for " + ChatColor.YELLOW + args[0]);
			e.printStackTrace();
			return false;
		}
		double toAdd = Double.parseDouble(args[1]);
		try {
			api.setMoney(args[0], oldAmount + toAdd);
		} catch (NoLoanPermittedException e) {
			player.sendMessage(ChatColor.BLUE + "Gems> " + ChatColor.GRAY + "Gem Count cannot be negitive!");
			//e.printStackTrace();
			return false;
		} catch (UserDoesNotExistException e) {
			player.sendMessage(ChatColor.BLUE + "Gems> " + ChatColor.GRAY + "Unable to find player " + args[0] + "!");
			//e.printStackTrace();
			return false;
		}
		player.sendMessage(ChatColor.BLUE + "Gems> " + ChatColor.GRAY + "You gave " + args[0] + args[1] + " gems!");
		if(Bukkit.getPlayer(args[0]) != null) {
			Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Gems> " + ChatColor.GRAY + "You have recieved " + args[1] + " gems from " + args[0]);
		}
		return true;
	}

}
