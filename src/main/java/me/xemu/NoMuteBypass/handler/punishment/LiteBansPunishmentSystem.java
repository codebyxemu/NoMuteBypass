package me.xemu.NoMuteBypass.handler.punishment;

import me.xemu.NoMuteBypass.NoMuteBypass;
import me.xemu.NoMuteBypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

public class LiteBansPunishmentSystem extends Handler implements IPunishmentSystem {
	public LiteBansPunishmentSystem(NoMuteBypass noMuteBypass) {
		super(noMuteBypass);
	}

	@Override
	public String getName() {
		return "LiteBans";
	}

	@Override
	public boolean isMuted(Player player) {
		return LiteBansListeners.getMutelist().contains(player.getUniqueId());
	}

}
