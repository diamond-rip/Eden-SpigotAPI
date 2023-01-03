package rip.diamond.spigotapi.movementhandler.impl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import rip.diamond.spigotapi.SpigotAPI;
import rip.diamond.spigotapi.movementhandler.AbstractMovementHandler;
import rip.diamond.spigotapi.util.TriConsumer;

public class DefaultMovementHandler extends AbstractMovementHandler {
    @Override
    public void injectLocationUpdate(TriConsumer<Player, Location, Location> data) {
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onMove(PlayerMoveEvent event) {
                Player player = event.getPlayer();

                double fromX = event.getFrom().getX();
                double fromY = event.getFrom().getY();
                double fromZ = event.getFrom().getZ();

                double toX = event.getTo().getX();
                double toY = event.getTo().getY();
                double toZ = event.getTo().getZ();

                if (fromX != toX || fromY != toY || fromZ != toZ) {
                    data.accept(player, event.getFrom(), event.getTo());
                }
            }
        }, SpigotAPI.PLUGIN);
    }

    @Override
    public void injectRotationUpdate(TriConsumer<Player, Location, Location> data) {
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onMove(PlayerMoveEvent event) {
                Player player = event.getPlayer();

                double fromYaw = event.getFrom().getYaw();
                double fromPitch = event.getFrom().getPitch();

                double toYaw = event.getTo().getYaw();
                double toPitch = event.getTo().getPitch();

                if (fromYaw != toYaw || fromPitch != toPitch) {
                    data.accept(player, event.getFrom(), event.getTo());
                }
            }
        }, SpigotAPI.PLUGIN);
    }
}
