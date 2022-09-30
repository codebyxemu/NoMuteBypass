package me.xemu.DisableSignsWhileMuted.handler.punishment.litebans;

import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

public class LiteBansPunishmentSystem extends Handler implements IPunishmentSystem {
	public LiteBansPunishmentSystem(Main main) {
		super(main);
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
