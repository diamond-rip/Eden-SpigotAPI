package rip.diamond.spigotapi.movementhandler.impl;

import net.minecraft.server.v1_8_R3.PacketPlayInFlying;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import rip.diamond.spigotapi.SpigotAPI;
import rip.diamond.spigotapi.movementhandler.AbstractMovementHandler;
import rip.diamond.spigotapi.util.TriConsumer;
import xyz.refinedev.spigot.api.handlers.PacketAPI;
import xyz.refinedev.spigot.api.handlers.impl.MovementHandler;

import java.util.ArrayList;
import java.util.List;

public class CarbonSpigotMovementHandler extends AbstractMovementHandler {

    private final List<MovementHandler> movementHandlers = new ArrayList<>();

    @Override
    public void injectLocationUpdate(TriConsumer<Player, Location, Location> data) {
        MovementHandler movementHandler = new MovementHandler() {
            @Override
            public void handleUpdateLocation(Player player, Location location, Location location1, PacketPlayInFlying packetPlayInFlying) {
                data.accept(player, location, location1);
            }

            @Override
            public void handleUpdateRotation(Player player, Location location, Location location1, PacketPlayInFlying packetPlayInFlying) {

            }
        };
        PacketAPI.getInstance().registerMovementHandler(SpigotAPI.PLUGIN, movementHandler);
        movementHandlers.add(movementHandler);
    }

    @Override
    public void injectRotationUpdate(TriConsumer<Player, Location, Location> data) {
        MovementHandler movementHandler = new MovementHandler() {
            @Override
            public void handleUpdateLocation(Player player, Location location, Location location1, PacketPlayInFlying packetPlayInFlying) {

            }

            @Override
            public void handleUpdateRotation(Player player, Location location, Location location1, PacketPlayInFlying packetPlayInFlying) {
                data.accept(player, location, location1);
            }
        };
        PacketAPI.getInstance().registerMovementHandler(SpigotAPI.PLUGIN, movementHandler);
        movementHandlers.add(movementHandler);
    }
}
