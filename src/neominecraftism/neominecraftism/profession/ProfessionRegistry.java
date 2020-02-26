package neominecraftism.neominecraftism.profession;

import java.lang.reflect.Field;

import neominecraftism.neominecraftism.profession.identities.Civilian;
import neominecraftism.neominecraftism.profession.identities.Ranger;
import neominecraftism.neominecraftism.registry.RegistryHandler;
import neominecraftism.neominecraftism.spell.ISpell;
import neominecraftism.neominecraftism.spell.Spells;

public class ProfessionRegistry {

	
	public static void register(RegistryHandler handler) {		
		
		handler.register(IProfession.class, new Civilian());
		handler.register(IProfession.class, new Ranger());

	}
	
}
