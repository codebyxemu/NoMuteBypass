package me.xemu.NoMuteBypass.listeners;

import me.xemu.NoMuteBypass.NoMuteBypass;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

public class BookListeners implements Listener {

	private NoMuteBypass noMuteBypass;
	public BookListeners(NoMuteBypass noMuteBypass) {
		this.noMuteBypass = noMuteBypass;
	}

	@EventHandler
	public void onPlayerEditBook(PlayerEditBookEvent event) {

		if (noMuteBypass.getConfig().getBoolean("disable-book-edit")) {
			if (noMuteBypass.getCore().getSystem().isMuted(event.getPlayer())) {
				event.setCancelled(true);
				event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',
						noMuteBypass.getConfig().getString("message"))
				);
			}
		}

	}
}