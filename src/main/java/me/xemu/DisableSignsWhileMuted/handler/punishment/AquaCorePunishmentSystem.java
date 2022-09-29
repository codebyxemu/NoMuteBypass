package me.xemu.DisableSignsWhileMuted.handler.punishment;

import me.activated.core.plugin.AquaCoreAPI;
import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

public class AquaCorePunishmentSystem extends Handler implements IPunishmentSystem {
	public AquaCorePunishmentSystem(Main main) {
		super(main);
	}

	@Override
	public String getName() {
		return "AquaCore-Punishment";
	}

	@Override
	public boolean isMuted(Player player) {
		return AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getPunishData().isMuted();
	}
}
