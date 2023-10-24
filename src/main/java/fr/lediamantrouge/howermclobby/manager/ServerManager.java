package fr.lediamantrouge.howermclobby.manager;

import fr.lediamantrouge.servermanager.CommonMain;
import org.bukkit.Bukkit;

public class ServerManager {

    public String getName() {
        return CommonMain.getInstance().getServerManager().getServerByName(Bukkit.getMotd()).getDisplayName();
    }

    public int getPlayers() {
        return Bukkit.getOnlinePlayers().size();
    }

    public int getMaxPlayers() {
        return Bukkit.getMaxPlayers();
    }
}
