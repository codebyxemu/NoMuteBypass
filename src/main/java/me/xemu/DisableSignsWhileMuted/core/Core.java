package me.xemu.DisableSignsWhileMuted.core;

import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import me.xemu.DisableSignsWhileMuted.commands.CommandDSWM;
import me.xemu.DisableSignsWhileMuted.handler.punishment.AdvancedBanPunishmentSystem;
import me.xemu.DisableSignsWhileMuted.handler.punishment.AquaCorePunishmentSystem;
import me.xemu.DisableSignsWhileMuted.listeners.BlockListeners;
import me.xemu.DisableSignsWhileMuted.listeners.BookListeners;
import me.xemu.DisableSignsWhileMuted.handler.punishment.EssentialsPunishmentSystem;
import me.xemu.DisableSignsWhileMuted.handler.punishment.litebans.LiteBansListeners;
import me.xemu.DisableSignsWhileMuted.handler.punishment.litebans.LiteBansPunishmentSystem;
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
		main.getServer().getPluginManager().registerEvents(new BookListeners(main), main);

		new LiteBansListeners(main);
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
		systems.put("AdvancedBan", new AdvancedBanPunishmentSystem(main));
		systems.put("AquaCore", new AquaCorePunishmentSystem(main));

		setSystem(systems.get(system));
	}

	public void handleConfig() {
		main.getConfig().options().copyDefaults(true);
		main.saveConfig();
	}
}