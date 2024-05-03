package be.artex.rolesv5.api.role.roles.akatsuki;

import be.artex.rolesv5.api.camp.Camp;
import be.artex.rolesv5.api.role.Role;
import be.artex.rolesv5.api.role.item.Item;
import be.artex.rolesv5.api.role.item.items.HakkeItem;
import be.artex.rolesv5.api.role.item.items.SusanoItem;
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

public class Itachi extends Role {
    private static final PotionEffect[] EFFECTS = {
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0),
            new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0),
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0)
    };

    private static final ItemStack GUI_STACK = ItemBuilder.create(Material.IRON_SWORD)
            .addEnchant(Enchantment.ARROW_FIRE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .displayName(ChatColor.RED + "Itachi")
            .setLore(ChatColor.GRAY + "Hinata possède le " + ChatColor.GOLD + "" + ChatColor.BOLD + "Susano" + ChatColor.GRAY + ".", ChatColor.RESET + "" + ChatColor.RED + "Force " + ChatColor.GRAY + "de façon permanente.", ChatColor.RESET + "" + ChatColor.AQUA + "Vitesse " + ChatColor.GRAY + "de façon permanente.", ChatColor.RESET + "" + ChatColor.GOLD + "Resistance au feu " + ChatColor.GRAY + "de façon permanente.")
            .build();

    private static Item item;

    public Itachi() {
        item = new SusanoItem();
    }

    @Override
    public String getName() {
        return "Itachi";
    }

    @Override
    public String getId() {
        return "akatsuki_itachi";
    }

    @Override
    public PotionEffect[] getEffects() {
        return EFFECTS;
    }

    @Override
    public Camp getCamp() {
        return Camp.AKATSUKI;
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

    @Override
    public void onPlayerDeath(Player player) {

    }

    @Override
    public void onAssign(Player player) {

    }

    @Override
    public Item getItem() {
        return item;
    }
}
