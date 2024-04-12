package be.artex.rolesv5.api.roles;

import be.artex.rolesv5.api.camp.Camp;
import com.avaje.ebean.validation.NotNull;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Random;

public abstract class Role {
    public void assign(Player player) {
        // set role
        Roles.setPlayerRole(player, this);

        // effects
        for (PotionEffect pe : getEffects())
            player.addPotionEffect(pe);

        // attributes
        player.setMaxHealth(getMaxHealth());
        player.setHealth(getMaxHealth());
        player.setGameMode(GameMode.SURVIVAL);

        // items
        player.getInventory().clear();
        Roles.givePlayerGear(player.getInventory(), getSwordSharpLvl());

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

    public abstract void getOnKill(PlayerDeathEvent e);

    @NotNull
    public abstract ChatColor getColor();

    @NotNull
    public abstract int getPlacement();

    @NotNull
    public abstract int getSwordSharpLvl();


}
