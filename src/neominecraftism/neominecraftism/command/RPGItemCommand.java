package neominecraftism.neominecraftism.command;

import java.util.ArrayList;
import java.util.Set;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import neominecraftism.neominecraftism.NeoMinecraftism;
import neominecraftism.neominecraftism.rpgitems.builders.ItemHelper;
import neominecraftism.neominecraftism.rpgitems.builders.RPGItem;

public class RPGItemCommand extends BukkitCommand{

	protected RPGItemCommand(String name) {
		super(name);
		Set<String> aliases = NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(RPGItem.class);
		this.setAliases(new ArrayList<String>(aliases));
	}

	@Override
    public boolean execute(CommandSender sender, String command, String[] args) {
		if(sender instanceof Player && args.length==0) {
			String item = command.split(":")[1];
			if (NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(RPGItem.class).contains(item)) {
				((Player)sender).getInventory().addItem(ItemHelper.getItem(item).build());
				return true;
			}else {
				((Player)sender).sendMessage(String.format("\"%s\" is not a valid name!", item));
			}
		}
		else if(sender instanceof Player && args.length>0) {
			if (NeoMinecraftism.getInstance().getRegistryHandler().getRegistryNames(RPGItem.class).contains(args[0])) {
				((Player)sender).getInventory().addItem(ItemHelper.getItem(args[0]).build());
				return true;
			}else {
				((Player)sender).sendMessage(String.format("\"%s\" is not a valid name!", args[0]));
			}
		}
        return true;
    }

}
