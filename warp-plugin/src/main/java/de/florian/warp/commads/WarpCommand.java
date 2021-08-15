package de.florian.warp.commads;

import de.florian.warp.warp.WarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (WarpManager.getWarp(args[0]) != null) {
                    player.teleport(WarpManager.getWarp(args[0]));
                    player.sendMessage("§aDu wurdest zu dem Warp " + args[0] + " teleportiert!");
                } else {
                    player.sendMessage("§cDieser Warp konnte nicht gefunden werden!");
                }
            } else if (args.length == 2) {
                if (!player.hasPermission("minecraft.*")) {
                    player.sendMessage("§cDu verfügst nicht über die Nötigen Rechte (minecraft.*)");
                    return false;
                }
                if (args[0].equalsIgnoreCase("add")) {
                    if (WarpManager.getWarp(args[1]) == null) {
                        WarpManager.createWarp(args[1], player.getLocation());
                        player.sendMessage("§aDu hast den Warp " + args[1] + " erstellt!");
                    } else {
                        player.sendMessage("§cDiesen Warp gibt es schon!");
                    }
                } else if (args[0].equalsIgnoreCase("delete")) {
                    if (WarpManager.getWarp(args[1]) != null) {
                        WarpManager.deleteWarp(args[1]);
                        player.sendMessage("§aDu hast den Warp " + args[1] + " gelöscht!");
                    } else {
                        player.sendMessage("§cDieser Warp konnte nicht gefunden werden!");
                    }
                }
            }
        }else {
            sender.sendMessage("Um das zu tun musst du ein Spieler sein!");
        }
        return false;
    }
    }