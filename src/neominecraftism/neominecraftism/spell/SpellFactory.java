package neominecraftism.neominecraftism.spell;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.util.NBTHelper;
import net.md_5.bungee.api.ChatColor;

public class SpellFactory {
	
	public static ItemStack createSpellStack(String name) {
		return createSpellStack(NeoMinecraftism.getInstance().getRegistryHandler().get(ISpell.class, name));
	}
	
	public static ItemStack createSpellStack(ISpell spell) {
		ItemStack caster = new ItemStack(spell.getRepresentation());
		NBTHelper.makeUnique(caster);
		ItemMeta meta = caster.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + spell.getSpellName());
		
		List<String> lore = new ArrayList<>();

		spell.getSpellDescription(lore);
		meta.setLore(lore);
		
		PersistentDataContainer tag = meta.getPersistentDataContainer();
		tag.set(NBTHelper.namespace("spell_id"), PersistentDataType.STRING, spell.getRegistryName());
		caster.setItemMeta(meta);
		
		return caster;
	}
}
