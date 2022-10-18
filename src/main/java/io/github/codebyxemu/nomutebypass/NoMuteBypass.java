package io.github.codebyxemu.nomutebypass;

import io.github.codebyxemu.nomutebypass.commands.CommandDSWM;
import io.github.codebyxemu.nomutebypass.handler.IPunishmentSystem;
import io.github.codebyxemu.nomutebypass.handler.punishment.*;
import io.github.codebyxemu.nomutebypass.listeners.BlockListeners;
import io.github.codebyxemu.nomutebypass.listeners.BookListeners;
import io.github.codebyxemu.nomutebypass.utils.Config;
import lombok.Getter;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

@Getter
public class NoMuteBypass extends JavaPlugin {

	private Config config;

	public void onEnable() {
		this.config = new Config(this, "config");

		this.handlePunishmentSystem();
		this.registerCommands();
		this.registerListeners();
		this.metrics(this);

		this.sendDetailedStartupMessage();
	}

	private void registerCommands() {
		try {
			this.getCommand("dswm").setExecutor(new CommandDSWM(this));
			log("Registered new command 'dswm'");
		} catch (NullPointerException e) {
			log("Could not register and handle new command: dswm");
			log("Command Registration Failure: " + e.getMessage());
		}
	}

	private void registerListeners() {
		PluginManager manager = this.getServer().getPluginManager();
		manager.registerEvents(new BlockListeners(this), this);
		manager.registerEvents(new BookListeners(this), this);

		new LiteBansListeners(this);
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
		String system = this.getConfig().getString("system.active");

		HashMap<String, IPunishmentSystem> systems = new HashMap<>();

		systems.put("Essentials", new EssentialsPunishmentSystem(this));
		systems.put("LiteBans", new LiteBansPunishmentSystem());
		systems.put("PhoenixCore", new PhoenixPunishmentSystem());
		systems.put("AdvancedBan", new AdvancedBanPunishmentSystem());
		systems.put("AquaCore", new AquaCorePunishmentSystem());
		systems.put("LibertyBans", new LibertyBansPunishmentSystem());
		systems.put("PunishControl", new PunishControlPunishmentSystem());

		setSystem(systems.get(system));
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
				"§8|    §6Plugin Version: §e" + this.getDescription().getVersion(),
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
		log("bStats handling completed.");
	}

	public void onDisable() {
		log("Plugin successfully disabled! Goodbye! :)");
	}
}
