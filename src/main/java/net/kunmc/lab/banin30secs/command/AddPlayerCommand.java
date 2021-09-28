package net.kunmc.lab.banin30secs.command;

import dev.kotx.flylib.command.Command;
import kotlin.Unit;
import net.kunmc.lab.banin30secs.Config;
import org.bukkit.entity.Player;

import java.util.List;

public class AddPlayerCommand extends Command {
    public AddPlayerCommand() {
        super("addPlayer");

        usage(builder -> {
            builder.entityArgument("player")
                    .executes(ctx -> {
                        int count = 0;
                        for (Object arg : ((List) ctx.getTypedArgs().get(0))) {
                            if (Config.disabledPlayers.add(((Player) arg).getUniqueId())) {
                                count++;
                            }
                        }
                        ctx.success(count + "人のプレイヤーを無効化しました.");

                        return Unit.INSTANCE;
                    });
        });
    }
}
