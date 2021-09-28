package net.kunmc.lab.banin30secs.command;

import dev.kotx.flylib.command.Command;

public class MainCommand extends Command {
    public MainCommand() {
        super("banIn30secs");

        children(new StartCommand(), new StopCommand(), new ConfigCommand(), new AddPlayerCommand(), new RemovePlayerCommand());
    }
}
