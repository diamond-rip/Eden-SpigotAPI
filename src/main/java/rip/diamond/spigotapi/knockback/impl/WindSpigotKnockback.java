package rip.diamond.spigotapi.knockback.impl;

import dev.cobblesword.nachospigot.knockback.KnockbackConfig;
import dev.cobblesword.nachospigot.knockback.KnockbackProfile;
import org.bukkit.entity.Player;
import rip.diamond.practice.Language;
import rip.diamond.spigotapi.knockback.AbstractKnockback;
import rip.diamond.spigotapi.util.Reflection;

public class WindSpigotKnockback extends AbstractKnockback {
    @Override
    public void applyKnockback(Player player, String knockbackName) {
        KnockbackProfile profile = KnockbackConfig.getKbProfileByName(knockbackName);

        if (profile == null) {
            Language.HOOK_ERROR_KNOCKBACK_NOT_FOUND.sendMessage(player);
            return;
        }
        Reflection.method(player, "setKnockbackProfile", profile);
    }
}
