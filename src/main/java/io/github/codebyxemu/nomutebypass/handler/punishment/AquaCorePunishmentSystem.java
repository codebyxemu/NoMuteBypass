package io.github.codebyxemu.nomutebypass.handler.punishment;

import io.github.codebyxemu.nomutebypass.NoMuteBypass;
import me.activated.core.plugin.AquaCoreAPI;
import io.github.codebyxemu.nomutebypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

/* AquaCore by FaceSlap02 */
public class AquaCorePunishmentSystem implements IPunishmentSystem {

    @Override
    public String getName() {
        return "AquaCore-Punishment";
    }

    @Override
    public boolean isMuted(Player player) {
        return AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getPunishData().isMuted();
    }
}
