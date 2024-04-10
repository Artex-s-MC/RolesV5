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
            Bukkit.createInventory(null, 54, "Slayers"),
            "slayer", 20),
    DEMON(ItemBuilder.create(Material.REDSTONE)
            .displayName(ChatColor.RED + "" + ChatColor.BOLD + "Démons")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build(),
            Bukkit.createInventory(null, 54, "Démons"),
            "demon", 21);


    private final ItemStack stack;
    private final Inventory inventory;
    private final String id;
    private final int placement;

    Camp(ItemStack stack, Inventory inventory, String id, int placement) {
        this.stack = stack;
        this.inventory = inventory;
        this.id = id;
        this.placement = placement;
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

    public int getPlacement() {
        return placement;
    }

    public static final ItemStack SLAYER_STACK = ItemBuilder.create(Material.IRON_SWORD)
            .displayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Slayers")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build();
}
