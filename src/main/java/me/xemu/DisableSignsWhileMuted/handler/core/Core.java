package me.xemu.DisableSignsWhileMuted.handler.core;

import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import me.xemu.DisableSignsWhileMuted.commands.CommandDSWM;
import me.xemu.DisableSignsWhileMuted.handler.punishment.*;
import me.xemu.DisableSignsWhileMuted.listeners.BlockListeners;
import me.xemu.DisableSignsWhileMuted.listeners.BookListeners;
import me.xemu.DisableSignsWhileMuted.handler.punishment.litebans.LiteBansListeners;
import me.xemu.DisableSignsWhileMuted.handler.punishment.litebans.LiteBansPunishmentSystem;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

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
		ConsoleCommandSender s = Bukkit.getConsoleSender();

		String prefix = "§8[§6Disable§eSigns§6While§eMuted§8]";

		s.sendMessage(prefix + " " + msg);
	}

	public void handlePunishmentSystem() {
		String system = main.getConfig().getString("system.active");

		HashMap<String, IPunishmentSystem> systems = new HashMap<>();

		systems.put("Essentials", new EssentialsPunishmentSystem(main));
		systems.put("LiteBans", new LiteBansPunishmentSystem(main));
		systems.put("PhoenixCore", new PhoenixPunishmentSystem(main));
		systems.put("AdvancedBan", new AdvancedBanPunishmentSystem(main));
		systems.put("AquaCore", new AquaCorePunishmentSystem(main));
		systems.put("LibertyBans", new LibertyBansPunishmentSystem(main));
		systems.put("PunishControl", new PunishControlPunishmentSystem(main));

		setSystem(systems.get(system));
	}

	public void handleConfig() {
		main.getConfig().options().copyDefaults(true);
		main.saveConfig();
	}

	public void sendDetailedStartupMessage() {

		ConsoleCommandSender s = Bukkit.getConsoleSender();

		String activeSystem = "";

		if (getSystem() == null) {
			activeSystem = "No System Setup";
		} else {
			activeSystem = getSystem().getName();
		}

		String[] message = new String[]{
				"§8[]========[§6Disable§eSigns§6While§eMuted§8]========[]",
				"§8| §6Information:",
				"§8|    §6Plugin Version: §e" + main.getDescription().getVersion(),
				"§8|    §6Developer: §eXemu",
				"§8|    §6Active System: §e" + activeSystem,
				"§8| §6Support:",
				"§8|    §6Discord: §ehttps://discord.gg/mhzrNx8Ce3",
				"§8|    §6SpigotMC Username: §eXemu",
				"§8[]========[§6Disable§eSigns§6While§eMuted§8]========[]",
		};

		for (String part : message) {
			s.sendMessage(part);
		}
	}

	public void metrics(JavaPlugin plugin) {
		final int pluginId = 16547;
		final Metrics metrics = new Metrics(plugin, pluginId);
		Core.log("bStats handling completed.");
	}
}