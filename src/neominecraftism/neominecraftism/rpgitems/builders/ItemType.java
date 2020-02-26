package neominecraftism.neominecraftism.rpgitems.builders;

public enum ItemType {

	EQUIPMENT("装备"),
	WEAPON("武器"),
	TASK_ITEM("任务物品"),
	MATERIAL("材料"),
	CURRENCY("货币"),
	CONSUMABLES("消耗品"),
	TREASURE("宝物"),
	EMPTY(""),
	;
	private String name;
	ItemType(String name) {
		this.name=name;
	}
	public String getDisplayText() {
		return this.name;
	}
}
