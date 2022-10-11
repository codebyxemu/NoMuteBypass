package me.xemu.NoMuteBypass.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CommandTarget {

	private Player player;

	public CommandTarget(String name) {
		this.player = Bukkit.getPlayer(name);
	}

	public CommandTarget(UUID uuid) {
		this.player = Bukkit.getPlayer(uuid);
	}

	public CommandTarget(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isPlayerNull() {
		return player == null;
	}

}
