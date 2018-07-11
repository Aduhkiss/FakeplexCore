package net.angusbeefgaming.mineplex.pets;

import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.account.UserManager;

public class PetManager {
	
	
	
	// Spawn code for Pets
	public void spawnCowPet(Player p) {
		Cow cowObj = (Cow) (p.getWorld().spawnEntity(p.getLocation(), EntityType.COW));
		UserManager.getUserFromPlayer(p).spawnedPet = new Pet(cowObj, UserManager.getUserFromPlayer(p));
	}
}
