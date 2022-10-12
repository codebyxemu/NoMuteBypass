package me.xemu.NoMuteBypass.listeners;

import me.xemu.NoMuteBypass.NoMuteBypass;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListeners implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {

		final Player player = event.getPlayer();

	}

}
