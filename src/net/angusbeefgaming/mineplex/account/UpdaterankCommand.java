package net.angusbeefgaming.mineplex.account;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.angusbeefgaming.mineplex.MineplexCore;
import net.angusbeefgaming.mineplex.common.Permissions;
import net.angusbeefgaming.mineplex.common.Rank;
import net.md_5.bungee.api.ChatColor;

public class UpdaterankCommand implements CommandExecutor {
	private MineplexCore plugin = MineplexCore.getInstance();
	
	private Rank rankRequired = Rank.SUPPORT;
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("You cannot update a player rank from Console! Please do this as an Admin+ Account in Game!");
			return false;
		}
		Player player = (Player) sender;
		if(!(Permissions.hasRank(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		if(args.length < 1) {
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.RED + ChatColor.BOLD + "Invalid Player");
			return false;
		}
		if(!(args.length >= 2)) {
			
			// New GUI Feature
			Inventory inv = Bukkit.createInventory(null, 54, "Update Player Rank");
			
			ItemStack Item1 = nameItem(Material.DIAMOND_BLOCK, ChatColor.AQUA + "Ultra Rank");
			ItemStack Item2 = nameItem(Material.PURPUR_BLOCK, ChatColor.LIGHT_PURPLE + "Hero Rank");
			ItemStack Item3 = nameItem(Material.EMERALD_BLOCK, ChatColor.GREEN + "Legend Rank");
			ItemStack Item4 = nameItem(Material.NETHER_WART_BLOCK, ChatColor.RED + "Titan Rank");
			ItemStack Item5 = nameItem(Material.LAPIS_BLOCK, ChatColor.DARK_AQUA + "Eternal Rank");
			
			
			ItemStack Item6 = nameItem(Material.IRON_BLOCK, ChatColor.GOLD + "Trainee Rank");
			ItemStack Item7 = nameItem(Material.GOLD_BLOCK, ChatColor.GOLD + "Moderator Rank");
			ItemStack Item8 = nameItem(Material.GOLD_BLOCK, ChatColor.GOLD + "Sr Mod Rank");
			ItemStack Item9 = nameItem(Material.REDSTONE_BLOCK, ChatColor.DARK_RED + "Admin Rank");
			ItemStack Item10 = nameItem(Material.REDSTONE_BLOCK, ChatColor.DARK_RED + "Owner Rank");
			ItemStack Item11 = nameItem(Material.GOLD_BLOCK, ChatColor.GOLD + "Developer Rank");
			
			
			ItemStack Item12 = nameItem(Material.PAPER, ChatColor.AQUA + "Remove Current Rank");
			
			ItemStack Item13 = nameItem(Material.LAPIS_BLOCK, ChatColor.BLUE + "Builder Rank");
			ItemStack Item14 = nameItem(Material.LAPIS_BLOCK, ChatColor.BLUE + "Support Rank");
			ItemStack Item15 = nameItem(Material.LAPIS_BLOCK, ChatColor.BLUE + "Media Rank");
			ItemStack Item16 = nameItem(Material.LAPIS_BLOCK, ChatColor.BLUE + "Map Lead Rank");
			
			inv.setItem(10, Item1);
			inv.setItem(11, Item2);
			inv.setItem(12, Item3);
			inv.setItem(13, Item4);
			inv.setItem(14, Item5);
			inv.setItem(28, Item6);
			inv.setItem(29, Item7);
			inv.setItem(30, Item8);
			inv.setItem(37, Item9);
			inv.setItem(38, Item10);
			inv.setItem(39, Item11);
			inv.setItem(16, Item12);
			
			inv.setItem(32, Item13);
			inv.setItem(33, Item14);
			inv.setItem(41, Item15);
			inv.setItem(42, Item16);
			
			plugin.rankStore.put(player.getName(), args[0]);
			
			player.openInventory(inv);
			return true;
		}
		if(args[1].equals("ALL")) {
			Permissions.updateRank(args[0], Rank.ALL);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to No Rank!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to No Rank!");
			}
			return true;
		}
		if(args[1].equals("ULTRA")) {
			Permissions.updateRank(args[0], Rank.ULTRA);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Ultra!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Ultra!");
			}
			return true;
		}
		if(args[1].equals("HERO")) {
			Permissions.updateRank(args[0], Rank.HERO);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Hero!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Hero!");
			}
			return true;
		}
		if(args[1].equals("LEGEND")) {
			Permissions.updateRank(args[0], Rank.LEGEND);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Legend!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Legend!");
			}
			return true;
		}
		if(args[1].equals("TITAN")) {
			Permissions.updateRank(args[0], Rank.TITAN);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Titan!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Titan!");
			}
			return true;
		}
		if(args[1].equals("ETERNAL")) {
			Permissions.updateRank(args[0], Rank.ETERNAL);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Eternal!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Eternal!");
			}
			return true;
		}
		
		if(args[1].equals("YOUTUBE")) {
			Permissions.updateRank(args[0], Rank.YOUTUBE);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to YouTube!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to YouTube!");
			}
			return true;
		}
		if(args[1].equals("TWITCH")) {
			Permissions.updateRank(args[0], Rank.TWITCH);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Twitch!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Twitch!");
			}
			return true;
		}
		
		if(args[1].equals("SUPPORT")) {
			Permissions.updateRank(args[0], Rank.SUPPORT);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Support!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Support!");
			}
			return true;
		}
		if(args[1].equals("TRAINEE")) {
			Permissions.updateRank(args[0], Rank.TRAINEE);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Trainee!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Trainee!");
			}
			return true;
		}		
		if(args[1].equals("MODERATOR")) {
			Permissions.updateRank(args[0], Rank.MOD);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Mod!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Mod!");
			}
			return true;
		}
		if(args[1].equals("BUILDER")) {
			Permissions.updateRank(args[0], Rank.BUILDER);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Builder!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Builder!");
			}
			return true;
		}
		if(args[1].equals("MAPLEAD")) {
			Permissions.updateRank(args[0], Rank.MAPLEAD);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Maplead!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Maplead!");
			}
			return true;
		}	
		if(args[1].equals("MEDIA")) {
			Permissions.updateRank(args[0], Rank.MEDIA);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Media!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Media!");
			}
			return true;
		}	
		if(args[1].equals("SRMOD")) {
			Permissions.updateRank(args[0], Rank.SRMOD);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Sr Mod!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Sr Mod!");
			}
			return true;
		}
		if(args[1].equals("DEVELOPER")) {
			Permissions.updateRank(args[0], Rank.DEV);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Developer!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Developer!");
			}
			return true;
		}		
		if(args[1].equals("ADMIN")) {
			Permissions.updateRank(args[0], Rank.ADMIN);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Admin!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Admin!");
			}
			return true;
		}
		if(args[1].equals("LEADER")) {
			Permissions.updateRank(args[0], Rank.LEADER);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Leader!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Leader!");
			}
			return true;
		}
		if(args[1].equals("OWNER")) {
			Permissions.updateRank(args[0], Rank.OWNER);
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + args[0] + "'s rank has been Updated to Owner!");
			if(Bukkit.getPlayer(args[0]) != null) {
				Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.GRAY + "Your Rank has been updated to Owner!");
			}
			return true;
		}
		else  {
			player.sendMessage(ChatColor.BLUE + "Client Manager> " + ChatColor.RED + ChatColor.BOLD + "There was an error parsing your request.");
			return false;
		}
	}
	
	
	
    private ItemStack nameItem(ItemStack item, String name) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	item.setItemMeta(meta);
    	return item;
    }

    private ItemStack nameItem(Material item, String name) {
    	return nameItem(new ItemStack(item), name);
    }
}
