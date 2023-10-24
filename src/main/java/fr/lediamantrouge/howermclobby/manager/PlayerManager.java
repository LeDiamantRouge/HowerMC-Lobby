package fr.lediamantrouge.howermclobby.manager;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PlayerManager {

    public static String getPrefix(Player player) {
        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
        String prefix = Objects.requireNonNull(user.getCachedData().getMetaData().getPrefix()).replace("&", "§");
        return prefix.replace("&", "§");
    }

    public static int getDollars(Player player) {
        return -1;
    }

    public static int getCoins(Player player) {
        return -1;
    }

    public static int getRank(Player player) {
        return -1;
    }

    public static int getLevel(Player player) {
        return -1;
    }

    public static int getXp(Player player) {
        return -1;
    }

    public static int getXpMax(Player player) {
        return -1;
    }
}
