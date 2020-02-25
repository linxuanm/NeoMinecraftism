package neominecraftism.neominecraftism.registry;

import neominecraftism.neominecraftism.menu.IClickableMenu;
import neominecraftism.neominecraftism.spell.ISpell;

public class Registries {
	
	public static void registerSpells(RegistryHandler handler) {
		handler.addRegistryType(ISpell.class);
	}
	
	public static void registerMenus(RegistryHandler handler) {
		handler.addRegistryType(IClickableMenu.class);
	}
}
