package neominecraftism.neominecraftism.spell.caster;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.spell.ISpell;
import neominecraftism.neominecraftism.spell.SpellType;

public class MassHealingSpell extends ISpell {

	public MassHealingSpell() {
		super("mass_healing_spell");
	}

	@Override
	public String getSpellName() {
		return "Mass Healing Spell";
	}

	@Override
	public SpellType getSpellType() {
		return SpellType.ASSIST_SPELL;
	}

	@Override
	public String getSpellExplanation() {
		return "Heals all players in a small range.";
	}

	@Override
	public Material getRepresentation() {
		return Material.ICE;
	}

	@Override
	public int getManaCost() {
		return 0;
	}

	@Override
	public int getCoolDown() {
		return 100;
	}

	@Override
	public boolean canCast(Player player) {
		return true;
	}

	@Override
	public void onUse(Player player) {
		player.sendMessage("Hello World");
	}
}
