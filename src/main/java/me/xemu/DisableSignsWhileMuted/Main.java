package me.xemu.DisableSignsWhileMuted;

import me.xemu.DisableSignsWhileMuted.core.Core;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

	private Core core;

	@Override
	public void onEnable() {
		this.core = new Core(this);

		core.handleConfig();
		core.handlePunishmentSystem();
		core.commands();
		core.listeners();
		core.metrics(this);

		core.sendDetailedStartupMessage();
	}

	@Override
	public void onDisable() {
		Core.log("Plugin successfully disabled! Goodbye! :)");
	}

	public Core getCore() {
		return core;
	}
}
