package me.xemu.NoMuteBypass.core;

import me.xemu.NoMuteBypass.NoMuteBypass;
import me.xemu.NoMuteBypass.handler.IPunishmentSystem;
import me.xemu.NoMuteBypass.commands.CommandDSWM;
import me.xemu.NoMuteBypass.handler.punishment.*;
import me.xemu.NoMuteBypass.listeners.BlockListeners;
import me.xemu.NoMuteBypass.listeners.BookListeners;
import me.xemu.NoMuteBypass.handler.punishment.LiteBansListeners;
import me.xemu.NoMuteBypass.handler.punishment.LiteBansPunishmentSystem;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Core {

	private NoMuteBypass noMuteBypass;

	public Core(NoMuteBypass noMuteBypass) {
		this.noMuteBypass = noMuteBypass;
	}

	public void commands() {
		try {
			noMuteBypass.getCommand("dswm").setExecutor(new CommandDSWM(noMuteBypass));
			log("Registered new command 'dswm'");
		} catch (NullPointerException e) {
			log("Could not register and handle new command: dswm");
			log("Command Registration Failure: " + e.getMessage());
		}
	}

	public void listeners() {
		noMuteBypass.getServer().getPluginManager().registerEvents(new BlockListeners(noMuteBypass), noMuteBypass);
		noMuteBypass.getServer().getPluginManager().registerEvents(new BookListeners(noMuteBypass), noMuteBypass);

		new LiteBansListeners(noMuteBypass);
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

		String prefix = "§8[§6NoMuteBypass§8]";

		s.sendMessage(prefix + " §r" + msg);
	}

	public void handlePunishmentSystem() {
		String system = noMuteBypass.getConfig().getString("system.active");

		HashMap<String, IPunishmentSystem> systems = new HashMap<>();

		systems.put("Essentials", new EssentialsPunishmentSystem(noMuteBypass));
		systems.put("LiteBans", new LiteBansPunishmentSystem(noMuteBypass));
		systems.put("PhoenixCore", new PhoenixPunishmentSystem(noMuteBypass));
		systems.put("AdvancedBan", new AdvancedBanPunishmentSystem(noMuteBypass));
		systems.put("AquaCore", new AquaCorePunishmentSystem(noMuteBypass));
		systems.put("LibertyBans", new LibertyBansPunishmentSystem(noMuteBypass));
		systems.put("PunishControl", new PunishControlPunishmentSystem(noMuteBypass));

		setSystem(systems.get(system));
	}

	public void handleConfig() {
		noMuteBypass.getConfig().options().copyDefaults(true);
		noMuteBypass.saveConfig();
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
				"§8[]========[§6NoMuteBypass§8]========[]",
				"§8| §6Information:",
				"§8|    §6Plugin Version: §e" + noMuteBypass.getDescription().getVersion(),
				"§8|    §6Developer: §eXemu",
				"§8|    §6Active System: §e" + activeSystem,
				"§8| §6Support:",
				"§8|    §6Discord: §ehttps://discord.gg/mhzrNx8Ce3",
				"§8|    §6SpigotMC Username: §eXemu",
				"§8[]========[§6NoMuteBypass§8]========[]",
		};

		for (String part : message) {
			s.sendMessage(part);
		}
	}

	public void metrics(JavaPlugin plugin) {
		final int pluginId = 16644;
		final Metrics metrics = new Metrics(plugin, pluginId);
		Core.log("bStats handling completed.");
	}
}