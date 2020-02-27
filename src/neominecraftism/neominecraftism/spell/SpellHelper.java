package neominecraftism.neominecraftism.spell;

import java.util.Optional;

import neominecraftism.neominecraftism.NeoMinecraftism;

public class SpellHelper {
	
	public static Optional<ISpell> getSpell(String name) {
		return Optional.ofNullable(NeoMinecraftism.getInstance().getRegistryHandler().get(ISpell.class, name));
	}
}
