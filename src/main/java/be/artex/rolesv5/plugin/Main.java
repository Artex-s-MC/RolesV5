package be.artex.rolesv5.plugin;

import be.artex.rolesv5.api.camp.Camp;
import be.artex.rolesv5.api.role.Roles;
import be.artex.rolesv5.api.role.roles.pacte.Bat;
import be.artex.rolesv5.api.role.roles.shinobi.Hinata;
import be.artex.rolesv5.api.role.roles.slayer.Kanae;
import be.artex.rolesv5.api.role.roles.solo.Assasin;
import be.artex.rolesv5.api.role.roles.solo.Imitateur;
import be.artex.rolesv5.api.role.roles.solo.LGS;
import be.artex.rolesv5.api.role.roles.lg.VPL;
import be.artex.rolesv5.api.role.roles.sonic.Knuckles;
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
        Roles.registerCamp(Camp.VILLAGE);
        Roles.registerCamp(Camp.LOUP);
        Roles.registerCamp(Camp.SOLO);
        Roles.registerCamp(Camp.SONIC_TEAM);
        Roles.registerCamp(Camp.PACTES);
        Roles.registerCamp(Camp.SHINOBI);
        Roles.registerCamp(Camp.AKATSUKI);
        Roles.registerCamp(Camp.OROCHIMARU);

        Roles.registerRole(new VPL());
        Roles.registerRole(new LGS());
        Roles.registerRole(new Assasin());
        Roles.registerRole(new Kanae());
        Roles.registerRole(new Knuckles());
        Roles.registerRole(new Imitateur());
        Roles.registerRole(new Bat());
        Roles.registerRole(new Hinata());


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
