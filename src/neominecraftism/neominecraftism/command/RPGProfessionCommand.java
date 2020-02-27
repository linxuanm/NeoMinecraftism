package neominecraftism.neominecraftism.command;

import java.util.ArrayList;
import java.util.Set;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.ProfessionHelper;

public class RPGProfessionCommand extends BukkitCommand{

	protected RPGProfessionCommand(String name) {
		super(name);
		Set<String> aliases = NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(IProfession.class);
		this.setAliases(new ArrayList<String>(aliases));
	}

	@Override
    public boolean execute(CommandSender sender, String command, String[] professions) {
		if(sender instanceof Player && professions.length==1) {
			String profession = command.split(":")[1];
			if(NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(IProfession.class).contains(profession)) {
				if(professions[0].equals("add")) {
					ProfessionHelper.addProfession(((Player)sender), ProfessionHelper.getProfession(profession));
					return true;
				}else if(professions[0].equals("remove")) {
					ProfessionHelper.removeProfession(((Player)sender), ProfessionHelper.getProfession(profession));
					return true;
				}else if(professions[0].equals("upgrade")) {
					if(!ProfessionHelper.getProfession(profession).upgradeToThis((Player) sender)) {
						((Player)sender).sendMessage(String.format("You are not able to upgrade to \"%s\" !", professions[1]));
						return false;
					}
					return true;
				}
			}else {
				((Player)sender).sendMessage(String.format("\"%s\" is not a valid name for a profession!", professions[1]));
			}
		}else if(sender instanceof Player && professions.length>1) {
			if(NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(IProfession.class).contains(professions[1])){
				if (professions[0].equals("add")) {
					ProfessionHelper.addProfession(((Player)sender), ProfessionHelper.getProfession(professions[1]));
					return true;
				}else if(professions[0].equals("remove")) {
					ProfessionHelper.removeProfession(((Player)sender), ProfessionHelper.getProfession(professions[1]));
					return true;
				}else if(professions[0].equals("upgrade")){
					if(!ProfessionHelper.getProfession(professions[1]).upgradeToThis((Player) sender)) {
						((Player)sender).sendMessage(String.format("You are not able to upgrade to \"%s\" !", professions[1]));
						return false;
					}
					return true;
				}
			}else {
				((Player)sender).sendMessage(String.format("\"%s\" is not a valid name for a profession!", professions[1]));
			}
		}
        return false;
    }

}
