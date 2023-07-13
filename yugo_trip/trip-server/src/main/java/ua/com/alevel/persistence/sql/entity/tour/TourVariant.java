package ua.com.alevel.persistence.sql.entity.tour;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import ua.com.alevel.persistence.sql.entity.BaseEntity;

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
    private String priceFist;

    @Column(nullable = false)
    private String priceSecond;

    @ManyToOne
    private Tour tour;
}