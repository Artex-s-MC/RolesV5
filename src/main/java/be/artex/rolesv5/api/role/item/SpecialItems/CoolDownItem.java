package be.artex.rolesv5.api.role.item.SpecialItems;

import be.artex.rolesv5.api.Cooldown;
import be.artex.rolesv5.api.role.item.Item;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.concurrent.TimeUnit;

public abstract class CoolDownItem extends Item {
    protected final Cooldown cooldown;
    protected final long coolDownTime;

    protected CoolDownItem(long coolDownTime, TimeUnit unit) {
        this.cooldown = new Cooldown(unit);
        this.coolDownTime = coolDownTime;
    }

    @Override
    public final void click(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (!this.cooldown.isCooldownOver(player.getUniqueId(), this.coolDownTime)) {
            player.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RolesV5" + ChatColor.GRAY + " >> " + ChatColor.AQUA + " ⚠ Cette compétence est en cooldown pour encore " + getLeftCoolDown(player) + " secondes. ⚠ ");
            return;
        }

        this.cooldown.addCoolDown(player.getUniqueId());

        this.onClick(e);
    }

    protected void onClick(PlayerInteractEvent e) {
    }

    public long getLeftCoolDown(Player player) {
        return this.cooldown.getLeftTime(player.getUniqueId(), this.coolDownTime);
    }
}

