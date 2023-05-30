package rip.diamond.spigotapi.movementhandler.impl;

import eu.vortexdev.api.SpigotAPI;
import eu.vortexdev.api.protocol.MovementListenerAdapter;
import net.minecraft.server.v1_8_R3.PacketPlayInFlying;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import rip.diamond.spigotapi.movementhandler.AbstractMovementHandler;
import rip.diamond.spigotapi.util.TriConsumer;

public class RocketSpigotMovementHandler extends AbstractMovementHandler {
    @Override
    public void injectLocationUpdate(TriConsumer<Player, Location, Location> data) {
        MovementListenerAdapter movementListenerAdapter = new MovementListenerAdapter() {
            @Override
            public void onUpdateLocation(Player player, Location from, Location to, PacketPlayInFlying packet) {
                data.accept(player, from, to);
            }
        };
        SpigotAPI.addMovementListener(movementListenerAdapter);
    }

    @Override
    public void injectRotationUpdate(TriConsumer<Player, Location, Location> data) {
        MovementListenerAdapter movementListenerAdapter = new MovementListenerAdapter() {
            @Override
            public void onUpdateRotation(Player player, Location from, Location to, PacketPlayInFlying packet) {
                data.accept(player, from, to);
            }
        };
        SpigotAPI.addMovementListener(movementListenerAdapter);
    }
}
