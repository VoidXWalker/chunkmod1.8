package me.voidxwalker.chunkmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger();
    private static final ModContainer mod = FabricLoader.getInstance().getModContainer("chunkmod").orElseThrow(NullPointerException::new);
    public static String MOD_NAME = mod.getMetadata().getName();
    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }
    public static int ticks;
    public static int safedViewDistance;
    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
    }
}
