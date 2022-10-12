package me.xemu.NoMuteBypass;

import me.xemu.NoMuteBypass.core.Core;
import org.bukkit.plugin.java.JavaPlugin;

public class NoMuteBypass extends JavaPlugin {

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
