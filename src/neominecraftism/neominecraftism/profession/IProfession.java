package neominecraftism.neominecraftism.profession;

import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.registry.IRegistryEntry;
import neominecraftism.neominecraftism.rpgitems.builders.EquipmentType;
import neominecraftism.neominecraftism.rpgitems.builders.WeaponType;

/**
 * An abstraction for player's profession, it can be understood as identity.
 * A player can have many professions at the same time.
 * They can also upgrade their profession to a higher level profession.
 */
public abstract class IProfession extends IRegistryEntry<IProfession> {

	public IProfession(String registryName) {
		super(registryName);
		
	}
	
	
	/**
	 * Gets the display name of the profession.
	 * 
	 * @return The display name of the profession.
	 */
	public abstract String getProfessionName();
	
	public abstract String[] getDescription();

	/**
	 * Upgrade player's current profession to this profession.
	 * Check player's current professions and level is always required.
	 * Some profession may need further requirement,
	 * for example:
	 * - the combination of two professions,
	 * - the money in player's inventory,
	 * - the hidden statistics like the mob you killed.
	 * 
	 * The previous profession is supposed to be removed after upgrading.
	 * If the player cannot upgrade due to the lack of preposition, false is returned.
	 * 
	 * @return Whether upgrade is successful.
	 */
	public abstract boolean upgradeToThis(Player player);
	
	/**
	 * get the weapon that this profession is allow/recommended to use
	 * 
	 * @return The array of items.
	 */
	public abstract WeaponType[] getMasterWeapon();
	
	/**
	 * get the armor that this profession is allow/recommended to wear
	 * 
	 * @return The array of items.
	 */
	public abstract EquipmentType[] getMasterArmor();
	
	/**
	 * the effect to player as the profession is obtained, for example adding attribute modifier and giving profession-specific spells
	 * 
	 */
	public void effectOnObtain(Player player) {
	}
	
	/**
	 * the effect to player as the profession every 10 ticks, 
	 * for example checking player's weapon/offhand item/health/potion effect...
	 * 
	 */
	public void effectPerHalfSecond(Player player) {
	}
	
	/**
	 * the effect to player as the profession every 100 ticks (5 second), 
	 * for example giving archer arrow
	 * 
	 */
	public void effectPerFiveSecond(Player player) {
	}
	
	/**
	 * the effect to player as the profession every 200 ticks (10 second), usually for some effects 
	 * that are more powerful, for example giving absorption/heal
	 *  
	 */
	public void effectPerTenSecond(Player player) {
	}

}
