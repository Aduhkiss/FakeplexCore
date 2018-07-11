package net.angusbeefgaming.mineplex.common;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.md_5.bungee.api.ChatColor;

public class NetworkKickCommand implements CommandExecutor {
	
	private Rank rankRequired = Rank.TRAINEE;
	
	private MineplexCore plugin = MineplexCore.getInstance();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		else {
			if(!(args.length >= 1)) {
				player.sendMessage(ChatColor.BLUE + "Punish> " + ChatColor.GRAY + "Invalid Player!");
				return false;
			}
			player.sendMessage(ChatColor.BLUE + "Punish> " + ChatColor.GRAY + "Trying to kick " + args[0]);
			ByteArrayDataOutput out = ByteStreams.newDataOutput();
			out.writeUTF("KickPlayer");
			out.writeUTF(args[0]);
			out.writeUTF("Your connection to the server has been lost. Please try again.");
			player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
			return true;
		}
	}

}
