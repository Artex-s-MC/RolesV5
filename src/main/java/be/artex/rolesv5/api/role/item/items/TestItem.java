package be.artex.rolesv5.api.role.item.items;

import be.artex.rolesv5.api.role.item.SpecialItems.CoolDownItem;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.TimeUnit;

public class TestItem extends CoolDownItem {
    public TestItem() {
        super(5, TimeUnit.SECONDS);
    }

    @Override
    protected void onClick(PlayerInteractEvent e) {
        e.getPlayer().sendMessage("sword");
    }

    @Override
    public ItemStack getStack() {
        return new ItemStack(Material.PAPER);
    }
}
