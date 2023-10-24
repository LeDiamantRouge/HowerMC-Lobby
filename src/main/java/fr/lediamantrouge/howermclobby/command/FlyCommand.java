package fr.lediamantrouge.howermclobby.command;

import fr.lediamantrouge.howermclobby.util.TranslateBoolean;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (!p.hasPermission("howermc.flyplayer")) {
                    p.sendMessage("§cErreur: Vous n'avez pas les droits d'utilisation.");
                    return false;
                }
            }
            Player t = Bukkit.getPlayer(args[0]);
            if (t == null) {
                sender.sendMessage("§cErreur: Ce joueur n'est pas en ligne.");
                return false;
            }
            if (t.getAllowFlight()) {
                t.setAllowFlight(false);
                sender.sendMessage("§6§lFLYMODE §8❙ §fLe §bFlyMode §fest maintenant §cdésactivé §fpour §e" + t.getName() + "§f.");
            } else {
                t.setAllowFlight(true);
                sender.sendMessage("§6§lFLYMODE §8❙ §fLe §bFlyMode §fest maintenant §aactivé §fpour §e" + t.getName() + "§f.");
            }
        } else {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("howermc.fly")) {
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        p.sendMessage("§6§lFLYMODE §8❙ §fVous venez de §cdéactiver §fle §bFlyMode§f.");
                    } else {
                        p.setAllowFlight(true);
                        p.sendMessage("§6§lFLYMODE §8❙ §fVous venez d'§aactiver §fle §bFlyMode§f.");
                    }
                } else {
                    sender.sendMessage("§cErreur: Vous n'avez pas les droits d'utilisation.");
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 10.0F, 1.0F);
                }
            } else {
                sender.sendMessage("§cCommande réservé au joueur !");
            }
        }
        return false;
    }
}
