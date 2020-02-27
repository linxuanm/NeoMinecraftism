package neominecraftism.neominecraftism.spell.caster;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.spell.ISpell;
import neominecraftism.neominecraftism.spell.SpellType;
import neominecraftism.neominecraftism.storage.StorageTracker;

public abstract class NextAttackSpell extends ISpell{

	public NextAttackSpell(String registryName) {
		super(registryName);
	}

	@Override
	public void onUse(Player player, Block block) {
		addSpellTag(player, this.getRegistryName());
	}
	
	public abstract double onNextAttack(Player player, Entity target, double damage);
	
	public static void addSpellTag(Player player, String tag) {
		if(!StorageTracker.getPlayerStorage(player).spell_tags.contains(tag)) {
			StorageTracker.getPlayerStorage(player).spell_tags.add(tag);
		}
	}

}
