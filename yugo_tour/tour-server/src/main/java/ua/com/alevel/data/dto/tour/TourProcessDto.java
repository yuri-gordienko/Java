package ua.com.alevel.data.dto.tour;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class TourProcessDto {

    private Long tourVariantId;
    private Set<Long> tourImages;
}
