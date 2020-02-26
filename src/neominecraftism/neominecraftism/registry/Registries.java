package neominecraftism.neominecraftism.registry;

import java.lang.reflect.Field;

import neominecraftism.neominecraftism.menu.IClickableMenu;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.identities.Civilian;
import neominecraftism.neominecraftism.profession.identities.Ranger;
import neominecraftism.neominecraftism.rpg.Weapons;
import neominecraftism.neominecraftism.rpg.items.RPGItem;
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
	
	public static void registerItem(RegistryHandler handler) {
		handler.addRegistryType(RPGItem.class);
		Field[] fields = Weapons.class.getFields();
		for(Field field: fields) {
			field.setAccessible(true);
			try {
				RPGItem item = (RPGItem) field.get(null);
				System.out.println("neominecraftism: registering rpg item "+item.getRegistryName());
				handler.register(RPGItem.class, item);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
