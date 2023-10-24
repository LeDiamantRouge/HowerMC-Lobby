package fr.lediamantrouge.howermclobby.task;

import fr.lediamantrouge.howermclobby.Main;
import fr.lediamantrouge.howermclobby.manager.PlayerManager;
import fr.lediamantrouge.howermclobby.util.BarUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BossBarCycle extends BukkitRunnable {

    private Main main;
    public static int timer = 1200;

    public BossBarCycle(Main main) {
        this.main = main;
    }

    @Override
    public void run() {

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (timer == 1200) {
                BarUtils.removeBar(all);
                BarUtils.setBar(all, "§8§l» §fBienvenue " + PlayerManager.getPrefix(all) + " " + all.getName() + " §fsur §b§nplay.howermc.fr§f ! §8§l«", 100);
            }
            if (timer == 1000){
                BarUtils.removeBar(all);
                BarUtils.setBar(all, "§8§l» §fN'hésitez pas à rejoindre notre §bDiscord §7➠ §9/discord §f! §8§l«", 100);
            }
            if (timer == 800) {
                BarUtils.removeBar(all);
                BarUtils.setBar(all, "§8§l» §fVous pouvez acheter des §9Coins §7➠ §e/site §f! §8§l«", 100);
            }
            if (timer == 600) {
                BarUtils.removeBar(all);
                BarUtils.setBar(all, "§8§l» §fPour §bjouer§f, utilisez l'outil de §bNavigation §f! §8§l«", 100);
            }
            if (timer == 400) {
                BarUtils.removeBar(all);
                BarUtils.setBar(all, "§8§l» §fEn cas de problème contactez un §bmembre de l'équipe §f! §8§l«", 100);
            }
            if (timer == 200) {
                BarUtils.removeBar(all);
                BarUtils.setBar(all, "§8§l» §fUtilisez vos §cDollars §fdans la boutique pour obtenir des §ebonus §f! §8§l«", 100);
            }
        }
        timer = timer-200;
        if (timer == 0){
            cancel();
            timer = 1200;
            BossBarCycle start = new BossBarCycle(Main.getInstance());
            start.runTaskTimer(Main.getInstance(), 0, 200L);
        }

    }
}
