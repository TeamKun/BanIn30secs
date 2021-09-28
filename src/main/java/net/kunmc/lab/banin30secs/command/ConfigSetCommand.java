package net.kunmc.lab.banin30secs.command;

import dev.kotx.flylib.command.Command;
import net.kunmc.lab.banin30secs.Config;

import java.lang.reflect.Field;

public class ConfigSetCommand extends Command {
    public ConfigSetCommand() {
        super("set");

        try {
            for (Field field : Config.class.getDeclaredFields()) {
                if (!field.getName().equals("disabledPlayers") && !field.getName().equals("enabled")) {
                    field.setAccessible(true);
                    children(new ConfigItem(field));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}