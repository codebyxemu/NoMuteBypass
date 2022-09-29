package me.xemu.DisableSignsWhileMuted;

import me.xemu.DisableSignsWhileMuted.handler.core.Core;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private Core core;

	@Override
	public void onEnable() {
		this.core = new Core(this);
		Core.log("Plugin is loading...");

		core.handleConfig();
		core.handlePunishmentSystem();

		if (core.getSystem() == null) {
			Core.log("Did not find any Punishment System.");
		} else {
			Core.log("Punishment System: " + core.getSystem().getName());
		}

		Core.log("Loading listeners & commands.");
		core.commands();
		core.listeners();

		Core.log("Plugin loaded & enabled! Enjoy!");
	}

	@Override
	public void onDisable() {
		Core.log("Plugin successfully disabled! Goodbye! :)");
	}

	public Core getCore() {
		return core;
	}
}
