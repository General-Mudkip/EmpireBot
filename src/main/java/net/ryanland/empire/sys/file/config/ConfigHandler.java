package net.ryanland.empire.sys.file.config;

import com.google.gson.JsonObject;
import net.ryanland.empire.sys.file.local.LocalFiles;

import java.io.IOException;

public class ConfigHandler {

    private Config CONFIG;

    public static Config loadConfig() throws IOException {
        JsonObject rawJson = LocalFiles.CONFIG.parseJson();
        return new Config(rawJson);
    }

    public Config getConfig() {
        return CONFIG;
    }

}
