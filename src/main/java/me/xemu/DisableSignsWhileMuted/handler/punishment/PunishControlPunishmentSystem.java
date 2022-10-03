package me.xemu.DisableSignsWhileMuted.handler.punishment;

import dev.simplix.plugins.punishcontrol.PunishControlAPI;
import dev.simplix.plugins.punishcontrol.Punishment;
import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

import java.util.List;

/* PunishControl by SimplixSoftware */
public class PunishControlPunishmentSystem extends Handler implements IPunishmentSystem {
	public PunishControlPunishmentSystem(Main main) {
		super(main);
	}

	@Override
	public String getName() {
		return "PunishControl";
	}

	@Override
	public boolean isMuted(Player player) {
		PunishControlAPI api = PunishControlAPI.instance();
		List<Punishment> punishments = api.listPunishments();

		for (Punishment p : punishments) {
			if (p.target() == player.getUniqueId() && !p.expired()) {
				return true;
			}
		}

		return false;
	}
}
