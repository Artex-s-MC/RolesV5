package be.artex.rolesv5.api.role.item;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public abstract class Item {
    public abstract ItemStack getStack();
    public abstract void click(PlayerInteractEvent e);
}
