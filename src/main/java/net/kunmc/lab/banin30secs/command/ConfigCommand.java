package net.kunmc.lab.banin30secs.command;

import dev.kotx.flylib.command.Command;

public class ConfigCommand extends Command {
    public ConfigCommand() {
        super("config");
        children(new ConfigSetCommand(), new ConfigShowCommand());
    }
}

