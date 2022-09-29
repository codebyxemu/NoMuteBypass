package me.xemu.DisableSignsWhileMuted.handler.listeners;

import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import me.xemu.DisableSignsWhileMuted.handler.punishment.litebans.LiteBansListeners;
import me.xemu.DisableSignsWhileMuted.handler.punishment.litebans.LiteBansPunishmentSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerEditBookEvent;

import java.util.ArrayList;
import java.util.List;

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