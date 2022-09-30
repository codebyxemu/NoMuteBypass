package me.xemu.DisableSignsWhileMuted.handler.punishment;

import com.earth2me.essentials.perm.IPermissionsHandler;
import me.leoko.advancedban.manager.PunishmentManager;
import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

public class AdvancedBanPunishmentSystem extends Handler implements IPunishmentSystem {
	public AdvancedBanPunishmentSystem(Main main) {
		super(main);
	}

	@Override
	public String getName() {
		return "AdvancedBan";
	}

	@Override
	public boolean isMuted(Player player) {
		return PunishmentManager.get().isMuted(player.getUniqueId().toString());
	}
}
