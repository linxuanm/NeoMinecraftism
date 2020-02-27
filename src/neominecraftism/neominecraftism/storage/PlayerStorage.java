package neominecraftism.neominecraftism.storage;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that handles the storage of a player.
 * 
 * @author David Ma
 */
public class PlayerStorage {
	
	public double mana = 0;
	public double mana_max = 100;
	public double base_intellect = 0;
	public double base_strength = 0;
	public int stealth_timer = 0;
	public String[] professions = new String[] {};
	public List<String> spell_tags = new ArrayList<String>();

}
