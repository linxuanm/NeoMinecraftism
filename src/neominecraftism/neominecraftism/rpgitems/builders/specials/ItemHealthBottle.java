package neominecraftism.neominecraftism.rpgitems.builders.specials;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.rpgitems.builders.ItemType;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.spell.ManaHelper;
import neominecraftism.neominecraftism.util.ItemRarity;

public class ItemHealthBottle extends RPGItem{

	int amount;
	public ItemHealthBottle(String register_name, String display_name, Material material, ItemRarity rarity, int amount) {
		super(register_name, display_name, material, ItemType.CONSUMABLES, rarity);
		this.amount=amount;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onConsumed(Player player) {
		double max = player.getMaxHealth();
		double health = player.getHealth();
		player.setHealth(Math.min(max, health+amount));
	}

}
