package net.angusbeefgaming.mineplex.common;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class F {
	public void main(Player p, String module, String body) {
		p.sendMessage(ChatColor.BLUE + module + "> " + ChatColor.GRAY + body);
	}
}
