package rip.diamond.spigotapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import rip.diamond.spigotapi.knockback.AbstractKnockback;
import rip.diamond.spigotapi.knockback.impl.CarbonSpigotKnockback;
import rip.diamond.spigotapi.knockback.impl.DefaultKnockback;
import rip.diamond.spigotapi.knockback.impl.FoxSpigotKnockback;
import rip.diamond.spigotapi.knockback.impl.ImanitySpigot3Knockback;
import rip.diamond.spigotapi.movementhandler.AbstractMovementHandler;
import rip.diamond.spigotapi.movementhandler.impl.CarbonSpigotMovementHandler;
import rip.diamond.spigotapi.movementhandler.impl.DefaultMovementHandler;
import rip.diamond.spigotapi.movementhandler.impl.FoxSpigotMovementHandler;
import rip.diamond.spigotapi.movementhandler.impl.ImanitySpigot3MovementHandler;

import java.util.Arrays;

@AllArgsConstructor
public enum SpigotType {

    SPIGOT("org.spigotmc.SpigotConfig", new DefaultKnockback(), new DefaultMovementHandler()),
    IMANITY_SPIGOT_3("org.imanity.imanityspigot.ImanitySpigot", new ImanitySpigot3Knockback(), new ImanitySpigot3MovementHandler()),
    CARBON_SPIGOT("xyz.refinedev.spigot.config.CarbonConfig", new CarbonSpigotKnockback(), new CarbonSpigotMovementHandler()),
    FOX_SPIGOT("pt.foxspigot.jar.FoxSpigot", new FoxSpigotKnockback(), new FoxSpigotMovementHandler()),
    ;

    private final String package_;
    @Getter private final AbstractKnockback knockback;
    @Getter private final AbstractMovementHandler movementHandler;

    public String getPackage() {
        return package_;
    }

    /**
     * Detect which spigot is being used and initialize
     * @author Drizzy
     */
    public static SpigotType get() {
        return Arrays
                .stream(SpigotType.values())
                .filter(type -> !type.equals(SpigotType.SPIGOT) && check(type.getPackage()))
                .findFirst()
                .orElse(SpigotType.SPIGOT);
    }

    public static boolean check(String string) {
        try {
            Class.forName(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
