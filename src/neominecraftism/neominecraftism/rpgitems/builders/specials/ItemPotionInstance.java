package neominecraftism.neominecraftism.rpgitems.builders.specials;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.rpgitems.builders.ItemType;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.spell.ManaHelper;
import neominecraftism.neominecraftism.util.ItemRarity;

public class ItemPotionInstance extends RPGItem{

	PotionEffect[] effects;
	public ItemPotionInstance(String register_name, String display_name, Material material, ItemRarity rarity, PotionEffect... effects) {
		super(register_name, display_name, material, ItemType.CONSUMABLES, rarity);
		this.effects=effects;
	}
	
	@Override
	public void onConsumed(Player player) {
		for(PotionEffect effect: effects) {
			player.addPotionEffect(effect);
		}
	}

}
