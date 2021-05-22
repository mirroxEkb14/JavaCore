package Serialization.Demo2.Example1;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

/* 'implements Serializable' does nothing but
    says Java machine that this class can be
    serialized, it is a marker interface */

public class SavedGame implements Serializable {

    // contains the unique UID(user identifier) of
    // this class, it is needed when deserializing
    // (the value of the field in program is compared
    // to the value in bytes, if they do not match,
    // 'InvalidClassException' is thrown)
    @Serial
    private static final long serialVersionUID = 1L;

    // these variables contain the information about
    // territories and resources
    private String[] territoriesInfo;
    private String[] resourcesInfo;

    public SavedGame(String[] territoriesInfo, String[] resourcesInfo) {
        this.territoriesInfo = territoriesInfo;
        this.resourcesInfo = resourcesInfo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String[] getTerritoriesInfo() {
        return territoriesInfo;
    }

    public void setTerritoriesInfo(String[] territoriesInfo) {
        this.territoriesInfo = territoriesInfo;
    }

    public String[] getResourcesInfo() {
        return resourcesInfo;
    }

    public void setResourcesInfo(String[] resourcesInfo) {
        this.resourcesInfo = resourcesInfo;
    }

    @Override
    public String toString() {
        return "SavedGame{" +
                "territoriesInfo=" + Arrays.toString(territoriesInfo) +
                ", resourcesInfo=" + Arrays.toString(resourcesInfo) +
                '}';
    }
}
