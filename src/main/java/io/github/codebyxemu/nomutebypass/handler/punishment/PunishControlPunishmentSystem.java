package io.github.codebyxemu.nomutebypass.handler.punishment;

import dev.simplix.plugins.punishcontrol.PunishControlAPI;
import dev.simplix.plugins.punishcontrol.Punishment;
import io.github.codebyxemu.nomutebypass.NoMuteBypass;
import io.github.codebyxemu.nomutebypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

import java.util.List;

/* PunishControl by SimplixSoftware */
public class PunishControlPunishmentSystem implements IPunishmentSystem {

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
