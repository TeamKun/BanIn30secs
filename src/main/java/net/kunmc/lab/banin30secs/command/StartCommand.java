package net.kunmc.lab.banin30secs.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.banin30secs.BanIn30secs;
import net.kunmc.lab.banin30secs.Config;
import org.bukkit.entity.Player;

public class StartCommand extends Command {
    public StartCommand() {
        super("start");
    }

    @Override
    public void execute(CommandContext ctx) {
        if (Config.enabled) {
            ctx.fail("すでに有効です.");
            return;
        }

        Config.enabled = true;
        for (Player player : BanIn30secs.playerRemainingSecsMap.keySet()) {
            BanIn30secs.playerRemainingSecsMap.put(player, Config.secs);
        }
        ctx.success("有効化しました.");
    }
}
