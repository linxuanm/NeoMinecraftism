package neominecraftism.neominecraftism.storage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.google.gson.Gson;

import neominecraftism.neominecraftism.NeoMinecraftism;

public class StorageTracker {
	
	public static final String PATH = "neominecraftism";
	
	private Map<UUID, PlayerStorage> storages;
	
	public StorageTracker() {
		this.storages = new HashMap<>();
	}
	
	/**
	 * Loads or creates (if not exist on disk) the data of a player.
	 */
	public void loadOrCreatePlayerEntry(UUID uuid) {
		File file = getFileFromUUID(uuid);
		
		if (file.exists()) {
			try (Reader reader = new FileReader(file)) {
				Gson gson = new Gson();
				PlayerStorage storage = gson.fromJson(reader, PlayerStorage.class);
				this.storages.put(uuid, storage);
			} catch (IOException e) {
				NeoMinecraftism.getInstance().getLogger().severe(e.getMessage());
			}
		} else {
			this.storages.put(uuid, new PlayerStorage());
		}
	}
	
	public void dumpPlayer(UUID uuid) {
		File file = getFileFromUUID(uuid);
		
		if (this.storages.containsKey(uuid)) {
			try (Writer writer = new FileWriter(file)) {
				Gson gson = new Gson();
				gson.toJson(this.storages.get(uuid), writer);
			} catch (IOException e) {
				NeoMinecraftism.getInstance().getLogger().severe(e.getMessage());
			}
			
			this.storages.remove(uuid);
		} else {
			NeoMinecraftism.getInstance().getLogger().severe(
				"Trying to save the data of a non-existing player! This is bad."
			);
		}
	}
	
	public void dumpAll() {
		this.storages.keySet().forEach(this::dumpPlayer);
	}
	
	public PlayerStorage getPlayerStorage(UUID uuid) {
		if (!this.storages.containsKey(uuid)) {
			this.loadOrCreatePlayerEntry(uuid);
		}
		
		return this.storages.get(uuid);
	}
	
	public static File getFileFromUUID(UUID uuid) {
		File dir = new File("neominecraftism");
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		return new File("neominecraftism/" + uuid.toString() + ".json");
	}
	public static PlayerStorage getPlayerStorage(Player player) {
		return NeoMinecraftism.getInstance().getStorageTracker().getPlayerStorage(player.getUniqueId());
	}
}
