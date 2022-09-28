package me.xemu.DisableSignsWhileMuted.handler.punishment;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.IEssentials;
import com.earth2me.essentials.User;
import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.commands.EssentialsCommand;
import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.handler.IHandler;
import me.xemu.DisableSignsWhileMuted.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

import static com.earth2me.essentials.I18n.tl;

public class EssentialsPunishmentSystem extends IHandler implements IPunishmentSystem {
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
