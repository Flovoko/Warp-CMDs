package de.florian.warp.warp;

import de.florian.warp.main.WarpMain;
import org.bukkit.Location;

public class WarpManager {

    public static Location getWarp(String name){
        return WarpMain.getCfg().getConfiguration().getLocation(name);
    }

    public static void createWarp(String name, Location location){
        WarpMain.getCfg().set(name, location);
        WarpMain.getCfg().save();
    }

    public static void deleteWarp(String name){
        WarpMain.getCfg().set(name, null);
        WarpMain.getCfg().save();
    }
}
