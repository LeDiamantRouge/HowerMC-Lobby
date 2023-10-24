package fr.lediamantrouge.howermclobby.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationUtils {

    public static Location decode(String str) {
        String[] strs = str.split(";");
        return new Location(Bukkit.getWorld(strs[0]), Double.parseDouble(strs[1]), Double.parseDouble(strs[2]), Double.parseDouble(strs[3]), Integer.parseInt(strs[4]), Integer.parseInt(strs[5]));
    }

    public static String encode(Location location) {
        String separator = ";";
        return
                location.getX() +
                        separator +
                        location.getY() +
                        separator +
                        location.getZ() +
                        separator +
                        location.getYaw() +
                        separator +
                        location.getPitch();
    }
}
