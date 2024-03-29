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
@Table(name = "tours")
public class Tour extends BaseEntity {

    @Column(nullable = false, unique = true, updatable = false)
    private String country;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, unique = true)
    private String price;

    @ManyToMany
    @JoinTable(
            name = "tour_image",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_image_id")
    )
    private Set<TourImage> tourImages = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "tour_video",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_video_id")
    )
    private Set<TourVideo> tourVideos = new HashSet<>();
}