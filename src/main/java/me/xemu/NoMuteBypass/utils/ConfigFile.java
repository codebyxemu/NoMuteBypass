package me.xemu.NoMuteBypass.utils;

import me.xemu.NoMuteBypass.NoMuteBypass;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigFile extends YamlConfiguration {

	private File file;
	private FileConfiguration config;

	public ConfigFile(NoMuteBypass noMuteBypass, String child) {
		this.file = new File(noMuteBypass.getDataFolder(), child);
		this.config = loadConfiguration(file);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public File getFile() {
		return file;
	}

	public FileConfiguration getConfig() {
		return config;
	}

	public void save() {
		try {
			config.save(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
