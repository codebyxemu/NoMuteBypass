package me.xemu.DisableSignsWhileMuted.handler.metrics;

import me.xemu.DisableSignsWhileMuted.Main;
import me.xemu.DisableSignsWhileMuted.core.Core;
import me.xemu.DisableSignsWhileMuted.handler.Handler;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;

public class MetricsHandler extends Handler {


	public MetricsHandler(Main main) {
		super(main);
	}


	public void handleMetrics() {
		final int pluginId = 16547;
		final Metrics metrics = new Metrics(main, pluginId);
		Core.log("bStats handling completed.");
	}

}
