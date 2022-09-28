package me.xemu.DisableSignsWhileMuted.handler.punishment;

import me.leoko.advancedban.manager.PunishmentManager;
import me.leoko.advancedban.shaded.org.hsqldb.Database;
import me.leoko.advancedban.shaded.org.hsqldb.lib.Storage;
import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.IHandler;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

import java.util.Objects;

public class AdvancedBanPunishmentSystem extends IHandler implements IPunishmentSystem {

	public AdvancedBanPunishmentSystem(Main main) {
		super(main);
	}

	@Override
	public String getName() {
		return "LiteBans";
	}

	@Override
	public boolean isMuted(Player player) {



		return PunishmentManager.get().isMuted(player.getUniqueId().toString());
	}

}
