package neominecraftism.neominecraftism.spell;

public enum SpellType {
	
	ATTACK_SPELL("伤害类法术"),
	REINFORCE_SPELL("强化类法术"),
	ASSIST_SPELL("辅助类法术");
	
	private String displayText;
	
	SpellType(String displayText) {
		this.displayText = displayText;
	}
	
	public String getText() {
		return displayText;
	}
}
