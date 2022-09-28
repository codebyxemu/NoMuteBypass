package me.xemu.DisableSignsWhileMuted.handler.punishment;

import litebans.api.Database;
import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.IHandler;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

import java.util.Objects;

public class LiteBansPunishmentSystem extends IHandler implements IPunishmentSystem {

	public LiteBansPunishmentSystem(Main main) {
		super(main);
	}

	@Override
	public String getName() {
		return "LiteBans";
	}

	@Override
	public boolean isMuted(Player player) {
		return Database.get().isPlayerMuted(player.getUniqueId(), Objects.requireNonNull(player.getAddress()).getHostName());
	}

}
