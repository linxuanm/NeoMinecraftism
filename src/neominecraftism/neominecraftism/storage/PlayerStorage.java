package neominecraftism.neominecraftism.storage;

/**
 * A class that handles the storage of a player.
 * 
 * @author David Ma
 */
public class PlayerStorage {
	
	private int mana = 0;
	private String[] professions = new String[] {};

	
	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public String[] getProfessions() {
		return professions;
	}

	public void setProfessions(String[] professions) {
		this.professions = professions;
	}

}
