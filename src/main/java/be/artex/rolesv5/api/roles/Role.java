package be.artex.rolesv5.api.roles;

import be.artex.rolesv5.api.camp.Camp;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public abstract class Role {
    public void assign(Player player) {
        // set role
        Roles.playerRole.put(player.getUniqueId(), this.getId());

        // effects
        for (PotionEffect pe : getEffects())
            player.addPotionEffect(pe);

        // max health
        player.setMaxHealth(getMaxHealth());

        // gear
        Roles.givePlayerGear(player.getInventory());



    }


    public abstract String getName();
    public abstract String getId();
    public abstract PotionEffect[] getEffects();
    public abstract Camp getCamp();
    public abstract int getMaxHealth();
    public abstract ItemStack getGUIStack();


}
