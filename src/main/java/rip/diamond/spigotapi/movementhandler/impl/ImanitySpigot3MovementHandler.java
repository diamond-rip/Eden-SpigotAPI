package rip.diamond.spigotapi.movementhandler.impl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.imanity.imanityspigot.movement.MovementHandler;
import org.imanity.imanityspigot.packet.wrappers.MovementPacketWrapper;
import rip.diamond.spigotapi.SpigotAPI;
import rip.diamond.spigotapi.movementhandler.AbstractMovementHandler;
import rip.diamond.spigotapi.util.TriConsumer;

public class ImanitySpigot3MovementHandler extends AbstractMovementHandler {

    @Override
    public void injectLocationUpdate(TriConsumer<Player, Location, Location> data) {
        MovementHandler movementHandler = new MovementHandler() {
            @Override
            public void onUpdateLocation(Player player, Location location, Location location1, MovementPacketWrapper movementPacketWrapper) {
                data.accept(player, location, location1);
            }

            @Override
            public void onUpdateRotation(Player player, Location location, Location location1, MovementPacketWrapper movementPacketWrapper) {

            }
        };
        Bukkit.imanity().getMovementService().registerMovementHandler(SpigotAPI.PLUGIN, movementHandler);
    }

    @Override
    public void injectRotationUpdate(TriConsumer<Player, Location, Location> data) {
        MovementHandler movementHandler = new MovementHandler() {
            @Override
            public void onUpdateLocation(Player player, Location location, Location location1, MovementPacketWrapper movementPacketWrapper) {

            }

            @Override
            public void onUpdateRotation(Player player, Location location, Location location1, MovementPacketWrapper movementPacketWrapper) {
                data.accept(player, location, location1);
            }
        };
        Bukkit.imanity().getMovementService().registerMovementHandler(SpigotAPI.PLUGIN, movementHandler);
    }
}
