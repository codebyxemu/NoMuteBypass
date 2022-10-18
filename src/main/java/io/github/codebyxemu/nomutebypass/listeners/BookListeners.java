package io.github.codebyxemu.nomutebypass.listeners;

import io.github.codebyxemu.nomutebypass.NoMuteBypass;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

public class BookListeners implements Listener {

	private final NoMuteBypass noMuteBypass;

	public BookListeners(NoMuteBypass noMuteBypass) {
		this.noMuteBypass = noMuteBypass;
	}

	@EventHandler
	public void onPlayerEditBook(PlayerEditBookEvent event) {

		if (noMuteBypass.getConfig().getBoolean("disable-book-edit")) {
			if (noMuteBypass.getSystem().isMuted(event.getPlayer())) {
				event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',
						this.noMuteBypass.getConfig().getString("message")));
				event.setCancelled(true);
			}
		}

	}
}