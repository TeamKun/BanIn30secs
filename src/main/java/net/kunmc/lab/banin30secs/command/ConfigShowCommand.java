package net.kunmc.lab.banin30secs.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.banin30secs.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.UUID;

public class ConfigShowCommand extends Command {
    public ConfigShowCommand() {
        super("show");
    }

    @Override
    public void execute(CommandContext ctx) {
        for (Field field : Config.class.getDeclaredFields()) {
            Object target = null;
            try {
                target = field.get(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
           
            if (field.getName().equals("disabledPlayers")) {
                ctx.message(ChatColor.YELLOW + "---------無効化済みプレイヤー---------");

                StringBuilder builder = new StringBuilder(ChatColor.GREEN.toString());
                for (UUID uuid : Config.disabledPlayers) {
                    Player p = Bukkit.getPlayer(uuid);
                    if (p != null) {
                        builder.append(p.getName()).append(", ");
                    }
                }
                ctx.success(builder.toString());
                ctx.message(ChatColor.YELLOW + "---------------------------------");
            } else {
                ctx.success(field.getName() + ": " + target);
            }
        }
    }
}

