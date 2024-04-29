package be.artex.rolesv5.api.roles.roles.slayer;

import be.artex.rolesv5.api.camp.Camp;
import be.artex.rolesv5.api.roles.Role;
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

public class Kanae extends Role {
    private static final PotionEffect[] EFFECTS = {
    };

    private static final ItemStack GUI_STACK = ItemBuilder.create(Material.DIAMOND_SWORD)
            .addEnchant(Enchantment.ARROW_FIRE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .displayName(ChatColor.GREEN + "Kanae")
            .setLore(ChatColor.RESET + "A chaque coup Kanae à une chance de donner " + ChatColor.DARK_GRAY + "des effets négatifs" + ChatColor.RESET + ".")
            .build();

    @Override
    public String getName() {
        return "Kanae";
    }

    @Override
    public String getId() {
        return "slayer_kanae";
    }

    @Override
    public PotionEffect[] getEffects() {
        return EFFECTS;
    }

    @Override
    public Camp getCamp() {
        return Camp.SLAYER;
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
        return ChatColor.GREEN;
    }

    @Override
    public int getPlacement() {
        return 20;
    }

    @Override
    public int getSwordSharpLvl() {
        return 3;
    }

    private static boolean weakness(Player player) {
        return player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 15*20, 0));
    }

    private static boolean slow(Player player) {
        return player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 12*20, 0));
    }

    private static boolean poison(Player player) {
        return player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10*20, 0));
    }

    private static void fire(Player player) {
       player.setFireTicks(20*17);
    }

    private static void damageToHeal(Player player, double damage) {
        if (player.getHealth() + damage > player.getMaxHealth()) {
            player.setHealth(player.getHealth());
            return;
        }

        player.setHealth(player.getHealth() + damage);
    }


    @Override
    public void onHit(EntityDamageByEntityEvent e) {
        double random = new Random().nextInt(100);
        random++;

        if (!new Random().nextBoolean())
            return;

        if (!new Random().nextBoolean())
            return;

        if (random <= 25)
            return;

        if (random <= 50) {
            weakness((Player) e.getEntity());
            e.getDamager().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + "Vous avez donné l'effet " + ChatColor.BOLD + "Faiblesse I" + ChatColor.AQUA + " à " + ChatColor.BOLD + e.getEntity().getName() + ChatColor.AQUA + ".");
            e.getEntity().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + ChatColor.BOLD + "Kanae " + ChatColor.AQUA + "vient de vous mettre l'effet "  + ChatColor.BOLD + "Faiblesse I" + ChatColor.AQUA + ".");
            return;
        }

        if (random <= 70) {
            slow((Player) e.getEntity());
            e.getDamager().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + "Vous avez donné l'effet " + ChatColor.BOLD + "Lenteur I" + ChatColor.AQUA + " à " + ChatColor.BOLD + e.getEntity().getName() + ChatColor.AQUA + ".");
            e.getEntity().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + ChatColor.BOLD + "Kanae " + ChatColor.AQUA + "vient de vous mettre l'effet "  + ChatColor.BOLD + "Lenteur I" + ChatColor.AQUA + ".");
            return;
        }

        if (random <= 85) {
            poison((Player) e.getEntity());
            e.getDamager().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + "Vous avez donné l'effet " + ChatColor.BOLD + "Poison I" + ChatColor.AQUA + " à " + ChatColor.BOLD + e.getEntity().getName() + ChatColor.AQUA + ".");
            e.getEntity().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + ChatColor.BOLD + "Kanae " + ChatColor.AQUA + "vient de vous mettre l'effet "  + ChatColor.BOLD + "Poison I" + ChatColor.AQUA + ".");
            return;
        }

        if (random <= 92) {
            e.getEntity().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + ChatColor.BOLD + "Kanae " + ChatColor.AQUA + "vous a " + ChatColor.BOLD + "enflammé" + ChatColor.AQUA + ".");
            e.getDamager().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + "Vous avez " + ChatColor.BOLD + "enflammé " + e.getEntity().getName() + ChatColor.AQUA + ".");
            fire((Player) e.getEntity());
            return;
        }

        if (random <= 99) {
            e.getDamager().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + "Vous venez de gagner " + ChatColor.BOLD + (e.getDamage() / 2) + " coeurs" + ChatColor.AQUA + ".");
            damageToHeal((Player) e.getEntity(), e.getDamage());
            return;
        }

        if (random == 100) {
            e.getEntity().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + ChatColor.BOLD + "Kanae " + ChatColor.AQUA + "vient de vous mettre les effets " + ChatColor.BOLD + "Poison I" + ChatColor.AQUA + ", " + ChatColor.BOLD + "Faiblesse I" + ChatColor.AQUA + " et " + ChatColor.BOLD + "Lenteur I" + ChatColor.AQUA + ".");
            e.getDamager().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + "Vous avez donné les effets" + ChatColor.BOLD + "Poison I" + ChatColor.AQUA + ", " + ChatColor.BOLD + "Faiblesse I" + ChatColor.AQUA + " et " + ChatColor.BOLD + "Lenteur I" + ChatColor.AQUA + " à " + ChatColor.BOLD + e.getEntity().getName() + ChatColor.AQUA + ".");
            poison((Player) e.getEntity());
            weakness((Player) e.getEntity());
            slow((Player) e.getEntity());
        }


    }
}
