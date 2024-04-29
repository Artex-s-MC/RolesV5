package be.artex.rolesv5.api.roles.roles.solo;

import be.artex.rolesv5.api.camp.Camp;
import be.artex.rolesv5.api.roles.Role;
import be.artex.rolesv5.api.roles.Roles;
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

import java.util.HashMap;
import java.util.UUID;

public class Imitateur extends Role {
    public static final HashMap<UUID, String> stolenRole = new HashMap<>();;

    private static final PotionEffect[] EFFECTS = {
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0)
    };

    private static final ItemStack GUI_STACK = ItemBuilder.create(Material.STONE_SWORD)
            .addEnchant(Enchantment.ARROW_FIRE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .displayName(ChatColor.GOLD + "Imitateur")
            .setLore(ChatColor.RESET + "" + ChatColor.RED + "Force " + ChatColor.RESET + "avant son premier kill.", ChatColor.RESET + "A chaque kill il peut " + ChatColor.DARK_PURPLE + "voler " + ChatColor.RESET + "le role de sa victime.")
            .build();

    @Override
    public String getName() {
        return "Imitateur";
    }

    @Override
    public String getId() {
        return "imitateur";
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
        return 20;
    }

    @Override
    public ItemStack getGUIStack() {
        return GUI_STACK;
    }

    @Override
    public void getOnKill(PlayerDeathEvent e) {
        Role deathPlayerRole = Roles.getPlayerRole(e.getEntity());
        Player killer = e.getEntity().getKiller();

        for (PotionEffect pe : killer.getActivePotionEffects())
            killer.removePotionEffect(pe.getType());

        for (PotionEffect pe : deathPlayerRole.getEffects())
            killer.addPotionEffect(pe);

        killer.setMaxHealth(deathPlayerRole.getMaxHealth());

        killer.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + "Vous avez volé le rôle: " + ChatColor.BOLD + deathPlayerRole.getName());

        stolenRole.put(killer.getUniqueId(), deathPlayerRole.getId());
    }

    @Override
    public ChatColor getColor() {
        return ChatColor.GOLD;
    }

    @Override
    public int getPlacement() {
        return 22;
    }

    @Override
    public int getSwordSharpLvl() {
        return 4;
    }

    @Override
    public void onHit(EntityDamageByEntityEvent e) {
        if (stolenRole.get(e.getDamager().getUniqueId()) != null)
            Roles.getRole(stolenRole.get(e.getDamager().getUniqueId())).onHit(e);
    }
}
