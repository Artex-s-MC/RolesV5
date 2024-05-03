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
            "slayer", 19),
    DEMON(ItemBuilder.create(Material.REDSTONE)
            .displayName(ChatColor.RED + "" + ChatColor.BOLD + "Démons")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build(),
            Bukkit.createInventory(null, 54, "Démons"),
            "demon", 28),
    VILLAGE(ItemBuilder.create(Material.HAY_BLOCK)
            .displayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Village")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build(),
            Bukkit.createInventory(null, 54, "Villageois"),
                    "village", 25),
    LOUP(ItemBuilder.create(Material.COOKED_BEEF)
            .displayName(ChatColor.RED + "" + ChatColor.BOLD + "Loups-garous")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build(),
            Bukkit.createInventory(null, 54, "Loups-garous"),
                    "lg", 34),
    SOLO(ItemBuilder.create(Material.BLAZE_POWDER)
            .displayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Solitaires")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build(),
            Bukkit.createInventory(null, 54, "Solitaires"),
            "solo", 3),
    SONIC_TEAM(ItemBuilder.create(Material.LAPIS_BLOCK)
            .displayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Sonic Team")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build(),
            Bukkit.createInventory(null, 54, "Sonic team"),
            "sonic", 4),
    PACTES(ItemBuilder.create(Material.REDSTONE_ORE)
                    .displayName(ChatColor.RED + "" + ChatColor.BOLD + "Pactes")
                    .addEnchant(Enchantment.ARROW_DAMAGE, 1)
                    .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    .build(),
            Bukkit.createInventory(null, 54, "Pactes"),
            "pacte",5),
    SHINOBI(ItemBuilder.create(Material.EMERALD)
            .displayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Shinobi")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build(),
            Bukkit.createInventory(null, 54, "Shinobi"),
            "shinobi", 48),
    AKATSUKI(ItemBuilder.create(Material.OBSIDIAN)
            .displayName(ChatColor.RED + "" + ChatColor.BOLD + "Akastuki")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build(),
            Bukkit.createInventory(null, 54, "Akatsuki"),
            "akatsuki", 49),
    OROCHIMARU(ItemBuilder.create(Material.POTION)
            .displayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Orochimaru")
            .addEnchant(Enchantment.ARROW_DAMAGE, 1)
            .addItemFlags(ItemFlag.HIDE_ENCHANTS)
            .build(),
            Bukkit.createInventory(null, 54, "Orochimaru"),
            "orochimaru", 50);


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
