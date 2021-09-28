package net.kunmc.lab.banin30secs.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.banin30secs.Config;

public class StopCommand extends Command {
    public StopCommand() {
        super("stop");
    }

    @Override
    public void execute(CommandContext ctx) {
        if (!Config.enabled) {
            ctx.fail("すでに無効です.");
            return;
        }

        Config.enabled = false;
        ctx.success("無効化しました.");
    }
}
