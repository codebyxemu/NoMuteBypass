package io.github.codebyxemu.nomutebypass.handler.punishment;

import com.earth2me.essentials.Essentials;
import io.github.codebyxemu.nomutebypass.NoMuteBypass;
import io.github.codebyxemu.nomutebypass.handler.IPunishmentSystem;
import org.bukkit.entity.Player;

/* Essentials/EssentialsX by Essentials */
public class EssentialsPunishmentSystem implements IPunishmentSystem {
    private final Essentials essentials;

    public EssentialsPunishmentSystem(NoMuteBypass noMuteBypass) {
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
