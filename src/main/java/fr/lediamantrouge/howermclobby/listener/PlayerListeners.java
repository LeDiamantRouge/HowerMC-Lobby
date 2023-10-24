package fr.lediamantrouge.howermclobby.listener;

import fr.lediamantrouge.diamondapi.DiamondAPI;
import fr.lediamantrouge.howermclobby.Main;
import fr.lediamantrouge.howermclobby.manager.PlayerManager;
import fr.lediamantrouge.howermclobby.util.BarUtils;
import fr.lediamantrouge.howermclobby.util.TitleUtils;
import fr.lediamantrouge.howermclobby.util.itembuilder.CreateSkull;
import fr.lediamantrouge.howermclobby.util.itembuilder.ItemBuilder;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class PlayerListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String prefix = PlayerManager.getPrefix(player);
        DiamondAPI.get().getChatManager().setPlayerFormat(player, prefix + "%player%§f: %message%");
        e.setJoinMessage("");
        DiamondAPI.get().getTagManager().setTagPrefix(player, prefix);

        player.teleport(Main.LOBBY_LOCATION);

        player.playSound(player.getLocation(), Sound.LEVEL_UP, 10.0F, 1.0F);
        TitleUtils.sendTitle(player, 20, 50, 20, "§8✪ §c§lHowerMC §8✪", "§8§l» §eBienvenue " + prefix + " " + player.getName() + " §e! §8§l«");
        BarUtils.setBar(player, "§8§l» §fBienvenue " + prefix + player.getName() + " §fsur §b§nplay.howermc.fr§f ! §8§l«", 100);

        if (player.hasPermission("howermc.joinmessage")) {
            player.getWorld().strikeLightning(player.getLocation());
            Bukkit.broadcastMessage(Main.PREFIX + prefix + player.getName() + " §aà rejoint le lobby !");
        }

        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);
        player.getInventory().clear();
        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);

        player.getInventory().setItem(0, new ItemBuilder(Material.BARRIER).setDisplayName("§8§l» §cChargement §8§l«").build(false));
        player.getInventory().setItem(1, new ItemBuilder(Material.BARRIER).setDisplayName("§8§l» §cChargement §8§l«").build(false));
        player.getInventory().setItem(2, new ItemBuilder(Material.BARRIER).setDisplayName("§8§l» §cChargement §8§l«").build(false));
        player.getInventory().setItem(3, new ItemBuilder(Material.BARRIER).setDisplayName("§8§l» §cChargement §8§l«").build(false));
        player.getInventory().setItem(4, new ItemBuilder(Material.BARRIER).setDisplayName("§8§l» §cChargement §8§l«").build(false));
        player.getInventory().setItem(5, new ItemBuilder(Material.BARRIER).setDisplayName("§8§l» §cChargement §8§l«").build(false));
        player.getInventory().setItem(6, new ItemBuilder(Material.BARRIER).setDisplayName("§8§l» §cChargement §8§l«").build(false));
        player.getInventory().setItem(7, new ItemBuilder(Material.BARRIER).setDisplayName("§8§l» §cChargement §8§l«").build(false));
        player.getInventory().setItem(8, new ItemBuilder(Material.BARRIER).setDisplayName("§8§l» §cChargement §8§l«").build(false));
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            player.getInventory().clear();
            player.getInventory().setItem(2, new ItemBuilder(new CreateSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzY5MTk2YjMzMGM2Yjg5NjJmMjNhZDU2MjdmYjZlY2NlNDcyZWFmNWM5ZDQ0Zjc5MWY2NzA5YzdkMGY0ZGVjZSJ9fX0=").toItemStack()).setDisplayName("§8§l» §6Menu §f§l▪ §7Clique §8§l«").build(false));
            player.getInventory().setItem(4, new ItemBuilder(new CreateSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM2ZTk0ZjZjMzRhMzU0NjVmY2U0YTkwZjJlMjU5NzYzODllYjk3MDlhMTIyNzM1NzRmZjcwZmQ0ZGFhNjg1MiJ9fX0=").toItemStack()).setDisplayName("§8§l» §6Boutique §f§l▪ §7Clique §8§l«").build(false));
            player.getInventory().setItem(6, new ItemBuilder(new CreateSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWNiN2MyMWNjNDNkYzE3Njc4ZWU2ZjE2NTkxZmZhYWIxZjYzN2MzN2Y0ZjZiYmQ4Y2VhNDk3NDUxZDc2ZGI2ZCJ9fX0=").toItemStack()).setDisplayName("§8§l» §6Sélection de lobby §f§l▪ §7Clique §8§l«").build(false));
            if (player.hasPermission("howermc.fly")){
                player.setAllowFlight(true);
            }
        }, 5L);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage("");
        BarUtils.removeBar(e.getPlayer());
    }
}
