package io.github.codebyxemu.nomutebypass.handler;

import org.bukkit.entity.Player;

public interface IPunishmentSystem {

	public String getName();

	public boolean isMuted(Player player);

}
