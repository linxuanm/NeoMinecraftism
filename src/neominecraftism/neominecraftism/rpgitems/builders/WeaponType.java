package neominecraftism.neominecraftism.rpgitems.builders;

public enum WeaponType {

	AXE("战斧"),
	SWORD("大剑"),
	BOW("弓箭"),
	SHELD("盾牌"),
	CROSS_BOW("劲弩"),
	WAND("法杖"),
	HALBERD("战戟"),
	;
	
	private String name;
	WeaponType(String name) {
		this.name=name;
	}
	public String getDisplayText() {
		return this.name;
	}
}
