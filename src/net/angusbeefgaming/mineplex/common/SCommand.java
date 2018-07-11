package net.angusbeefgaming.mineplex.common;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class SCommand implements CommandExecutor {
	private Rank rankRequired = Rank.MOD;

	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		if(args.length < 1) {
			player.sendMessage(ChatColor.BLUE + "Usage> " + ChatColor.YELLOW + "/s <Message>");
			return false;
		}
		
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < args.length; ++i) {
           message = message.append(args[i] + " ");
        }
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.AQUA + " " + message.toString());
		}
		return true;
	}
}
