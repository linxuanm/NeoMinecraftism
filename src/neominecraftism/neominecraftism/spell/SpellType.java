package neominecraftism.neominecraftism.spell;

public enum SpellType {
	ARCANE_SPELL("奥术系法术"),
	ELEMENTAL_SPELL("元素系法术"),
	NATURAL_SPELL("自然系法术"),
	MIND_SPELL("心灵系法术"),
	CURSE_SPELL("诅咒系法术"),
	DEVINE_SPELL("神术");
	
	private String displayText;
	
	SpellType(String displayText) {
		this.displayText = displayText;
	}
	
	public String getText() {
		return displayText;
	}
}
