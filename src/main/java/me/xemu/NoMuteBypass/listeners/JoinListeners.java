package me.xemu.NoMuteBypass.listeners;

import me.xemu.NoMuteBypass.NoMuteBypass;
import me.xemu.NoMuteBypass.handler.Handler;
import me.xemu.NoMuteBypass.handler.core.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListeners extends Handler implements Listener {

	public JoinListeners(NoMuteBypass noMuteBypass) {
		super(noMuteBypass);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {

		final Player player = event.getPlayer();

	}

}
