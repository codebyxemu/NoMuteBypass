package me.xemu.NoMuteBypass.listeners;

import me.xemu.NoMuteBypass.NoMuteBypass;
import me.xemu.NoMuteBypass.handler.Handler;
import me.xemu.NoMuteBypass.handler.punishment.litebans.LiteBansListeners;
import me.xemu.NoMuteBypass.handler.punishment.litebans.LiteBansPunishmentSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.List;

public class BlockListeners extends Handler implements Listener {

	private List<Material> signTypes;
	public BlockListeners(NoMuteBypass noMuteBypass) {
		super(noMuteBypass);

		signTypes = new ArrayList<>();

		signTypes.add(Material.ACACIA_SIGN);
		signTypes.add(Material.ACACIA_WALL_SIGN);
		signTypes.add(Material.BIRCH_SIGN);
		signTypes.add(Material.BIRCH_WALL_SIGN);
		signTypes.add(Material.CRIMSON_SIGN);
		signTypes.add(Material.CRIMSON_WALL_SIGN);
		signTypes.add(Material.DARK_OAK_SIGN);
		signTypes.add(Material.DARK_OAK_WALL_SIGN);
		signTypes.add(Material.JUNGLE_SIGN);
		signTypes.add(Material.JUNGLE_WALL_SIGN);
		signTypes.add(Material.MANGROVE_SIGN);
		signTypes.add(Material.MANGROVE_WALL_SIGN);
		signTypes.add(Material.OAK_SIGN);
		signTypes.add(Material.OAK_WALL_SIGN);
		signTypes.add(Material.SPRUCE_SIGN);
		signTypes.add(Material.SPRUCE_WALL_SIGN);
		signTypes.add(Material.WARPED_SIGN);
		signTypes.add(Material.WARPED_WALL_SIGN);
		signTypes.add(Material.LEGACY_SIGN);
		signTypes.add(Material.LEGACY_SIGN_POST);
		signTypes.add(Material.LEGACY_WALL_SIGN);
	}


	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();

		boolean muted = false;
		if (noMuteBypass.getCore().getSystem() instanceof LiteBansPunishmentSystem) {
			if (LiteBansListeners.getMutelist().contains(player.getUniqueId())) {
				muted = true;
			}
		} else if (noMuteBypass.getCore().getSystem().isMuted(player)) {
			 muted = true;
		}

		// Check if values are false
		if (!signTypes.contains(block.getType())) return;
		if (!muted) return;

		event.setCancelled(true);

		String message = ChatColor.translateAlternateColorCodes('&', noMuteBypass.getConfig().getString("message"));
		player.sendMessage(message);

		if (noMuteBypass.getConfig().getBoolean("message-staff.enabled")) {
			String staffMessage = ChatColor.translateAlternateColorCodes('&', noMuteBypass.getConfig().getString("message-staff.message"));
			staffMessage.replaceAll("<target>", player.getName());

			Bukkit.getOnlinePlayers().forEach(staffPlayer -> {
				if (staffPlayer.hasPermission("dswm.staff") || staffPlayer.isOp()) {
					staffPlayer.sendMessage(staffMessage);
				}
			});
		}

		return;
	}

}