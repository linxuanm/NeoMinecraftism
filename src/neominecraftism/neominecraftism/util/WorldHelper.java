package neominecraftism.neominecraftism.util;

import java.util.Collection;
import java.util.function.Predicate;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class WorldHelper {
	
	public static Collection<Entity> getNearbyEntities(Location loc, double r, Predicate<Entity> tester) {
		return loc.getWorld().getNearbyEntities(loc, r, r, r, tester);
	}
	
	public static Collection<Entity> getNearbyEntities(Location loc, double r) {
		return loc.getWorld().getNearbyEntities(loc, r, r, r);
	}
}
