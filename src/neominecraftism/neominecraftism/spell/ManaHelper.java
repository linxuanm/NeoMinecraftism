package neominecraftism.neominecraftism.spell;

import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.storage.StorageTracker;

public class ManaHelper {
	/**
	 * add the player's mana with the given amount
	 * @param player
	 * @param amount do not allow negative value
	 * @return return true if mana successfully add with certain amount, return false if no mana is added
	 */
	public static boolean addMana(Player player, double amount) {
		if(amount<0) throw new IllegalArgumentException();
		
		double mana = StorageTracker.getPlayerStorage(player).mana;
		double mana_max = StorageTracker.getPlayerStorage(player).mana_max;
		if(mana<mana_max) {
			StorageTracker.getPlayerStorage(player).mana = Math.min(mana+amount, mana_max);
			return true;
		} else {
			return false;
		}
	}
	/**
	 * check whether the player is able to reduce his mana with the given amount
	 * @param player
	 * @param amount do not allow negative value
	 * @return true if the player has enough mana to be reduced.
	 */
	public static boolean canReduceMana(Player player, double amount) {
		if(amount<0) throw new IllegalArgumentException();
		double mana = StorageTracker.getPlayerStorage(player).mana;
		if(mana-amount<0) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * reduce the player's mana with the given amount
	 * @param player
	 * @param amount do not allow negative value,
	 * @return false if the mana does not change
	 */
	public static boolean reduceMana(Player player, double amount) {
		if(amount<0) throw new IllegalArgumentException();

		double mana = StorageTracker.getPlayerStorage(player).mana;
		if(mana>0) {
			StorageTracker.getPlayerStorage(player).mana = Math.max(mana-amount, 0);
			return true;
		} else {
			return false;
		}
	}
	/**
	 * set the mana to the given amount
	 * @param player
	 * @param amount
	 * @return true if the amount is between 0 and the player's max mana
	 */
	public static boolean setMana(Player player, double amount) {
		if(amount>StorageTracker.getPlayerStorage(player).mana_max||amount<0) {
			return false;
		} else {
			StorageTracker.getPlayerStorage(player).mana = amount;
			return true;
		}
	}
	public static double getMana(Player player) {
		return StorageTracker.getPlayerStorage(player).mana;
	}
}
