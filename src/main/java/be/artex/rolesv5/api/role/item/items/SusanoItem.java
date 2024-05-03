package be.artex.rolesv5.api.role.item.items;

import be.artex.rolesv5.api.role.item.SpecialItems.CoolDownItem;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.TimeUnit;

public class SusanoItem extends CoolDownItem {
    private static final ItemStack GUI_STACK = ItemBuilder.create(Material.NETHER_STAR)
            .displayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Susano")
            .setLore(ChatColor.RESET + "" + ChatColor.GRAY + "Donne résistance pendant 20 secondes.", ChatColor.AQUA + "Cooldown" + ChatColor.GRAY + ": 90 secondes.")
            .build();

    public SusanoItem() {
        super(90, TimeUnit.SECONDS);
    }

    @Override
    public ItemStack getStack() {
        return GUI_STACK;
    }

    @Override
    protected void onClick(PlayerInteractEvent e) {
        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*20, 0));
    }
}
