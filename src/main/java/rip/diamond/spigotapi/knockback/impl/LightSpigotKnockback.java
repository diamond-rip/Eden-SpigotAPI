package rip.diamond.spigotapi.knockback.impl;

import com.ld.spigot.knockback.CraftKnockbackProfile;
import com.ld.spigot.knockback.KnockbackModule;
import org.bukkit.entity.Player;
import rip.diamond.practice.config.Language;
import rip.diamond.spigotapi.knockback.AbstractKnockback;
import rip.diamond.spigotapi.util.Reflection;

public class LightSpigotKnockback extends AbstractKnockback {
    @Override
    public void applyKnockback(Player player, String knockbackName) {
        CraftKnockbackProfile profile = KnockbackModule.getByName(knockbackName);

        if (profile == null) {
            Language.HOOK_ERROR_KNOCKBACK_NOT_FOUND.sendMessage(player);
            return;
        }

        final Object craftPlayerHandle = Reflection.method(player, "getHandle");
        Reflection.method(craftPlayerHandle, "setKnockback", profile);
    }
}
