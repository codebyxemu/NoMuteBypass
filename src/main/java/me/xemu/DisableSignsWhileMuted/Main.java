package me.xemu.DisableSignsWhileMuted;

import me.xemu.DisableSignsWhileMuted.core.Core;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private Core core;

	@Override
	public void onEnable() {
		this.core = new Core(this);

		core.handleConfig();
		core.handlePunishmentSystem();
		core.commands();
		core.listeners();
		core.metrics();

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
