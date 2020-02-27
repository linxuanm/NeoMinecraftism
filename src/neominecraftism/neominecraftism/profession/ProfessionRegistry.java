package neominecraftism.neominecraftism.profession;

import neominecraftism.neominecraftism.profession.identities.Civilian;
import neominecraftism.neominecraftism.profession.identities.Ranger;
import neominecraftism.neominecraftism.profession.identities.Warrior;
import neominecraftism.neominecraftism.registry.RegistryHandler;

public class ProfessionRegistry {

	
	public static void register(RegistryHandler handler) {		
		
		handler.register(IProfession.class, new Civilian());
		handler.register(IProfession.class, new Ranger());
		handler.register(IProfession.class, new Warrior());

	}
	
}
