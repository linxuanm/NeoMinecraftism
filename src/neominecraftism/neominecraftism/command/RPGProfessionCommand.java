package neominecraftism.neominecraftism.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import com.google.common.collect.Sets;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.profession.IProfession;
import neominecraftism.neominecraftism.profession.ProfessionHelper;
import neominecraftism.neominecraftism.rpg.items.ItemHelper;
import neominecraftism.neominecraftism.rpg.items.RPGItem;
import neominecraftism.neominecraftism.spell.ISpell;
import neominecraftism.neominecraftism.spell.SpellFactory;

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
			if (NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(IProfession.class).contains(profession)
					&& professions[0].equals("add")) {
				ProfessionHelper.addProfession(((Player)sender), ProfessionHelper.getProfession(profession));
				return true;
			}else if(NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(IProfession.class).contains(profession)
					&& professions[0].equals("remove")) {
				ProfessionHelper.removeProfession(((Player)sender), ProfessionHelper.getProfession(profession));
				return true;
			}else {
				((Player)sender).sendMessage(String.format("\"%s\" is not a valid name for profession!", profession));
				return false;

			}
		}else if(sender instanceof Player && professions.length>1) {
			if (NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(IProfession.class).contains(professions[1])
					&& professions[0].equals("add")) {
				ProfessionHelper.addProfession(((Player)sender), ProfessionHelper.getProfession(professions[1]));
				return true;
			}else if(NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(IProfession.class).contains(professions[1])
					&& professions[0].equals("remove")) {
				ProfessionHelper.removeProfession(((Player)sender), ProfessionHelper.getProfession(professions[1]));
				return true;
			}else {
				((Player)sender).sendMessage(String.format("\"%s\" is not a valid name for profession!", professions[1]));
				return false;

			}
		}
        return false;
    }

}
