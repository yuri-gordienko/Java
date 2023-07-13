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
@Table(name = "tour_videos")
public class TourVideo extends BaseEntity {

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToMany(mappedBy = "tourVideos")
    private Set<Tour> tours = new HashSet<>();
}
