package net.angusbeefgaming.mineplex.announcement;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class AnnounceCommand implements CommandExecutor {
	private Rank rankRequired = Rank.ADMIN;

	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		if(args.length < 1) {
			player.sendMessage(ChatColor.BLUE + "Usage> " + ChatColor.YELLOW + "/announce <Message>");
			return false;
		}
		
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < args.length; ++i) {
           message = message.append(args[i] + " ");
        }
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendTitle(ChatColor.YELLOW + "Announcement", message.toString(), 10, 70, 20);
			p.sendMessage(ChatColor.BLUE + "Announcement> " + ChatColor.AQUA + message.toString());
		}
		return true;
	}
}
