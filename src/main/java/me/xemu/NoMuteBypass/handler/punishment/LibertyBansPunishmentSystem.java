package me.xemu.NoMuteBypass.handler.punishment;

import me.xemu.NoMuteBypass.NoMuteBypass;
import me.xemu.NoMuteBypass.handler.Handler;
import me.xemu.NoMuteBypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;
import space.arim.libertybans.api.LibertyBans;
import space.arim.libertybans.api.NetworkAddress;
import space.arim.libertybans.api.punish.Punishment;
import space.arim.libertybans.api.select.PunishmentSelector;
import space.arim.omnibus.Omnibus;
import space.arim.omnibus.OmnibusProvider;

import java.util.Optional;

/* LibertyBans by A248*/
public class LibertyBansPunishmentSystem extends Handler implements IPunishmentSystem {

	private Omnibus omnibus;
	private LibertyBans libertyBans;

	public LibertyBansPunishmentSystem(NoMuteBypass noMuteBypass) {
		super(noMuteBypass);
		this.omnibus = OmnibusProvider.getOmnibus();
		this.libertyBans = omnibus.getRegistry().getProvider(LibertyBans.class).get();
	}

	@Override
	public String getName() {
		return "LibertyBans";
	}

	@Override
	public boolean isMuted(Player player) {
		PunishmentSelector selector = libertyBans.getSelector();
		Optional<Punishment> optMute = selector.getCachedMute(player.getUniqueId(), NetworkAddress.of(player.getAddress().getAddress())).toCompletableFuture().join();

		return optMute.isPresent();
	}
}
