package me.xemu.DisableSignsWhileMuted.handler.listeners;

import com.google.common.base.Absent;
import litebans.api.Database;
import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import me.xemu.DisableSignsWhileMuted.handler.punishment.LiteBansPunishmentSystem;
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

		if (main.getCore().getSystem() instanceof LiteBansPunishmentSystem) {
			if (Database.get().isPlayerMuted(player.getUniqueId(), null)) {
				LiteBansPunishmentSystem.getMutedList().add(player.getUniqueId());
			}
		}

	}

}
