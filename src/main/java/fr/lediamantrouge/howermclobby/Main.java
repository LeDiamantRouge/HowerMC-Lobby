package fr.lediamantrouge.howermclobby;

import fr.kotlini.supragui.InvHandler;
import fr.lediamantrouge.diamondapi.DiamondAPI;
import fr.lediamantrouge.howermclobby.command.FlyCommand;
import fr.lediamantrouge.howermclobby.command.MenuCommand;
import fr.lediamantrouge.howermclobby.command.SpawnCommand;
import fr.lediamantrouge.howermclobby.listener.DisableListeners;
import fr.lediamantrouge.howermclobby.listener.InteractListeners;
import fr.lediamantrouge.howermclobby.listener.PlayerListeners;
import fr.lediamantrouge.howermclobby.task.BossBarCycle;
import fr.lediamantrouge.howermclobby.util.LocationUtils;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Main extends JavaPlugin {

    public static Location LOBBY_LOCATION;
    public static String PREFIX = "§6§lLOBBY §8❙ ";

    @Getter
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        getConfig().options().copyDefaults(true);

        LOBBY_LOCATION = LocationUtils.decode(getConfig().getString("lobby-location"));

        Bukkit.getPluginManager().registerEvents(new PlayerListeners(), this);
        Bukkit.getPluginManager().registerEvents(new DisableListeners(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListeners(), this);

        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("menu").setExecutor(new MenuCommand());

        BossBarCycle startBoosBar = new BossBarCycle(this);
        startBoosBar.runTaskTimer(this, 0, 200L);

        DiamondAPI.get().getChatManager().setChatFormat("§7%player%§f: %message%");

        InvHandler.register(this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
