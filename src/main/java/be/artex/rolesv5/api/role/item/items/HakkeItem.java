package be.artex.rolesv5.api.role.item.items;

import be.artex.rolesv5.api.role.item.Item;
import be.artex.rolesv5.api.role.item.SpecialItems.CoolDownItem;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.TimeUnit;

public class HakkeItem extends CoolDownItem {
    private static final ItemStack GUI_STACK = ItemBuilder.create(Material.NETHER_STAR)
            .displayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Hakke")
            .setLore(ChatColor.RESET + "" + ChatColor.GRAY + "Permet d'infliger aux joueurs dans un rayon de dix blocs " + ChatColor.RED + "2 coeurs" + ChatColor.GRAY + " de " + ChatColor.RED + "dégats", ChatColor.RESET + "" + ChatColor.GRAY + "en plus de " + ChatColor.DARK_GRAY + "lenteur 4" + ChatColor.GRAY + ".", ChatColor.AQUA + "Cooldown" + ChatColor.GRAY + ": 45 secondes.")
            .build();


    public HakkeItem() {
        super(45, TimeUnit.SECONDS);
    }

    private static void forPlayer(Player player) {
        player.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + "Vous avez été touché par le " + ChatColor.BOLD + "Hakke" + ChatColor.AQUA + ".");

        if (player.getHealth() > 4) {
            player.setHealth(player.getHealth() - 4);
        } else {
            player.setHealth(1);
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3*20, 5));
    }

    @Override
    protected void onClick(PlayerInteractEvent e) {
        int players = 0;
        for (Entity entity : e.getPlayer().getNearbyEntities(10, 10, 10)) {
            if (!(entity instanceof Player))
                continue;

            players++;

            forPlayer((Player) entity);
        }

        e.getPlayer().sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + "Vous avez utilisé le " + ChatColor.BOLD + "Hakke" + ChatColor.AQUA + " sur " + ChatColor.BOLD + players + ChatColor.AQUA + " personnes.");
    }

    @Override
    public ItemStack getStack() {
        return GUI_STACK;
    }
}
