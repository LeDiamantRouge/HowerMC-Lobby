package fr.lediamantrouge.howermclobby.listener;

import fr.lediamantrouge.howermclobby.gui.MainGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListeners implements Listener {

    @EventHandler
    public void onInteractEvent(PlayerInteractEvent e) {
        if (e.getItem() != null && e.getItem().getItemMeta().hasDisplayName() && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §6Menu §f§l▪ §7Clique §8§l«")) {
            new MainGUI(e.getPlayer()).open(true);
        }
    }
}
