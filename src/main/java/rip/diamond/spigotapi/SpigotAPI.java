package rip.diamond.spigotapi;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;
import rip.diamond.spigotapi.knockback.AbstractKnockback;
import rip.diamond.spigotapi.movementhandler.AbstractMovementHandler;

@Getter
public final class SpigotAPI {

    public static SpigotAPI INSTANCE;
    public static JavaPlugin PLUGIN;

    @Setter private SpigotType spigotType;
    private AbstractKnockback knockback;
    private AbstractMovementHandler movementHandler;

    public SpigotAPI init(JavaPlugin plugin) {
        INSTANCE = this;
        PLUGIN = plugin;

        spigotType = SpigotType.get();
        knockback = SpigotType.getKnockback();
        movementHandler = SpigotType.getMovementHandler();

        return this;
    }

}
