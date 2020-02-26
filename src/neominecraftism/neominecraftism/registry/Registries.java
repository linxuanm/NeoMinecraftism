package neominecraftism.neominecraftism.registry;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import neominecraftism.neominecraftism.menu.IClickableMenu;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.Professions;
import neominecraftism.neominecraftism.profession.identities.Civilian;
import neominecraftism.neominecraftism.profession.identities.Ranger;
import neominecraftism.neominecraftism.rpgitems.Items;
import neominecraftism.neominecraftism.rpgitems.Weapons;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.spell.ISpell;
import neominecraftism.neominecraftism.spell.Spells;
import neominecraftism.neominecraftism.spell.caster.MassHealingSpell;

public class Registries {
	
	public static void registerSpells(RegistryHandler handler) {
		handler.addRegistryType(ISpell.class);
		Field[] fields= Spells.class.getFields();
		for(Field field: fields) {
			field.setAccessible(true);
			try {
				ISpell spell = (ISpell) field.get(null);
				System.out.println("Neominecraftism: Registering Spell "+spell.getRegistryName());
				handler.register(ISpell.class, spell);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void registerMenus(RegistryHandler handler) {
		handler.addRegistryType(IClickableMenu.class);
	}
	
	public static void registerProfession(RegistryHandler handler) {
		handler.addRegistryType(IProfession.class);
		Field[] fields= Professions.class.getFields();
		for(Field field: fields) {
			field.setAccessible(true);
			try {
				IProfession profession = (IProfession) field.get(null);
				System.out.println("Neominecraftism: Registering Profession "+profession.getRegistryName());
				handler.register(IProfession.class, profession);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void registerItem(RegistryHandler handler) {
		handler.addRegistryType(RPGItem.class);
		List<Field> fields = new ArrayList<Field>();
		fields.addAll(Arrays.asList(Weapons.class.getFields()));
		fields.addAll(Arrays.asList(Items.class.getFields()));

		for(Field field: fields) {
			field.setAccessible(true);
			try {
				RPGItem item = (RPGItem) field.get(null);
				System.out.println("Neominecraftism: Registering RPGItem "+item.getRegistryName());
				handler.register(RPGItem.class, item);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
