package be.artex.rolesv5.plugin.listeners;

import be.artex.rolesv5.api.role.Roles;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.HashMap;
import java.util.UUID;

public class ScoreboardMngr {
    private static final HashMap<UUID, Integer> playersKillstreak = new HashMap<>();
    private static final HashMap<UUID, Integer> playersKills = new HashMap<>();
    private static final HashMap<UUID, Integer> playersDeaths = new HashMap<>();

    public static int players;

    public static Scoreboard sb;
    public static Objective obj;

    public static void updateScoreBoard(Player player) {
        sb = Bukkit.getScoreboardManager().getNewScoreboard();
        obj = sb.registerNewObjective("roles", "dummy");

        ChatColor color = ChatColor.AQUA;

        obj.setDisplayName(ChatColor.WHITE + "[" + ChatColor.BOLD + color + "RolesV5" + ChatColor.WHITE + "]");

        obj.getScore(" ").setScore(12);

        obj.getScore(color + "" + ChatColor.BOLD + "JOUEUR").setScore(11);
        obj.getScore(" Nom" + ChatColor.GRAY + ": " + color + player.getDisplayName()).setScore(10);

        if (Roles.getPlayerRole(player) == null) {
            obj.getScore(" Rôle" + ChatColor.GRAY + ": " + color + "Aucun").setScore(9);
        } else {
            obj.getScore(" Rôle" + ChatColor.GRAY + ": " + color + Roles.getPlayerRole(player).getName()).setScore(9);
        }

        obj.getScore("  ").setScore(8);

        obj.getScore(color + "" + ChatColor.BOLD + "STATS").setScore(7);
        obj.getScore(" Kill Streak" + ChatColor.GRAY + ": " + color + playersKillstreak.get(player.getUniqueId())).setScore(6);

        if (playersKills.get(player.getUniqueId()) == null) {
            obj.getScore(" Kills" + ChatColor.GRAY + ": " + color + 0).setScore(5);
        } else {
            obj.getScore(" Kills" + ChatColor.GRAY + ": " + color + playersKills.get(player.getUniqueId())).setScore(5);
        }

        if (playersDeaths.get(player.getUniqueId()) == null && playersKills.get(player.getUniqueId()) != null) {
            obj.getScore(" KDR" + ChatColor.GRAY + ": " + color + playersKills.get(player.getUniqueId()) + ".00").setScore(4);
        } else if (playersDeaths.get(player.getUniqueId()) != null && playersKills.get(player.getUniqueId()) == null) {
            obj.getScore(" KDR" + ChatColor.GRAY + ": " + color + "-" + playersDeaths.get(player.getUniqueId()).toString() + ".00").setScore(4);
        } else if (playersDeaths.get(player.getUniqueId()) == null && playersKills.get(player.getUniqueId()) == null) {
            obj.getScore(" KDR" + ChatColor.GRAY + ":" + color + "0.00").setScore(4);
        } else if (playersDeaths.get(player.getUniqueId()) == 0) {
            obj.getScore(" KDR" + ChatColor.GRAY + ":").setScore(4);
        } else {
            double kdr = (double) playersKills.get(player.getUniqueId()) / playersDeaths.get(player.getUniqueId());
            obj.getScore(" KDR" + ChatColor.GRAY + ": " + color + String.format("%.2f", kdr)).setScore(4);
        }

        obj.getScore("   ").setScore(3);

        obj.getScore(color + "" + ChatColor.BOLD + "SERVEUR").setScore(2);
        obj.getScore(" Joueurs" + ChatColor.GRAY + ": " + color + players).setScore(1);

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        player.setScoreboard(sb);
    }

    public static void resetKillStreak(Player player) {
        playersKillstreak.put(player.getUniqueId(), 0);

        if (playersDeaths.get(player.getUniqueId()) == null) {
            playersDeaths.put(player.getUniqueId(), 0);
        } else {
            playersDeaths.put(player.getUniqueId(), playersDeaths.get(player.getUniqueId()) + 1);
        }
    }

    public static void addOnlinePlayer() {
        players++;
    }

    public static void addOfflinePlayer() {
        players--;
    }
    public static void addAKill(Player player) {
        playersKillstreak.put(player.getUniqueId(), playersKillstreak.get(player.getUniqueId()) + 1);

        if (playersKills.get(player.getUniqueId()) == null) {
            playersKills.put(player.getUniqueId(), 1);
        } else {
            playersKills.put(player.getUniqueId(), playersKills.get(player.getUniqueId()) + 1);
        }
    }
}
