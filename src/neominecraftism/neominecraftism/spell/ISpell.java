package neominecraftism.neominecraftism.spell;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.registry.IRegistryEntry;


/**
 * An abstraction for spell items.
 * 
 * @author David Ma
 */
public abstract class ISpell extends IRegistryEntry<ISpell> {
	
	public ISpell(String registryName) {
		super(registryName);
	}

	/**
	 * Gets the name of the spell.
	 * 
	 * @return The name of the spell.
	 */
	public abstract String getSpellName();
	
	/**
	 * Gets the description of the spell.
	 * 
	 * @return The description of the spell.
	 */
	public void getSpellDescription(List<String> lore) {
		lore.add(ChatColor.AQUA + this.getSpellType().getText());
		lore.add(ChatColor.GRAY + this.getSpellExplanation());
		lore.add("");
		lore.add("法力值消耗: "+ this.getManaCost());
		lore.add("冷却: "+ this.getManaCost());
	}
	
	/**
	 * Gets the type of the spell ("辅助类法术"/"强化类法术"/"伤害类法术").
	 * 
	 * @return The type of the spell.
	 */
	public abstract SpellType getSpellType();
	
	/**
	 * Gets the explanation to the function fo the spell the spell.
	 * 
	 * @return The explanation of the spell.
	 */
	public abstract String getSpellExplanation();

	/**
	 * Gets the representation (item type) of the spell (i.e. ice block for freesing spell).
	 * 
	 * @return The representation of the spell.
	 */
	public abstract Material getRepresentation();
	
	/**
	 * Gets the mana cost of the spell.
	 * 
	 * @return The mana cost.
	 */
	public abstract int getManaCost();
	
	/**
	 * Gets the cooldown of the spell (in ticks).
	 * 
	 * @return The cooldown.
	 */
	public abstract int getCoolDown();

	/**
	 * Returns whether the spell can be casted under the circumstance. Should not check mana.
	 * 
	 * @param player The player that casts the spell.
	 * @return Whether the spell can be casted.
	 */
	public abstract boolean canCast(Player player);
	
	/**
	 * Perform the actual spell. Will not get called if 
	 * 
	 * @param player The player that casts the spell.
	 */
	public abstract void onUse(Player player);
}
