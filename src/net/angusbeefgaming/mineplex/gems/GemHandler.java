package net.angusbeefgaming.mineplex.gems;

import org.bukkit.entity.Player;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

public class GemHandler {
	
	public static long getGemCount(Player p) throws UserDoesNotExistException {
		Economy eco = new Economy();
		return Math.round(eco.getMoney(p.getName()));
	}
	
	public static void addGems(Player p, int gem) throws NoLoanPermittedException, UserDoesNotExistException {
		Economy eco = new Economy();
		eco.add(p.getName(), gem);
	}

}
