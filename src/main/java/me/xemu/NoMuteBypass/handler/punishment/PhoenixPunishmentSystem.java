package me.xemu.NoMuteBypass.handler.punishment;

import dev.phoenix.phoenix.PhoenixAPI;
import me.xemu.NoMuteBypass.NoMuteBypass;
import me.xemu.NoMuteBypass.handler.Handler;
import me.xemu.NoMuteBypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

/* PhoenixCore by Px-Development */
public class PhoenixPunishmentSystem extends Handler implements IPunishmentSystem {
	public PhoenixPunishmentSystem(NoMuteBypass noMuteBypass) {
		super(noMuteBypass);
	}

	@Override
	public String getName() {
		return "PhoenixCore";
	}

	@Override
	public boolean isMuted(Player player) {
		return PhoenixAPI.INSTANCE.isMuted(player.getUniqueId());
	}
}
