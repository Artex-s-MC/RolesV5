package be.artex.rolesv5.api.roles.roles;

import be.artex.rolesv5.api.camp.Camp;
import be.artex.rolesv5.api.roles.Role;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Inosuke extends Role {
    private static final PotionEffect[] EFFECTS = {
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0)
    };

    private static final ItemStack GUI_STACK = ItemBuilder.create(Material.PORK)
            .addEnchant(Enchantment.ARROW_FIRE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .displayName(ChatColor.GREEN + "Inosuke")
            .build();


    @Override
    public String getName() {
        return "Inosuke";
    }

    @Override
    public String getId() {
        return "slayer1";
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
}
