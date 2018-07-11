package net.angusbeefgaming.mineplex.pets;

import org.bukkit.entity.Entity;

import net.angusbeefgaming.mineplex.account.User;

public class Pet {
	User owner;
	Entity ent;
	public Pet(Entity e, User owner) {
		this.owner = owner;
		this.ent = e;
		this.ent.setCustomNameVisible(true);
		this.ent.setCustomName(owner.getName() + "'s Pet");
	}
	
	public void despawnPet() {
		this.ent.remove();
	}
	
	public void setName(String name) {
		ent.setCustomName(name);
	}
}
