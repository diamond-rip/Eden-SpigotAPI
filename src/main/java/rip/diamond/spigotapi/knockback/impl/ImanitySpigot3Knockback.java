package rip.diamond.spigotapi.knockback.impl;

import dev.imanity.knockback.api.Knockback;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import rip.diamond.practice.config.Language;
import rip.diamond.spigotapi.knockback.AbstractKnockback;

public class ImanitySpigot3Knockback extends AbstractKnockback {
    @Override
    public void applyKnockback(Player player, String knockbackName) {
        Knockback knockback = Bukkit.imanity().getKnockbackService().getKnockbackByName(knockbackName);
        if (knockback == null) {
            Language.HOOK_ERROR_KNOCKBACK_NOT_FOUND.sendMessage(player);
            return;
        }
        Bukkit.imanity().getKnockbackService().setKnockback(player, knockback);
    }
}
