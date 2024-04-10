package be.artex.rolesv5.api.roles;

import be.artex.rolesv5.api.camp.Camp;
import com.avaje.ebean.validation.NotNull;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Random;

public abstract class Role {
    public void assign(Player player) {
        // set role
        Roles.playerRole.put(player.getUniqueId(), this.getId());

        // effects
        for (PotionEffect pe : getEffects())
            player.addPotionEffect(pe);

        // attributes
        player.setMaxHealth(getMaxHealth());
        player.setGameMode(GameMode.SURVIVAL);

        // items
        player.getInventory().clear();
        Roles.givePlayerGear(player.getInventory(), null);

        // tp
        int x = new Random().nextInt(40);
        int z = new Random().nextInt(40);

        player.teleport(new Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt(x, z), z));

    }


    @NotNull
    public abstract String getName();

    @NotNull
    public abstract String getId();

    public abstract PotionEffect[] getEffects();

    @NotNull
    public abstract Camp getCamp();

    public abstract int getMaxHealth();

    @NotNull
    public abstract ItemStack getGUIStack();

    public abstract void getOnKill();

    @NotNull
    public abstract ChatColor getColor();

    @NotNull
    public abstract int getPlacement();


}
