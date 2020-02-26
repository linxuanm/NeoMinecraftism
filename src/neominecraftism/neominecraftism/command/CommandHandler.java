package neominecraftism.neominecraftism.command;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

public class CommandHandler {

	public static void init() {
		try{
		    Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
		    commandMapField.setAccessible(true);
		    CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());
		    commandMap.register("rpgitem", new RPGItemCommand("rpgitem"));
		    commandMap.register("rpgspell", new RPGSpellCommand("rpgspell"));
		    commandMap.register("rpgprofession", new RPGProfessionCommand("rpgprofession"));

		    
		}
		catch(Exception exception){
		    exception.printStackTrace();
		}
	}
}
