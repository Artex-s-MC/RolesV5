package be.artex.rolesv5.api.role.roles.sonic;

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
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Knuckles extends Role {
    private static final PotionEffect[] EFFECTS = {
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0),
    };

    private static final ItemStack GUI_STACK = ItemBuilder.create(Material.BLAZE_POWDER)
            .addEnchant(Enchantment.ARROW_FIRE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .displayName(ChatColor.BLUE + "Knuckles")
            .setLore(ChatColor.RESET + "" + ChatColor.DARK_PURPLE + "15% " + ChatColor.GRAY + "de chance de mettre en " + ChatColor.GOLD + "feu" + ChatColor.GRAY + ".", ChatColor.RESET + "" + ChatColor.RED + "Force " + ChatColor.GRAY + "de façon permanente.")
            .build();

    @Override
    public String getName() {
        return "Knuckles";
    }

    @Override
    public String getId() {
        return "sonic_knuckles";
    }

    @Override
    public PotionEffect[] getEffects() {
        return EFFECTS;
    }

    @Override
    public Camp getCamp() {
        return Camp.SONIC_TEAM;
    }

    @Override
    public int getMaxHealth() {
        return 20;
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
        return ChatColor.BLUE;
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
        if (new Random().nextInt(100) <= 15) {
            e.getEntity().setFireTicks(15 * 20);
        }
    }

    @Override
    public void onPlayerDeath(Player player) {

    }

    @Override
    public void onAssign(Player player) {

    }

    @Override
    public Item getItem() {
        return null;
    }
}
