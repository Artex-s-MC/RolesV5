package be.artex.rolesv5.plugin.listeners;

import be.artex.rolesv5.api.camp.Camp;
import be.artex.rolesv5.api.roles.Role;
import be.artex.rolesv5.api.roles.Roles;
import be.artex.rolesv5.plugin.Main;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListeners implements Listener {

    private static ItemStack border;
    private static Main main;

    public PlayerListeners() {
        main = Main.getInstance();

        border = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
        ItemMeta itemMeta = border.getItemMeta();
        itemMeta.setDisplayName(" ");
        border.setItemMeta(itemMeta);
    }

    private static Inventory prepareCampsInv() {
        Inventory inventory = Bukkit.createInventory(null, 54, "Camps");

        inventory.setItem(0, border);
        inventory.setItem(1, border);
        inventory.setItem(7, border);
        inventory.setItem(8, border);
        inventory.setItem(9, border);
        inventory.setItem(17, border);
        inventory.setItem(44, border);
        inventory.setItem(36, border);
        inventory.setItem(45, border);
        inventory.setItem(46, border);
        inventory.setItem(52, border);
        inventory.setItem(53, border);

        for (Camp camp : Roles.camps) {
            inventory.setItem(camp.getPlacement(), camp.getStack());
        }

        return inventory;
    }

    @EventHandler
    public void onPlayerDie(PlayerDeathEvent e) {
        for (ItemStack stack : e.getDrops()) {
            switch (stack.getType()) {
                case GOLDEN_APPLE:
                case ARROW:
                case IRON_LEGGINGS:
                case DIAMOND_CHESTPLATE:
                case DIAMOND_HELMET:
                case DIAMOND_BOOTS:
                case IRON_HELMET:
                case IRON_BOOTS:
                case WATER_BUCKET:
                case LAVA_BUCKET:
                case DIAMOND_SWORD:
                case COBBLESTONE:
                    continue;
                default:
                    stack.setType(Material.AIR);
            }
        }

        if (Roles.getPlayerRole(e.getEntity()) == null) {
            e.setDeathMessage("");
            return;
        }

        Role killerRole = Roles.getPlayerRole(e.getEntity().getKiller());

        if (e.getEntity().getKiller() != null && killerRole != null) {
            e.setDeathMessage("§o§m-------------------------\n" + ChatColor.GREEN + e.getEntity().getDisplayName() + ChatColor.RESET + " à été assasiné par " + ChatColor.RED + e.getEntity().getKiller().getDisplayName() + ChatColor.RESET + ", son role était " + Roles.getPlayerRole(e.getEntity()).getColor() + Roles.getPlayerRole(e.getEntity()).getName() + ChatColor.RESET + ".\n§o§m-------------------------");
            killerRole.getOnKill(e);
        } else {
            e.setDeathMessage("§o§m-------------------------\n" + ChatColor.GREEN + e.getEntity().getDisplayName() + ChatColor.RESET + " est mort, son role était " + Roles.getPlayerRole(e.getEntity()).getColor() + Roles.getPlayerRole(e.getEntity()).getName() + ChatColor.RESET + ".\n§o§m-------------------------");
        }

        Roles.setPlayerRole(e.getEntity(), null);

    }

    @EventHandler
    public void onPlayerDamageItem(PlayerItemDamageEvent e) {
        switch (e.getItem().getType()) {
            case DIAMOND_SWORD:
                e.setDamage(0);
            case IRON_SWORD:
                e.setDamage(0);
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        e.getPlayer().setWalkSpeed(0.2f);
        e.getPlayer().setMaxHealth(20);
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        e.getPlayer().getInventory().setItem(4, ItemBuilder.create(Material.ENCHANTED_BOOK)
                .displayName(ChatColor.RESET + "Quel est ton rôle ?")
                .build());
    }

    @EventHandler
    public void entityDamageEntity(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player))
            return;

        if (!(e.getEntity() instanceof  Player))
            return;

        double damage = e.getDamage();
        Player entity = (Player) e.getEntity();
        Player damager = (Player) e.getDamager();

        if (entity.getGameMode().equals(GameMode.ADVENTURE) || damager.getGameMode().equals(GameMode.ADVENTURE)) {
            e.setCancelled(true);
            return;
        }

        if (entity.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE))
            damage = (damage / 100) * 60;

        if (entity.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
            damage = (damage / 100) * 60;

        e.setDamage(damage);

        if (Roles.getPlayerRole(damager) == null)
            return;

        Roles.getPlayerRole(damager).onHit(e);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        ItemStack air = new ItemStack(Material.AIR);
        ItemStack[] armor = {air, air, air, air};

        e.getPlayer().getInventory().setContents(armor);

        e.getPlayer().setHealth(e.getPlayer().getMaxHealth());
        e.getPlayer().setWalkSpeed(0.2f);
        e.getPlayer().setMaxHealth(20);
        e.getPlayer().getInventory().clear();
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        Location location = new Location(e.getPlayer().getWorld(), 0, 122, 0);
        e.getPlayer().teleport(location);
        e.getPlayer().getInventory().setItem(4, ItemBuilder.create(Material.ENCHANTED_BOOK)
                .displayName(ChatColor.RESET + "Quel est ton rôle ?")
                .build());

        for (PotionEffect potionEffect : e.getPlayer().getActivePotionEffects())
            e.getPlayer().removePotionEffect(potionEffect.getType());

        e.getPlayer().getWorld().getWorldBorder().setCenter(0, 0);
        e.getPlayer().getWorld().getWorldBorder().setSize(100);

        e.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.DARK_GRAY + "] " + e.getPlayer().getDisplayName());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "-" + ChatColor.DARK_GRAY + "] " + e.getPlayer().getDisplayName());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getItem() == null)
            return;

        if (e.getItem().equals(ItemBuilder.create(Material.ENCHANTED_BOOK).displayName(ChatColor.RESET + "Quel est ton rôle ?").build()))
            e.getPlayer().openInventory(prepareCampsInv());
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null)
            return;

        if (e.getCurrentItem().equals(border)) {
            e.setCancelled(true);
            return;
        }

        Camp foundCamp = Roles.camps.stream()
                .filter(camp -> e.getCurrentItem().equals(camp.getStack()))
                .findFirst().orElse(null);

        Role foundRole = Roles.roles.stream()
                .filter(role -> e.getCurrentItem().equals(role.getGUIStack()))
                .findFirst().orElse(null);

        if (foundRole != null) {
            e.setCancelled(true);

            foundRole.assign((Player) e.getWhoClicked());
            return;
        }

        if (foundCamp != null) {
            e.setCancelled(true);

            foundCamp.getInventory().setItem(0, border);
            foundCamp.getInventory().setItem(1, border);
            foundCamp.getInventory().setItem(7, border);
            foundCamp.getInventory().setItem(8, border);
            foundCamp.getInventory().setItem(9, border);
            foundCamp.getInventory().setItem(17, border);
            foundCamp.getInventory().setItem(44, border);
            foundCamp.getInventory().setItem(36, border);
            foundCamp.getInventory().setItem(45, border);
            foundCamp.getInventory().setItem(46, border);
            foundCamp.getInventory().setItem(52, border);
            foundCamp.getInventory().setItem(53, border);

            for (Role role : Roles.rolesInCamp.get(foundCamp.getId())) {
                foundCamp.getInventory().setItem(role.getPlacement(), role.getGUIStack());
            }

            Bukkit.getScheduler().runTask(main, () -> {
               e.getWhoClicked().openInventory(foundCamp.getInventory());
            });
        }

    }

}
