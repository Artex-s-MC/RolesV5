package be.artex.rolesv5.api;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class Cooldown {
    private final Map<UUID, Long> cooldownMap;
    private final TimeUnit unit;

    public Cooldown(TimeUnit unit) {
        this.unit = unit;
        this.cooldownMap = new ConcurrentHashMap<>();
    }

    public boolean isCooldownOver(UUID player, long coolDownTime) {
        boolean isOverTime = this.getLeftTime(player, coolDownTime) == 0;

        if (isOverTime)
            this.cooldownMap.remove(player);

        return isOverTime;
    }

    public long getLeftTime(UUID player, long coolDownTime) {
        if (!this.cooldownMap.containsKey(player))
            return 0;

        long setTime = this.cooldownMap.get(player);
        long leftTime = TimeUnit.MILLISECONDS.convert(coolDownTime, this.unit) - (System.currentTimeMillis() - setTime);

        long leftTimeSeconds = TimeUnit.SECONDS.convert(leftTime, TimeUnit.MILLISECONDS);

        return Math.max(leftTimeSeconds, 0);
    }

    public void addCoolDown(UUID player) {
        this.cooldownMap.put(player, System.currentTimeMillis());
    }
}
