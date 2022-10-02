package me.xemu.DisableSignsWhileMuted.handler.punishment;

import dev.phoenix.phoenix.PhoenixAPI;
import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

public class PhoenixPunishmentSystem extends Handler implements IPunishmentSystem {
	public PhoenixPunishmentSystem(Main main) {
		super(main);

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
