package rip.diamond.spigotapi.movementhandler.impl;

import me.drizzy.ravespigot.RaveSpigot;
import me.drizzy.ravespigot.handler.MovementHandler;
import net.minecraft.server.v1_8_R3.PacketPlayInFlying;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import rip.diamond.spigotapi.movementhandler.AbstractMovementHandler;
import rip.diamond.spigotapi.util.TriConsumer;

public class RaveSpigotMovementHandler extends AbstractMovementHandler {

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
        RaveSpigot.getInstance().addMovementHandler(movementHandler);
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
        RaveSpigot.getInstance().addMovementHandler(movementHandler);
    }
}
