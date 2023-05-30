package rip.diamond.spigotapi.knockback.impl;

import eu.vortexdev.api.KnockbackAPI;
import eu.vortexdev.api.knockback.KnockbackProfile;
import org.bukkit.entity.Player;
import rip.diamond.practice.config.Language;
import rip.diamond.spigotapi.knockback.AbstractKnockback;

public class RocketSpigotKnockback extends AbstractKnockback {
    @Override
    public void applyKnockback(Player player, String knockbackName) {
        KnockbackProfile knockback = KnockbackAPI.getByName(knockbackName);
        if (knockback == null) {
            Language.HOOK_ERROR_KNOCKBACK_NOT_FOUND.sendMessage(player);
            return;
        }
        KnockbackAPI.applyKnockback(knockback, player);
    }
}
