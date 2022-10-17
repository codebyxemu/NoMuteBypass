package io.github.codebyxemu.nomutebypass.handler.punishment;

import io.github.codebyxemu.nomutebypass.NoMuteBypass;
import litebans.api.Database;
import litebans.api.Entry;
import litebans.api.Events;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.UUID;

public class LiteBansListeners implements Listener {

	private static ArrayList<UUID> mutelist = new ArrayList<>();

	public static ArrayList<UUID> getMutelist() {
		return mutelist;
	}

	private final NoMuteBypass noMuteBypass;

	public LiteBansListeners(NoMuteBypass noMuteBypass) {
		this.noMuteBypass = noMuteBypass;

		Events.get().register(new Events.Listener() {

			@Override
			public void entryAdded(Entry entry) {
				if (entry.getType().equals("mute")) {
					getMutelist().add(UUID.fromString(entry.getUuid()));
				}
			}

			@Override
			public void entryRemoved(Entry entry) {
				if (entry.getType().equals("mute")) {
					getMutelist().remove(UUID.fromString(entry.getUuid()));
				}
			}
		});
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		if (noMuteBypass.getSystem() instanceof LiteBansPunishmentSystem) {
			UUID uuid = event.getPlayer().getUniqueId();

			new BukkitRunnable() {
				@Override
				public void run() {
					boolean isMuted = Database.get().isPlayerMuted(uuid, null);
					if (isMuted) {
						mutelist.add(uuid);
					}
				}
			}.runTaskAsynchronously(noMuteBypass);
		}
	}

}
