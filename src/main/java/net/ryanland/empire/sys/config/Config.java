package net.ryanland.empire.sys.config;

import com.google.gson.JsonObject;

public class Config {

    private final JsonObject rawConfig;

    private final String token;
    private final String clientId;
    private final String prefix;
    private final String databaseURI;

    public Config(JsonObject rawConfig) {
        this.rawConfig = rawConfig;

        this.token = rawConfig.get("token").getAsString();
        this.clientId = rawConfig.get("client_id").getAsString();
        this.prefix = rawConfig.get("prefix").getAsString();
        this.databaseURI = rawConfig.get("database_uri").getAsString();
    }

    public JsonObject getRawConfig() {
        return this.rawConfig;
    }

    public String getToken() {
        return this.token;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getDatabaseURI() {
        return this.databaseURI;
    }
}