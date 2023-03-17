package rip.diamond.spigotapi.movementhandler;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import rip.diamond.spigotapi.util.TriConsumer;

public abstract class AbstractMovementHandler {

    public abstract void injectLocationUpdate(TriConsumer<Player, Location, Location> data);

    public abstract void injectRotationUpdate(TriConsumer<Player, Location, Location> data);

    public abstract void uninject();

}
