package ua.com.alevel.persistence.sql.entity.tour;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import ua.com.alevel.persistence.sql.entity.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tour_images")
public class TourImage extends BaseEntity {

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "main_image", nullable = false)
    private Boolean mainImage;

//    @ManyToOne
//    private Tour tour;

    @ManyToMany(mappedBy = "tourImages")
    private Set<Tour> tours = new HashSet<>();

    public TourImage() {
        super();
        this.mainImage = false;
    }
}
