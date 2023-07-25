package rip.diamond.spigotapi.knockback.impl;

import me.drizzy.ravespigot.knockback.KnockbackModule;
import me.drizzy.ravespigot.knockback.KnockbackProfile;
import org.bukkit.entity.Player;
import rip.diamond.practice.config.Language;
import rip.diamond.spigotapi.knockback.AbstractKnockback;
import rip.diamond.spigotapi.util.Reflection;

public class RaveSpigotKnockback extends AbstractKnockback {
    @Override
    public void applyKnockback(Player player, String knockbackName) {
        KnockbackProfile profile = KnockbackModule.INSTANCE.profiles.get(knockbackName);

        if (profile == null) {
            Language.HOOK_ERROR_KNOCKBACK_NOT_FOUND.sendMessage(player);
            return;
        }

        final Object craftPlayerHandle = Reflection.method(player, "getHandle");
        Reflection.method(craftPlayerHandle, "setKnockback", profile);
    }
}
