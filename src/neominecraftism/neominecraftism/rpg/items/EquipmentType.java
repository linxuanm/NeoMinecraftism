package neominecraftism.neominecraftism.rpg.items;

public enum EquipmentType {

	CHESTPLATES("胸甲"),
	LEGGINGS("护腿"),
	BOOTS("靴子"),
	HELMET("帽子"),

	;
	
	private String name;
	EquipmentType(String name) {
		this.name=name;
	}
	public String getDisplayText() {
		return this.name;
	}
}
