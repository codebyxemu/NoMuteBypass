package io.github.codebyxemu.nomutebypass.handler.punishment;

import dev.phoenix.phoenix.PhoenixAPI;
import io.github.codebyxemu.nomutebypass.NoMuteBypass;
import io.github.codebyxemu.nomutebypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

/* PhoenixCore by Px-Development */
public class PhoenixPunishmentSystem implements IPunishmentSystem {

	@Override
	public String getName() {
		return "PhoenixCore";
	}

	@Override
	public boolean isMuted(Player player) {
		return PhoenixAPI.INSTANCE.isMuted(player.getUniqueId());
	}
}
