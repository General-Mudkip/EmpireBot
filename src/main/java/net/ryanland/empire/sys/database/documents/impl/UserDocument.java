package net.ryanland.empire.sys.database.documents.impl;

import com.mongodb.client.model.Filters;
import net.ryanland.empire.sys.database.DocumentCache;
import net.ryanland.empire.sys.database.documents.BaseDocument;
import net.ryanland.empire.sys.database.documents.SnowflakeDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDocument extends BaseDocument implements SnowflakeDocument {

    public UserDocument(Document document) {
        super(document);
    }

    private int level = getLevel();
    private int crystals = getCrystals();
    private int gold = getGold();
    private int xp = getXp();
    private int wave = getWave();

    @Override
    public void updated(List<Bson> updates) {
        checkUpdate(updates, level, getLevel(), "level");
        checkUpdate(updates, crystals, getCrystals(), "crystals");
        checkUpdate(updates, gold, getGold(), "gold");
        checkUpdate(updates, xp, getXp(), "xp");
        checkUpdate(updates, wave, getWave(), "wave");

        DocumentCache.USER_COLLECTION.updateMany(Filters.eq("id", getId()), updates);
    }

    @Override
    public void cache() {
        DocumentCache.USER_CACHE.put(getId(), this);
    }

    public UserDocument setLevel(int level) {
        this.level = level;
        return this;
    }

    public UserDocument setCrystals(int crystals) {
        this.crystals = crystals;
        return this;
    }

    public UserDocument setGold(int gold) {
        this.gold = gold;
        return this;
    }

    public UserDocument setXp(int xp) {
        this.xp = xp;
        return this;
    }

    public UserDocument setWave(int wave) {
        this.wave = wave;
        return this;
    }

    public String getId() {
        return getString("id");
    }

    public int getLevel() {
        return getInteger("level", 1);
    }

    public int getCrystals() {
        return getInteger("crystals", 0);
    }

    public int getGold() {
        return getInteger("gold", 0);
    }

    public int getXp() {
        return getInteger("xp", 0);
    }

    public int getWave() {
        return getInteger("wave", 1);
    }

    public Date getCreated() {
        return getDate("created");
    }

}
