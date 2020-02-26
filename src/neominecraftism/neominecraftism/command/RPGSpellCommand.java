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
import neominecraftism.neominecraftism.rpg.items.ItemHelper;
import neominecraftism.neominecraftism.rpg.items.RPGItem;
import neominecraftism.neominecraftism.spell.ISpell;
import neominecraftism.neominecraftism.spell.SpellFactory;

public class RPGSpellCommand extends BukkitCommand{

	protected RPGSpellCommand(String name) {
		super(name);
		Set<String> aliases = NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(ISpell.class);
		this.setAliases(new ArrayList<String>(aliases));
	}

	@Override
    public boolean execute(CommandSender sender, String command, String[] args) {
		if(sender instanceof Player && args.length==0) {
			String spell = command.split(":")[1];
			if (NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(ISpell.class).contains(spell)) {
					((Player)sender).getInventory().addItem(SpellFactory.createSpellStack(spell));
					return true;
			}else {
				((Player)sender).sendMessage(String.format("\"%s\" is not a valid name for spell!", spell));
			}
		}else if(sender instanceof Player && args.length>0) {
			if (NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(ISpell.class).contains(args[0])) {
				((Player)sender).getInventory().addItem(SpellFactory.createSpellStack(args[0]));
				return true;
		}else {
			((Player)sender).sendMessage(String.format("\"%s\" is not a valid name for spell!", args[0]));
		}
	}
        return false;
    }

}
