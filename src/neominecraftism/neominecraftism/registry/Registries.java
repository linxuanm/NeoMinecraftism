package neominecraftism.neominecraftism.registry;

import neominecraftism.neominecraftism.menu.IClickableMenu;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.ProfessionRegistry;
import neominecraftism.neominecraftism.rpgitems.ItemRegistry;
import neominecraftism.neominecraftism.rpgitems.WeaponRegistry;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.spell.ISpell;
import neominecraftism.neominecraftism.spell.SpellRegistry;

public class Registries {
	
	public static void registerRPGElements(RegistryHandler handler) {
		handler.addRegistryType(RPGItem.class);
		handler.addRegistryType(ISpell.class);
		handler.addRegistryType(IProfession.class);
		System.out.println("[NeoMinecraftism] Item Registering Starts");
		ItemRegistry.register(handler);
		System.out.println("[NeoMinecraftism] Weapon Registering Starts");
		WeaponRegistry.register(handler);
		System.out.println("[NeoMinecraftism] Spell Registering Starts");
		SpellRegistry.register(handler);
		System.out.println("[NeoMinecraftism] Profession Registering Starts");
		ProfessionRegistry.register(handler);

	}
	
	public static void registerMenus(RegistryHandler handler) {
		handler.addRegistryType(IClickableMenu.class);
	}
}
