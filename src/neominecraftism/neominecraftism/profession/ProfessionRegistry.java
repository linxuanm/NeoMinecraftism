package neominecraftism.neominecraftism.profession;

import neominecraftism.neominecraftism.profession.identities.Civilian;
import neominecraftism.neominecraftism.profession.identities.Knight;
import neominecraftism.neominecraftism.profession.identities.Mage;
import neominecraftism.neominecraftism.profession.identities.Noble;
import neominecraftism.neominecraftism.profession.identities.Priest;
import neominecraftism.neominecraftism.profession.identities.Ranger;
import neominecraftism.neominecraftism.profession.identities.Rougue;
import neominecraftism.neominecraftism.profession.identities.Warrior;
import neominecraftism.neominecraftism.registry.RegistryHandler;

public class ProfessionRegistry {

	
	public static void register(RegistryHandler handler) {		
		//identities
		handler.register(IProfession.class, new Civilian());
		handler.register(IProfession.class, new Noble());

		//warrior path
		handler.register(IProfession.class, new Warrior());
		//knight path
		handler.register(IProfession.class, new Knight());
		//ranger path
		handler.register(IProfession.class, new Ranger());
		//rougue path
		handler.register(IProfession.class, new Rougue());
		//mage path
		handler.register(IProfession.class, new Mage());
		//preist path
		handler.register(IProfession.class, new Priest());

	}
	
}
