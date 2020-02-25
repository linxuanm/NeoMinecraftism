package neominecraftism.neominecraftism.registry;

import neominecraftism.neominecraftism.menu.IClickableMenu;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.identities.Civilian;
import neominecraftism.neominecraftism.profession.identities.Ranger;
import neominecraftism.neominecraftism.spell.ISpell;
import neominecraftism.neominecraftism.spell.caster.MassHealingSpell;

public class Registries {
	
	public static void registerSpells(RegistryHandler handler) {
		handler.addRegistryType(ISpell.class);
		handler.register(ISpell.class, new MassHealingSpell());
	}
	
	public static void registerMenus(RegistryHandler handler) {
		handler.addRegistryType(IClickableMenu.class);
	}
	
	public static void registerProfession(RegistryHandler handler) {
		handler.addRegistryType(IProfession.class);
		handler.register(IProfession.class, new Civilian());
		handler.register(IProfession.class, new Ranger());
	}
}
