package ua.com.alevel.persistence.sql.entity.tour;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Digits;

import lombok.Getter;
import lombok.Setter;

import ua.com.alevel.persistence.sql.entity.BaseEntity;

//import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tour_variants")
public class TourVariant extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String rout;

    @Column(nullable = false)
    private String durationFist;

    @Column(nullable = false)
    private String durationSecond;

    @Column(nullable = false)
    private String nutrition;

    @Column(nullable = false)
////    @Digits(integer = 6, fraction = 2)
    private String priceFist;

    @Column(nullable = false)
////    @Digits(integer = 6, fraction = 2)
    private String priceSecond;

    @ManyToOne
    private Tour tour;
}