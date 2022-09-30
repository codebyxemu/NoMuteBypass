package me.xemu.DisableSignsWhileMuted.listeners;

import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

public class BookListeners extends Handler implements Listener {

	public BookListeners(Main main) {
		super(main);
	}

	@EventHandler
	public void onPlayerEditBook(PlayerEditBookEvent event) {

		if (main.getConfig().getBoolean("disable-book-edit")) {
			if (main.getCore().getSystem().isMuted(event.getPlayer())) {
				event.setCancelled(true);
				event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',
						main.getConfig().getString("message"))
				);
			}
		}

	}
}