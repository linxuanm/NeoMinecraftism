package neominecraftism.neominecraftism.rpgitems.builders;

public enum EquipmentType {

	HEAVY_CHESTPLATES("重甲"),
	LIGHT_CHESTPLATES("轻甲"),
	LEGGINGS("护腿"),
	BOOTS("靴子"),
	HAT("帽子"),
	HELMET("头盔"),
	;
	
	private String name;
	EquipmentType(String name) {
		this.name=name;
	}
	public String getDisplayText() {
		return this.name;
	}
}
