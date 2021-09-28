package net.kunmc.lab.banin30secs.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.banin30secs.Config;

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
        ctx.success("有効化しました.");
    }
}
