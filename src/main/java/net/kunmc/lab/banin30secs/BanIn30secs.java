package net.kunmc.lab.banin30secs;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import dev.kotx.flylib.FlyLib;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kunmc.lab.banin30secs.command.MainCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public final class BanIn30secs extends JavaPlugin {
    private final Map<Player, Integer> playerRemainingSecsMap = new HashMap<>();

    @Override
    public void onEnable() {
        FlyLib.create(this, builder -> {
            builder.command(new MainCommand());

            builder.listen(PlayerInteractEvent.class, e -> {
                if (Config.playerInteract) {
                    playerRemainingSecsMap.put(e.getPlayer(), Config.secs);
                }
            });

            builder.listen(PlayerJumpEvent.class, e -> {
                if (Config.playerJump) {
                    playerRemainingSecsMap.put(e.getPlayer(), Config.secs);
                }
            });

            builder.listen(BlockBreakEvent.class, e -> {
                if (Config.blockBreak) {
                    playerRemainingSecsMap.put(e.getPlayer(), Config.secs);
                }
            });

            builder.listen(PlayerToggleSprintEvent.class, e -> {
                if (Config.playerToggleSprint) {
                    playerRemainingSecsMap.put(e.getPlayer(), Config.secs);
                }
            });

            builder.listen(PlayerMoveEvent.class, e -> {
                if (Config.playerMove) {
                    playerRemainingSecsMap.put(e.getPlayer(), Config.secs);
                }
            });

            builder.listen(PlayerToggleSneakEvent.class, e -> {
                if (Config.playerToggleSneak) {
                    playerRemainingSecsMap.put(e.getPlayer(), Config.secs);
                }
            });

            builder.listen(AsyncChatEvent.class, e -> {
                if (Config.playerChat) {
                    playerRemainingSecsMap.put(e.getPlayer(), Config.secs);
                }
            });
        });

        new BukkitRunnable() {
            @Override
            public void run() {
                if (!Config.enabled) {
                    return;
                }

                Bukkit.getOnlinePlayers().forEach(p -> {
                    int remainingSecs = playerRemainingSecsMap.getOrDefault(p, Config.secs) - 1;
                    playerRemainingSecsMap.put(p, remainingSecs);

                    if (remainingSecs <= 0) {
                        if (Config.shouldBanPlayer) {
                            p.banPlayer(Config.banMessage);
                        } else {
                            p.kickPlayer(Config.kickMessage);
                        }
                    }
                });
            }
        }.runTaskTimer(this, 20, 20);

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(p -> {
                    p.sendMessage(playerRemainingSecsMap.getOrDefault(p, Config.secs) + "");
                });
            }
        }.runTaskTimerAsynchronously(this, 0, 10);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
