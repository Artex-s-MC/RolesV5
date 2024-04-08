package be.artex.rolesv5.api.roles;

import be.artex.rolesv5.api.camp.Camp;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public final class Roles {
    public static HashMap<UUID, String> playerRole = new HashMap<>();
    public static HashMap<String, ArrayList<String>> RolesInCamp = new HashMap<>();
    public static HashMap<String, Role> registeredRoles = new HashMap<>();
    public static HashMap<String, Camp> registeredCamps = new HashMap<>();

    public static boolean playerHasRole(Player player) {
        if (playerRole.get(player.getUniqueId()) == null)
            return false;

        return true;
    }

    public static void registerRole(Role role) {
        registeredRoles.putIfAbsent(role.getId(), role);
    }

    public static void registerCamp(Camp camp) {
        registeredCamps.putIfAbsent(camp.getId(), camp);
    }

    public static Role getRole(String roleId) {
        return registeredRoles.get(roleId);
    }

    public static Camp getCamp(String campId) {
        return registeredCamps.get(campId);
    }

    public static void givePlayerGear(PlayerInventory playerInventory) {
        if (new Random().nextBoolean()) {
            playerInventory.addItem(ItemBuilder.create(Material.DIAMOND_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 3).build());
        } else {
            playerInventory.addItem(ItemBuilder.create(Material.IRON_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 3).build());
        }

        if (new Random().nextBoolean()) {
            playerInventory.setHelmet(ItemBuilder.create(Material.DIAMOND_HELMET).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
        } else {
            playerInventory.setHelmet(ItemBuilder.create(Material.IRON_HELMET).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build());
        }

        if (new Random().nextBoolean()) {
            playerInventory.setBoots(ItemBuilder.create(Material.DIAMOND_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
        } else {
            playerInventory.setBoots(ItemBuilder.create(Material.IRON_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build());
        }

        playerInventory.setChestplate(ItemBuilder.create(Material.DIAMOND_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
        playerInventory.setLeggings(ItemBuilder.create(Material.IRON_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build());
        playerInventory.addItem(ItemBuilder.create(Material.DIAMOND_PICKAXE).addEnchant(Enchantment.DIG_SPEED, 3).build());
        playerInventory.addItem(new ItemStack(Material.LAVA_BUCKET));
        playerInventory.addItem(new ItemStack(Material.COBBLESTONE, 64));
        playerInventory.addItem(new ItemStack(Material.GOLDEN_APPLE, (new Random().nextInt(7) + 12)));
        playerInventory.addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
        playerInventory.addItem(new ItemStack(Material.LAVA_BUCKET));
        playerInventory.addItem(ItemBuilder.create(Material.BOW).addEnchant(Enchantment.ARROW_DAMAGE, 3).build());
        playerInventory.addItem(new ItemStack(Material.WATER_BUCKET));
        playerInventory.addItem(new ItemStack(Material.WATER_BUCKET));
        playerInventory.addItem(new ItemStack(Material.LAVA_BUCKET));
        playerInventory.addItem(new ItemStack(Material.ARROW, 32));
        playerInventory.addItem(new ItemStack(Material.COBBLESTONE, 64));
        playerInventory.addItem(new ItemStack(Material.COBBLESTONE, 64));
    }

}