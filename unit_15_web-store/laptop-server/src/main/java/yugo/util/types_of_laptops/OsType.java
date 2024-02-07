package yugo.util.types_of_laptops;

import lombok.Getter;

@Getter
public enum OsType {

    WINDOWS("Windows"),
    LINUX("Linux"),
    MAC_OS("Mac Os");

    private final String osType;

    OsType(String osType) {

        this.osType = osType;
    }
}
