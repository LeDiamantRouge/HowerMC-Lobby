package fr.lediamantrouge.howermclobby.command;

import fr.lediamantrouge.howermclobby.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        player.teleport(Main.LOBBY_LOCATION);
        player.sendMessage(Main.PREFIX + "§6Téléportation au spawn...");
        return false;
    }
}
