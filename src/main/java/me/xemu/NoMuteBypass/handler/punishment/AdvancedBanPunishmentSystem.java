package me.xemu.NoMuteBypass.handler.punishment;

import me.leoko.advancedban.manager.PunishmentManager;
import me.leoko.advancedban.manager.UUIDManager;
import me.xemu.NoMuteBypass.NoMuteBypass;
import me.xemu.NoMuteBypass.handler.Handler;
import me.xemu.NoMuteBypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

/* AdvancedBan by Leoko.dev */
public class AdvancedBanPunishmentSystem extends Handler implements IPunishmentSystem {
	public AdvancedBanPunishmentSystem(NoMuteBypass noMuteBypass) {
		super(noMuteBypass);
	}

	@Override
	public String getName() {
		return "AdvancedBan";
	}

	@Override
	public boolean isMuted(Player player) {
		return PunishmentManager.get().isMuted(UUIDManager.get().getUUID(player.getName()));
	}
}
