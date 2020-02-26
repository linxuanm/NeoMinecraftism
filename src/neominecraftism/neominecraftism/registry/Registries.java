package neominecraftism.neominecraftism.registry;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import neominecraftism.neominecraftism.menu.IClickableMenu;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.ProfessionRegistry;
import neominecraftism.neominecraftism.profession.identities.Civilian;
import neominecraftism.neominecraftism.profession.identities.Ranger;
import neominecraftism.neominecraftism.rpgitems.ItemRegistry;
import neominecraftism.neominecraftism.rpgitems.WeaponRegistry;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.spell.ISpell;
import neominecraftism.neominecraftism.spell.SpellRegistry;
import neominecraftism.neominecraftism.spell.caster.MassHealingSpell;

public class Registries {
	
	public static void registerRPGElements(RegistryHandler handler) {
		handler.addRegistryType(RPGItem.class);
		handler.addRegistryType(ISpell.class);
		handler.addRegistryType(IProfession.class);

		ItemRegistry.register(handler);
		WeaponRegistry.register(handler);
		SpellRegistry.register(handler);
		ProfessionRegistry.register(handler);

	}
	
	public static void registerMenus(RegistryHandler handler) {
		handler.addRegistryType(IClickableMenu.class);
	}
}
