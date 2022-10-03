package me.xemu.DisableSignsWhileMuted.handler.punishment;

import com.earth2me.essentials.Essentials;
import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

/* Essentials/EssentialsX by Essentials */
public class EssentialsPunishmentSystem extends Handler implements IPunishmentSystem {
	private Essentials essentials;
	public EssentialsPunishmentSystem(Main main) {
		super(main);

		this.essentials = (Essentials) main.getServer().getPluginManager().getPlugin("Essentials");
	}

	@Override
	public String getName() {
		return "Essentials";
	}

	@Override
	public boolean isMuted(Player player) {
		return essentials.getUser(player).isMuted();
	}
}
