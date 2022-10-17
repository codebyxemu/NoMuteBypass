package io.github.codebyxemu.nomutebypass.handler.punishment;

import io.github.codebyxemu.nomutebypass.NoMuteBypass;
import me.leoko.advancedban.manager.PunishmentManager;
import me.leoko.advancedban.manager.UUIDManager;
import io.github.codebyxemu.nomutebypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

/* AdvancedBan by Leoko.dev */
public class AdvancedBanPunishmentSystem implements IPunishmentSystem {

	@Override
	public String getName() {
		return "AdvancedBan";
	}

	@Override
	public boolean isMuted(Player player) {
		return PunishmentManager.get().isMuted(UUIDManager.get().getUUID(player.getName()));
	}
}
