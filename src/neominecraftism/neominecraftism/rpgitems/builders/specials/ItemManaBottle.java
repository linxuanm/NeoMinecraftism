package neominecraftism.neominecraftism.rpgitems.builders.specials;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.rpgitems.builders.ItemType;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.spell.ManaHelper;
import neominecraftism.neominecraftism.util.ItemRarity;

public class ItemManaBottle extends RPGItem{

	int amount;
	public ItemManaBottle(String register_name, String display_name, Material material, ItemRarity rarity, int amount) {
		super(register_name, display_name, material, ItemType.CONSUMABLES, rarity);
		this.amount=amount;
	}
	
	@Override
	public void onConsumed(Player player) {
		ManaHelper.addMana(player, amount);
	}

}
