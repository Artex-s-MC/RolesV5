package be.artex.rolesv5.plugin.listeners;

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

        obj.setDisplayName(ChatColor.WHITE + "[" + ChatColor.BOLD + ChatColor.AQUA + "RolesV5" + ChatColor.WHITE + "]");

        obj.getScore(ChatColor.RED + "Kill Streak" + ChatColor.RESET + ": " + playersKillstreak.get(player.getUniqueId())).setScore(11);


        if (playersKills.get(player.getUniqueId()) == null) {
            obj.getScore(ChatColor.RED + "Kills" + ChatColor.RESET + ": " + 0).setScore(10);
        } else {
            obj.getScore(ChatColor.RED + "Kills" + ChatColor.RESET + ": " + playersKills.get(player.getUniqueId())).setScore(10);
        }

        obj.getScore("   ").setScore(9);

        if (playersDeaths.get(player.getUniqueId()) == null && playersKills.get(player.getUniqueId()) != null) {
            obj.getScore(ChatColor.RED + "KDR" + ChatColor.RESET + ": " + playersKills.get(player.getUniqueId()) + ".00").setScore(8);
        } else if (playersDeaths.get(player.getUniqueId()) != null && playersKills.get(player.getUniqueId()) == null) {
            obj.getScore(ChatColor.RED + "KDR" + ChatColor.RESET + ": -" + playersDeaths.get(player.getUniqueId()).toString() + ".00").setScore(8);
        } else if (playersDeaths.get(player.getUniqueId()) == null && playersKills.get(player.getUniqueId()) == null) {
            obj.getScore(ChatColor.RED + "KDR" + ChatColor.RESET + ": 0.00").setScore(8);
        } else if (playersDeaths.get(player.getUniqueId()) == 0) {
            // Handle the case where the player has deaths but no kills
            obj.getScore(ChatColor.RED + "KDR" + ChatColor.RESET + ": 1").setScore(8);
        } else {
            // Calculate and set the KDR score
            double kdr = (double) playersKills.get(player.getUniqueId()) / playersDeaths.get(player.getUniqueId());
            obj.getScore(ChatColor.RED + "KDR" + ChatColor.RESET + ": " + String.format("%.2f", kdr)).setScore(8);
        }



        obj.getScore("  ").setScore(7);
        obj.getScore(ChatColor.AQUA + "Joueurs" + ChatColor.RESET + ": " + players).setScore(6);

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
