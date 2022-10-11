package me.xemu.NoMuteBypass.handler.punishment;

import me.activated.core.plugin.AquaCoreAPI;
import me.xemu.NoMuteBypass.NoMuteBypass;
import me.xemu.NoMuteBypass.handler.Handler;
import me.xemu.NoMuteBypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

/* AquaCore by FaceSlap02 */
public class AquaCorePunishmentSystem extends Handler implements IPunishmentSystem {
	public AquaCorePunishmentSystem(NoMuteBypass noMuteBypass) {
		super(noMuteBypass);
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
