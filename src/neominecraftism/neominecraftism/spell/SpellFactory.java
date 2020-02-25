package neominecraftism.neominecraftism.spell;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.util.NBTHelper;

public class SpellFactory {
	
	public static ItemStack createSpellStack(String name) {
		return createSpellStack(NeoMinecraftism.getInstance().getRegistryHandler().get(ISpell.class, name));
	}
	
	public static ItemStack createSpellStack(ISpell spell) {
		ItemStack caster = new ItemStack(spell.getRepresentation());
		NBTHelper.makeUnique(caster);
		
		caster.getItemMeta().setDisplayName(spell.getSpellName());
		
		List<String> lore = new ArrayList<>();
		spell.setSpellDescription(lore);
		caster.getItemMeta().setLore(lore);
		
		PersistentDataContainer tag = NBTHelper.getTag(caster);
		tag.set(NBTHelper.namespace("spell_id"), PersistentDataType.STRING, spell.getRegistryName());
		
		return caster;
	}
}
