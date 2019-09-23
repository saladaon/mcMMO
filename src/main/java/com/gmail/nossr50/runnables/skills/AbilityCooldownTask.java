package com.gmail.nossr50.runnables.skills;

import com.gmail.nossr50.datatypes.interactions.NotificationType;
import com.gmail.nossr50.datatypes.player.McMMOPlayer;
import com.gmail.nossr50.datatypes.skills.SuperAbilityType;
import com.gmail.nossr50.mcMMO;
import org.bukkit.scheduler.BukkitRunnable;

public class AbilityCooldownTask extends BukkitRunnable {
    private final mcMMO pluginRef;
    private final McMMOPlayer mcMMOPlayer;
    private final SuperAbilityType ability;

    public AbilityCooldownTask(mcMMO pluginRef, McMMOPlayer mcMMOPlayer, SuperAbilityType ability) {
        this.pluginRef = pluginRef;
        this.mcMMOPlayer = mcMMOPlayer;
        this.ability = ability;
    }

    @Override
    public void run() {
        if (!mcMMOPlayer.getPlayer().isOnline() || mcMMOPlayer.getSuperAbilityInformed(ability)) {
            return;
        }

        mcMMOPlayer.setAbilityInformed(ability, true);

        pluginRef.getNotificationManager().sendPlayerInformation(mcMMOPlayer.getPlayer(), NotificationType.ABILITY_REFRESHED, ability.getSuperAbilityRefreshedStr());
        //mcMMOPlayer.getPlayer().sendMessage(ability.getAbilityRefresh());
    }
}
