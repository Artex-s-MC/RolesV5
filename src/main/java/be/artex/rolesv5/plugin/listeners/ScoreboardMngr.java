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

    public static Scoreboard sb;
    public static Objective obj;

    public static void updateScoreBoard(Player player) {
        sb = Bukkit.getScoreboardManager().getNewScoreboard();
        obj = sb.registerNewObjective("roles", "dummy");

        obj.setDisplayName(ChatColor.WHITE + "[" + ChatColor.BOLD + ChatColor.AQUA + "RolesV5" + ChatColor.WHITE + "]");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        obj.getScore(ChatColor.STRIKETHROUGH + "" + ChatColor.ITALIC + "------------").setScore(12);
        obj.getScore(ChatColor.RED + "Kill Streak" + ChatColor.RESET + ": " + playersKillstreak.get(player.getUniqueId())).setScore(11);

        if (playersKills.get(player.getUniqueId()) == null) {
            obj.getScore(ChatColor.RED + "Kills" + ChatColor.RESET + ": " + 0).setScore(10);
        } else {
            obj.getScore(ChatColor.RED + "Kills" + ChatColor.RESET + ": " + playersKills.get(player.getUniqueId())).setScore(10);
        }

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        player.setScoreboard(sb);
    }

    public static void resetKillstreak(Player player) {
        playersKillstreak.put(player.getUniqueId(), 0);
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
