package be.artex.rolesv5.api.role.roles.pacte;

import be.artex.rolesv5.api.camp.Camp;
import be.artex.rolesv5.api.role.Role;
import be.artex.rolesv5.api.role.item.Item;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class Bat extends Role {
    private static final ItemStack GUI_STACK = ItemBuilder.create(Material.QUARTZ)
            .addEnchant(Enchantment.ARROW_FIRE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .displayName(ChatColor.RED + "Démon Bat")
            .setLore(ChatColor.RESET + "Possibilité de " + ChatColor.AQUA + "voler" + ChatColor.RESET + ".")
            .build();

    @Override
    public String getName() {
        return "Démon Bat";
    }

    @Override
    public String getId() {
        return "pacte_bat";
    }

    @Override
    public PotionEffect[] getEffects() {
        return new PotionEffect[0];
    }

    @Override
    public Camp getCamp() {
        return Camp.PACTES;
    }

    @Override
    public int getMaxHealth() {
        return 16;
    }

    @Override
    public ItemStack getGUIStack() {
        return GUI_STACK;
    }

    @Override
    public void getOnKill(PlayerDeathEvent e) {

    }

    @Override
    public ChatColor getColor() {
        return ChatColor.RED;
    }

    @Override
    public int getPlacement() {
        return 20;
    }

    @Override
    public int getSwordSharpLvl() {
        return 3;
    }

    @Override
    public void onHit(EntityDamageByEntityEvent e) {

    }

    @Override
    public void onPlayerDeath(Player player) {
        player.setFlying(false);
        player.setAllowFlight(false);
    }

    @Override
    public void onAssign(Player player) {
        player.setAllowFlight(true);
        player.setFlying(true);
    }

    @Override
    public Item getItem() {
        return null;
    }
}
