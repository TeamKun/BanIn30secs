package net.kunmc.lab.banin30secs;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Config {
    public static Set<UUID> disabledPlayers = new HashSet<>();
    public static boolean enabled = false;
    public static int secs = 30;
    public static boolean playerInteract = true;
    public static boolean playerJump = true;
    public static boolean blockBreak = true;
    public static boolean playerToggleSprint = true;
    public static boolean playerMove = false;
    public static boolean playerToggleSneak = true;
    public static boolean playerChat = true;
    public static boolean shouldBanPlayer = true;
    public static String kickMessage = "作業しなすぎKick";
    public static String banMessage = "作業しなすぎBAN";
}
