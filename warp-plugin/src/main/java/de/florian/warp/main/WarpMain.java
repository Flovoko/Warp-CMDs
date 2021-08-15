package de.florian.warp.main;

import de.florian.warp.commads.WarpCommand;
import de.florian.warp.util.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class WarpMain extends JavaPlugin{
    private static Config cfg;
    @Override
    public void onEnable() {
        getCommand("warp").setExecutor(new WarpCommand());
        cfg = new Config("warps.yml", getDataFolder());
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Config getCfg() {
        return cfg;
    }
}
