package rip.diamond.spigotapi.knockback.impl;

import org.bukkit.entity.Player;
import pt.foxspigot.jar.knockback.KnockbackModule;
import pt.foxspigot.jar.knockback.KnockbackProfile;
import rip.diamond.practice.Language;
import rip.diamond.spigotapi.knockback.AbstractKnockback;
import rip.diamond.spigotapi.util.Reflection;

public class FoxSpigotKnockback extends AbstractKnockback {
    @Override
    public void applyKnockback(Player player, String knockbackName) {
        KnockbackProfile profile = KnockbackModule.getByName(knockbackName);

        if (profile == KnockbackModule.getDefault()) {
            Language.HOOK_ERROR_KNOCKBACK_NOT_FOUND.sendMessage(player);
            return;
        }

        final Object craftPlayerHandle = Reflection.method(player, "getHandle");
        Reflection.method(craftPlayerHandle, "setKnockback", profile);
    }
}
