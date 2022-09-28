package me.xemu.DisableSignsWhileMuted.handler.core;

import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import me.xemu.DisableSignsWhileMuted.handler.commands.CommandDSWM;
import me.xemu.DisableSignsWhileMuted.handler.listeners.BlockListeners;
import me.xemu.DisableSignsWhileMuted.handler.punishment.EssentialsPunishmentSystem;
import me.xemu.DisableSignsWhileMuted.handler.punishment.LiteBansPunishmentSystem;
import me.xemu.DisableSignsWhileMuted.handler.punishment.PhoenixPunishmentSystem;
import org.bukkit.Bukkit;

import java.util.HashMap;

public class Core {

	private Main main;

	public Core(Main main) {
		this.main = main;
	}

	public void commands() {
		try {
			main.getCommand("dswm").setExecutor(new CommandDSWM(main));
			log("Registered new command 'dswm'");
		} catch (NullPointerException e) {
			log("Could not register and handle new command: dswm");
			log("Command Registration Failure: " + e.getMessage());
		}
	}

	public void listeners() {
		main.getServer().getPluginManager().registerEvents(new BlockListeners(main), main);
	}

	private IPunishmentSystem system;

	public IPunishmentSystem getSystem() {
		return system;
	}

	public void setSystem(IPunishmentSystem system) {
		this.system = system;
	}

	public static void log(String msg) {
		Bukkit.getLogger().info("[DisableSignsWhileMuted] " + msg);
	}

	public void handlePunishmentSystem() {
		String system = main.getConfig().getString("system.active");

		HashMap<String, IPunishmentSystem> systems = new HashMap<>();

		systems.put("Essentials", new EssentialsPunishmentSystem(main));
		systems.put("LiteBans", new LiteBansPunishmentSystem(main));
		systems.put("PhoenixCore", new PhoenixPunishmentSystem(main));

		setSystem(systems.get(system));
	}

	public void handleConfig() {
		main.getConfig().options().copyDefaults(true);
		main.saveConfig();
	}
}