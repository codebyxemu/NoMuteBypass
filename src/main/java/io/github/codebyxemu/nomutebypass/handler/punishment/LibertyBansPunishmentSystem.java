package io.github.codebyxemu.nomutebypass.handler.punishment;

import io.github.codebyxemu.nomutebypass.NoMuteBypass;
import io.github.codebyxemu.nomutebypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;
import space.arim.libertybans.api.LibertyBans;
import space.arim.libertybans.api.NetworkAddress;
import space.arim.libertybans.api.punish.Punishment;
import space.arim.libertybans.api.select.PunishmentSelector;
import space.arim.omnibus.Omnibus;
import space.arim.omnibus.OmnibusProvider;

import java.util.Optional;

/* LibertyBans by A248*/
public class LibertyBansPunishmentSystem implements IPunishmentSystem {

	private Omnibus omnibus;
	private LibertyBans libertyBans;

	public LibertyBansPunishmentSystem() {
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
