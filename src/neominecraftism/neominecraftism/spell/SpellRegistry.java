package neominecraftism.neominecraftism.spell;

import neominecraftism.neominecraftism.registry.RegistryHandler;
import neominecraftism.neominecraftism.spell.caster.MassHealingSpell;

public class SpellRegistry {

	public static void register(RegistryHandler handler) {
		handler.register(ISpell.class, new MassHealingSpell());
	}
}
