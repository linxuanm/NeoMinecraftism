package neominecraftism.neominecraftism.spell;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.ItemStack;

public class SpellRegistry {
	
	private static Map<String, ISpell> registry = new HashMap<>();
	
	public void register(ISpell spell) {
		registry.put(spell.getSpellName(), spell);
	}
	
	/**
	 * Creates an instance of the caster item.
	 * 
	 * @param spell The spell to bbe instantiated.
	 * @return The caster item.
	 */
	public ItemStack createSpellStack(ISpell spell) {
		ItemStack caster = new ItemStack(spell.getRepresentation());
		
		// TODO: add lores and nbt and stuff
		
		return caster;
	}
	
	public static Collection<ISpell> getSpells() {
		return registry.values();
	}
}
