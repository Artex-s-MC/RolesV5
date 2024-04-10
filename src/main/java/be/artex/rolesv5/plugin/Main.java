package be.artex.rolesv5.plugin;

import be.artex.rolesv5.api.camp.Camp;
import be.artex.rolesv5.api.roles.Roles;
import be.artex.rolesv5.api.roles.roles.Inosuke;
import be.artex.rolesv5.plugin.listeners.PlayerListeners;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        // Plugin startup logic
        Roles.registerCamp(Camp.SLAYER);
        Roles.registerCamp(Camp.DEMON);

        Roles.registerRole(new Inosuke());

        this.getServer().getPluginManager().registerEvents(new PlayerListeners(), this);

        int halfSize = 4;
        int centerX = 0;
        int centerY = 120;
        int centerZ = 0;
        World world = Bukkit.getWorlds().get(0);

        for (int x = centerX - halfSize; x <= centerX + halfSize; x++) {
            for (int z = centerZ - halfSize; z <= centerZ + halfSize; z++) {
                Block block = world.getBlockAt(x, centerY, z);
                block.setType(Material.GLASS);
            }
        }

        for (int x = centerX - halfSize - 1; x <= centerX + halfSize + 1; x++) {
            for (int z = centerZ - halfSize - 1; z <= centerZ + halfSize + 1; z++) {
                if (x == centerX - halfSize - 1 || x == centerX + halfSize + 1 || z == centerZ - halfSize - 1 || z == centerZ + halfSize + 1) {
                    for (int y = centerY; y <= centerY + 3; y++) {
                        Block block = world.getBlockAt(x, y, z);
                        block.setType(Material.GLASS);
                    }
                }
            }
        }

        world.setSpawnLocation(0, 122, 0);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }
}
