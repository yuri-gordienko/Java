package ua.com.alevel.Jdbc_crud.dto;

import ua.com.alevel.util.Color;

// промежуточный java объект, который не Entity класс!, задача вытащить промежуточную инфо, отдать и удалит гарбаж коллектор
public class ElectivesDto {

    private Long id;
    private String name;
    private Long pupilsCount; // jdbc конвертирует только тип Long

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
        return "> ID " + id + ", назва: '" + name + "'" + ", кількість учнів на факультативі: " +
                Color.Colors.RED + pupilsCount + Color.Colors.YELLOW;
    }
}
