package neominecraftism.neominecraftism.rpgitems;

import org.bukkit.Material;

import neominecraftism.neominecraftism.rpgitems.builders.ItemType;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;
import neominecraftism.neominecraftism.rpgitems.builders.specials.ItemHealthBottle;
import neominecraftism.neominecraftism.rpgitems.builders.specials.ItemManaBottle;
import neominecraftism.neominecraftism.util.ItemRarity;

public class Items {
	
	public static final RPGItem SILVER_COIN = new RPGItem("silver_coin", "银币", Material.IRON_NUGGET, ItemType.CURRENCY, ItemRarity.NORMAL)
			.withDescription("大陆上最常用的货币，购买力很低");
	public static final RPGItem GOLD_COIN = new RPGItem("gold_coin", "金币", Material.GOLD_NUGGET, ItemType.CURRENCY, ItemRarity.NORMAL)
			.withDescription("较为少见的货币，一般等值于16个银币，但是很少有人会用来兑换银币");
	
	
	
	public static final RPGItem SMALL_MANA_BOTTLE = new ItemManaBottle("small_mama_bottle", "小瓶法力药水", Material.POTION, ItemRarity.NORMAL, 20)
			.withDescription("回复少量的法力值");
	public static final RPGItem MIDDLE_MANA_BOTTLE = new ItemManaBottle("middle_mama_bottle", "中瓶法力药水", Material.POTION, ItemRarity.RARE, 50)
			.withDescription("回复中等分量的法力值");
	public static final RPGItem LARGE_MANA_BOTTLE = new ItemManaBottle("large_mama_bottle", "大瓶法力药水", Material.POTION, ItemRarity.EPIC, 100)
			.withDescription("回复大量的法力值");
	public static final RPGItem SMALL_HEALTH_BOTTLE = new ItemHealthBottle("small_health_bottle", "小瓶生命药水", Material.POTION, ItemRarity.NORMAL, 8)
			.withDescription("回复少量的生命值");
	public static final RPGItem MIDDLE_HEALTH_BOTTLE = new ItemHealthBottle("middle_health_bottle", "中瓶生命药水", Material.POTION, ItemRarity.RARE, 15)
			.withDescription("回复适中的生命值");
	public static final RPGItem LARGE_HEALTH_BOTTLE = new ItemHealthBottle("large_health_bottle", "大瓶生命药水", Material.POTION, ItemRarity.EPIC, 30)
			.withDescription("回复大量的生命值");
}
