package be.artex.rolesv5.api.camp;

import be.raft.crafty.item.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public enum Camp {


    SLAYER(ItemBuilder.create(Material.IRON_SWORD)
            .displayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Slayers")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build(),
            Bukkit.createInventory(null, 9, "Slayers"),
            "slayer"),
    DEMON(ItemBuilder.create(Material.REDSTONE)
            .displayName(ChatColor.RED + "" + ChatColor.BOLD + "Démons")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build(),
            Bukkit.createInventory(null, 9, "Démons"),
            "demon");




    private final ItemStack stack;
    private final Inventory inventory;
    private final String id;

    Camp(ItemStack stack, Inventory inventory, String id) {
        this.stack = stack;
        this.inventory = inventory;
        this.id = id;
    }

    public ItemStack getStack() {
        return stack;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getId() {
        return id;
    }

    public static final ItemStack SLAYER_STACK = ItemBuilder.create(Material.IRON_SWORD)
            .displayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Slayers")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build();
}
