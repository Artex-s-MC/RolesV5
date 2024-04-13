package be.artex.rolesv5.api.roles.roles.solo;

import be.artex.rolesv5.api.camp.Camp;
import be.artex.rolesv5.api.roles.Role;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LGS extends Role {
    private static final PotionEffect[] EFFECTS = {
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0)
    };

    private static final ItemStack GUI_STACK = ItemBuilder.create(Material.ROTTEN_FLESH)
            .addEnchant(Enchantment.ARROW_FIRE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .displayName(ChatColor.RED + "Loup Garou Solitaire")
            .setLore(ChatColor.RESET + "" + ChatColor.LIGHT_PURPLE + "14 coeurs " + ChatColor.RESET + "de façon permanente.", ChatColor.RESET + "" + ChatColor.RED + "Force " + ChatColor.RESET + "de façon permanente.")
            .build();

    @Override
    public String getName() {
        return "Loup Garou Solitaire";
    }

    @Override
    public String getId() {
        return "lg_lgs";
    }

    @Override
    public PotionEffect[] getEffects() {
        return EFFECTS;
    }

    @Override
    public Camp getCamp() {
        return Camp.SOLO;
    }

    @Override
    public int getMaxHealth() {
        return 28;
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
        return ChatColor.GOLD;
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
}
