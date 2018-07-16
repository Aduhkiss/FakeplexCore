package net.angusbeefgaming.mineplex.gwen;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.common.C;
import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class ManualGwenAlertCommand implements CommandExecutor {
	Rank rankRequired = Rank.DEV;
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!Permissions.hasRank(player, rankRequired)) Permissions.sendNoPermMessage(player, rankRequired);
		
		if(args.length < 1) {
			if(args.length < 2) {
				String vio = C.combineArray(args, 1);
				GwenManager.report(args[0], vio);
				return true;
			}
			else {
				player.sendMessage(ChatColor.BLUE + "GWEN> " + ChatColor.RED + ChatColor.BOLD +  "Invalid Violation!");
				return false;
			}
		}
		else {
			player.sendMessage(ChatColor.BLUE + "GWEN> " + ChatColor.RED + ChatColor.BOLD +  "Invalid Player!");
			return false;
		}
	}
}
