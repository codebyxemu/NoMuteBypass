package io.github.codebyxemu.nomutebypass.handler.punishment;

import io.github.codebyxemu.nomutebypass.NoMuteBypass;
import io.github.codebyxemu.nomutebypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

public class LiteBansPunishmentSystem implements IPunishmentSystem {

	@Override
	public String getName() {
		return "LiteBans";
	}

	@Override
	public boolean isMuted(Player player) {
		return LiteBansListeners.getMutelist().contains(player.getUniqueId());
	}

}
