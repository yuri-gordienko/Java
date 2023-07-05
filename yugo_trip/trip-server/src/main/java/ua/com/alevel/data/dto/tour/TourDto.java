package ua.com.alevel.data.dto.tour;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import ua.com.alevel.data.dto.BaseDto;
import ua.com.alevel.persistence.sql.entity.tour.Tour;

@Getter
@Setter
@NoArgsConstructor
public class TourDto extends BaseDto {

    private String country;
    private String description;
    private String price;

    public TourDto(Tour tour) {
        setId(tour.getId());
        this.country = tour.getCountry();
        this.description = tour.getDescription();
        this.price = tour.getPrice();
    }
}
