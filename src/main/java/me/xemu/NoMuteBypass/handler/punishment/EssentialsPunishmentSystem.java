package me.xemu.NoMuteBypass.handler.punishment;

import com.earth2me.essentials.Essentials;
import me.xemu.NoMuteBypass.NoMuteBypass;
import me.xemu.NoMuteBypass.handler.Handler;
import me.xemu.NoMuteBypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

/* Essentials/EssentialsX by Essentials */
public class EssentialsPunishmentSystem extends Handler implements IPunishmentSystem {
	private Essentials essentials;
	public EssentialsPunishmentSystem(NoMuteBypass noMuteBypass) {
		super(noMuteBypass);

		this.essentials = (Essentials) noMuteBypass.getServer().getPluginManager().getPlugin("Essentials");
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
