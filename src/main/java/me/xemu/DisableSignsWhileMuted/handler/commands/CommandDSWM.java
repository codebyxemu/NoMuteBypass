package me.xemu.DisableSignsWhileMuted.handler.commands;

import me.xemu.DisableSignsWhileMuted.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDSWM implements CommandExecutor {

	private Main main;

	public CommandDSWM(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) return true;

		Player player = (Player) sender;

		if (args.length == 0) {
			player.sendMessage(ChatColor.RED + "DisableSignsWhileMuted - Version: " + main
					.getDescription().getVersion());
			player.sendMessage(ChatColor.RED + "Active Punishment System: " + main.getCore().getSystem().getName());
			return true;
		} else if (args.length == 1) {
			if (args[0].equalsIgnoreCase("reload") && player.hasPermission("dswm.reload")) {
				player.sendMessage(ChatColor.RED + "Reloaded plugin!");
				main.reloadConfig();
				main.getCore().handlePunishmentSystem();
			} else {
				player.sendMessage(ChatColor.RED + "DisableSignsWhileMuted - Version: " + main
						.getDescription().getVersion());
				player.sendMessage(ChatColor.RED + "Active Punishment System: " + main.getCore().getSystem().getName());
				return true;
			}
		} else if (args.length == 2) {
			if (args[0].equalsIgnoreCase("check") && player.hasPermission("dswm.check")) {
				Player user = Bukkit.getPlayer(args[1]);

				if (user == null) {
					player.sendMessage(ChatColor.RED + "Invalid Target: " + args[1]);
					return true;
				}

				boolean muted = main.getCore().getSystem().isMuted(user);
				String status = "Not Muted";

				if (muted) {
					status = "Muted";
				}

				player.sendMessage(ChatColor.RED + user.getName() + " is currently " + status + ".");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "DisableSignsWhileMuted - Version: " + main
						.getDescription().getVersion());
				player.sendMessage(ChatColor.RED + "Active Punishment System: " + main.getCore().getSystem().getName());
				return true;
			}
		}

		return true;
	}

}
