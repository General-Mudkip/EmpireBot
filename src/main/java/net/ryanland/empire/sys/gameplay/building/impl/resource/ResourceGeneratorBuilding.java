package net.ryanland.empire.sys.gameplay.building.impl.resource;

import net.ryanland.empire.sys.gameplay.building.BuildingType;
import net.ryanland.empire.sys.gameplay.currency.Price;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

public abstract class ResourceGeneratorBuilding extends ResourceBuilding {

    public ResourceGeneratorBuilding(int stage, int health, @NotNull Date lastCollect) {
        super(stage, health, lastCollect);
    }

    @Override
    public BuildingType getBuildingType() {
        return BuildingType.RESOURCE_GENERATOR;
    }

    public abstract Price<Double> getUnitPerMin();

    public abstract Price<Integer> getCapacity();
}
