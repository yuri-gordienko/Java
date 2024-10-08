package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

@Getter
public enum OsType {

    WINDOWS_10_PRO("Windows 10 Pro"),
    WINDOWS_11_PRO("Windows 11 Pro"),
    WINDOWS_11_HOME("Windows 11 Home"),
    LINUX_UBUNTU("Ubuntu Linux"),
    LINUX_FEDORA("Fedora Linux"),
    LINUX_RED_HAT("Red Hat Linux"),
    MAC_OS("Mac OS");

    private final String type;

    OsType(String type) {
        this.type = type;
    }
}