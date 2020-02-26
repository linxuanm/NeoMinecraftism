package neominecraftism.neominecraftism.util;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionEffectBuilder {

	public static PotionEffect buildHidden(PotionEffectType type, int duration, int amplifier) {
		return new PotionEffect(type, amplifier, amplifier, true, false, false);
	}
	
	public static PotionEffect buildIconOnly(PotionEffectType type, int duration, int amplifier) {
		return new PotionEffect(type, amplifier, amplifier, true, false, true);
	}
	public static PotionEffect buildAmbient(PotionEffectType type, int duration, int amplifier) {
		return new PotionEffect(type, amplifier, amplifier, true, true, true);
	}
	public static PotionEffect buildNormal(PotionEffectType type, int duration, int amplifier) {
		return new PotionEffect(type, amplifier, amplifier, false, true, true);
	}
}
