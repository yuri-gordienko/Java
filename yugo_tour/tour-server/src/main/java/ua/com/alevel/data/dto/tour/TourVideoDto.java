package ua.com.alevel.data.dto.tour;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import ua.com.alevel.data.dto.BaseDto;
import ua.com.alevel.persistence.sql.entity.tour.TourVideo;

@Getter
@Setter
@NoArgsConstructor
public class TourVideoDto extends BaseDto {

     private String videoUrl;

     public TourVideoDto(TourVideo tourVideo) {
          setId(tourVideo.getId());
          this.videoUrl = tourVideo.getVideoUrl();
     }
}
