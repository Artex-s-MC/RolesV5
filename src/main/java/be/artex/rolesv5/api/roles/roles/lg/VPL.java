package be.artex.rolesv5.api.roles.roles.lg;

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

public class VPL extends Role {
    private static final PotionEffect[] EFFECTS = {
            new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0),
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0)
    };

    private static final ItemStack GUI_STACK = ItemBuilder.create(Material.QUARTZ)
            .addEnchant(Enchantment.ARROW_FIRE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .displayName(ChatColor.RED + "Vilain petit loup")
            .setLore(ChatColor.RESET + "" + ChatColor.AQUA + "Vitesse " + ChatColor.RESET + "de façon permanente.", ChatColor.RESET + "" + ChatColor.RED + "Force " + ChatColor.RESET + "de façon permanente.")
            .build();

    @Override
    public String getName() {
        return "Vilain petit loup";
    }

    @Override
    public String getId() {
        return "lg_vpl";
    }

    @Override
    public PotionEffect[] getEffects() {
        return EFFECTS;
    }

    @Override
    public Camp getCamp() {
        return Camp.LOUP;
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
}
