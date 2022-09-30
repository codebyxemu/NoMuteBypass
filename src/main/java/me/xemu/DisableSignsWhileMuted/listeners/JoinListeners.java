package me.xemu.DisableSignsWhileMuted.listeners;

import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListeners extends Handler implements Listener {

	public JoinListeners(Main main) {
		super(main);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {

		final Player player = event.getPlayer();

	}

}
