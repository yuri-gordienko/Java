package ua.com.alevel.dto;

import ua.com.alevel.util.Color;

public class ElectivesDto {

    private Long id;
    private String name;
    private Long pupilsCount;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Long getPupilsCount() {

        return pupilsCount;
    }

    public void setPupilsCount(Long pupilsCount) {

        this.pupilsCount = pupilsCount;
    }

    @Override
    public String toString() {
        Color.Colors color;
        return "> ID " + id + ", назва: '" + name + "'" + ", кількість студентів на курсі: " +
                Color.Colors.RED + pupilsCount + Color.Colors.YELLOW;
    }
}
