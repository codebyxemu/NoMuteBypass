package me.xemu.DisableSignsWhileMuted.handler.punishment;

import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.IHandler;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

public class ExamplePunishmentSystem extends IHandler implements IPunishmentSystem {
	public ExamplePunishmentSystem(Main main) {
		super(main);
	}

	@Override
	public String getName() {
		return "Example-Always-Muted";
	}

	@Override
	public boolean isMuted(Player player) {
		return true;
	}
}
