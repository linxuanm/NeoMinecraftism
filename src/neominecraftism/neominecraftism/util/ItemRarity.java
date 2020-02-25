package neominecraftism.neominecraftism.util;

import org.bukkit.ChatColor;

public enum ItemRarity {
	
	NONE(ChatColor.WHITE),
	NORMAL(ChatColor.GRAY),
	RARE(ChatColor.BLUE),
	EPIC(ChatColor.LIGHT_PURPLE),
	LENGENDARY(ChatColor.GOLD);
	
	private ChatColor color;
	
	ItemRarity(ChatColor color) {
		this.color = color;
	}
	
	public ChatColor getColor() {
		return this.color;
	}
}
