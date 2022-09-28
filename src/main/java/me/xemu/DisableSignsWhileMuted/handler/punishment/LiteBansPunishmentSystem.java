package me.xemu.DisableSignsWhileMuted.handler.punishment;

import litebans.api.Database;
import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.UUID;

public class LiteBansPunishmentSystem extends Handler implements IPunishmentSystem {
	private static ArrayList<UUID> MutedList;

	public LiteBansPunishmentSystem(Main main) {
		super(main);

		MutedList = new ArrayList<>();
	}

	public static ArrayList<UUID> getMutedList() {
		return MutedList;
	}

	public static void setMutedList(ArrayList<UUID> mutedList) {
		MutedList = mutedList;
	}

	@Override
	public String getName() {
		return "LiteBans";
	}

	@Override
	public boolean isMuted(Player player) {
		return getMutedList().contains(player.getUniqueId());
	}

}
