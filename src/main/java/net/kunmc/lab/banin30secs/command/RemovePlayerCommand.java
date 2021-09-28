package net.kunmc.lab.banin30secs.command;

import dev.kotx.flylib.command.Command;
import kotlin.Unit;
import net.kunmc.lab.banin30secs.Config;
import org.bukkit.entity.Player;

import java.util.List;

public class RemovePlayerCommand extends Command {
    public RemovePlayerCommand() {
        super("removePlayer");

        usage(builder -> {
            builder.entityArgument("player")
                    .executes(ctx -> {
                        int count = 0;
                        for (Object arg : ((List) ctx.getTypedArgs().get(0))) {
                            if (arg instanceof Player) {
                                if (Config.disabledPlayers.remove(((Player) arg).getUniqueId())) {
                                    count++;
                                }
                            }
                        }
                        ctx.success(count + "人のプレイヤーを有効化しました.");

                        return Unit.INSTANCE;
                    });
        });
    }
}
