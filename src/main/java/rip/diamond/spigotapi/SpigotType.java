package rip.diamond.spigotapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import rip.diamond.spigotapi.knockback.AbstractKnockback;
import rip.diamond.spigotapi.knockback.impl.*;
import rip.diamond.spigotapi.movementhandler.AbstractMovementHandler;
import rip.diamond.spigotapi.movementhandler.impl.CarbonSpigotMovementHandler;
import rip.diamond.spigotapi.movementhandler.impl.DefaultMovementHandler;
import rip.diamond.spigotapi.movementhandler.impl.FoxSpigotMovementHandler;
import rip.diamond.spigotapi.movementhandler.impl.ImanitySpigot3MovementHandler;

import java.util.Arrays;

@AllArgsConstructor
public enum SpigotType {

    SPIGOT("org.spigotmc.SpigotConfig", DefaultKnockback.class, DefaultMovementHandler.class),
    IMANITY_SPIGOT_3("org.imanity.imanityspigot.ImanitySpigot", ImanitySpigot3Knockback.class, ImanitySpigot3MovementHandler.class),
    CARBON_SPIGOT("xyz.refinedev.spigot.config.CarbonConfig", CarbonSpigotKnockback.class, CarbonSpigotMovementHandler.class),
    FOX_SPIGOT("pt.foxspigot.jar.FoxSpigot", FoxSpigotKnockback.class, FoxSpigotMovementHandler.class),
    WIND_SPIGOT("ga.windpvp.windspigot.WindSpigot", WindSpigotKnockback.class, DefaultMovementHandler.class), //Although WindSpigot has MovementHandler (In WindSpigot it is called MovementListener), it is not implement in the latest version of release, so we have to use default
    ;

    private final String package_;
    private final Class<?> knockback;
    private final Class<?> movementHandler;

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

    @SneakyThrows
    public static AbstractKnockback getKnockback() {
        return (AbstractKnockback) get().knockback.newInstance();
    }

    @SneakyThrows
    public static AbstractMovementHandler getMovementHandler() {
        return (AbstractMovementHandler) get().movementHandler.newInstance();
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
