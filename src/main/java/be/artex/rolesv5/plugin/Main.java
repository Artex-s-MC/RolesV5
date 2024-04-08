package be.artex.rolesv5.plugin;

import be.artex.rolesv5.api.camp.Camp;
import be.artex.rolesv5.api.roles.Roles;
import be.artex.rolesv5.api.roles.roles.Inosuke;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Roles.registerCamp(Camp.SLAYER);
        Roles.registerCamp(Camp.DEMON);


        Roles.registerRole(new Inosuke());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
