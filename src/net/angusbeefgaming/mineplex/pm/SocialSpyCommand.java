package net.angusbeefgaming.mineplex.pm;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.account.User;
import net.angusbeefgaming.mineplex.account.UserManager;
import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;

public class SocialSpyCommand implements CommandExecutor {
	private Rank rankRequired = Rank.TRAINEE;
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		
		User u = UserManager.getUserFromPlayer(player);
		
		if(u.socialSpy) {
			u.socialSpy = false;
			u.sendMessage("Social Spy", "Social Spy Disabled.");
		}
		else {
			u.socialSpy = true;
			u.sendMessage("Social Spy", "Social Spy Enabled.");
		}
		
		return true;
		
	}
}
