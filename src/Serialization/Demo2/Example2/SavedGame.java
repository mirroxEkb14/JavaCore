package Serialization.Demo2.Example2;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

public class SavedGame implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private transient TerritoriesInfo territoriesInfo;
    private ResourcesInfo resourcesInfo;

    public SavedGame(TerritoriesInfo territoriesInfo, ResourcesInfo resourcesInfo) {
        this.territoriesInfo = territoriesInfo;
        this.resourcesInfo = resourcesInfo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public TerritoriesInfo getTerritoriesInfo() {
        return territoriesInfo;
    }

    public void setTerritoriesInfo(TerritoriesInfo territoriesInfo) {
        this.territoriesInfo = territoriesInfo;
    }

    public ResourcesInfo getResourcesInfo() {
        return resourcesInfo;
    }

    public void setResourcesInfo(ResourcesInfo resourcesInfo) {
        this.resourcesInfo = resourcesInfo;
    }

    @Override
    public String toString() {
        return "SavedGame{" +
                "territoriesInfo=" + territoriesInfo +
                ", resourcesInfo=" + resourcesInfo +
                '}';
    }
}
