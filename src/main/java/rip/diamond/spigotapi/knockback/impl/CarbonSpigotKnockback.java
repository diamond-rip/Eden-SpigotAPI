package rip.diamond.spigotapi.knockback.impl;

import org.bukkit.entity.Player;
import rip.diamond.spigotapi.knockback.AbstractKnockback;
import xyz.refinedev.spigot.api.knockback.KnockbackAPI;
import xyz.refinedev.spigot.knockback.KnockbackProfile;

public class CarbonSpigotKnockback extends AbstractKnockback {
    @Override
    public void applyKnockback(Player player, String knockbackName) {
        KnockbackProfile knockback = KnockbackAPI.getInstance().getProfile(knockbackName);
        if (knockback == null) {
            return;
        }
        KnockbackAPI.getInstance().setPlayerProfile(player, knockback);
    }
}
