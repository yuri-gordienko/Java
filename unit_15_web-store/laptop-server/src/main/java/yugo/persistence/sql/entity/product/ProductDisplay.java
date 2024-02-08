//package yugo.persistence.sql.entity.product;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import yugo.persistence.sql.entity.BaseEntity;
//import yugo.util.types_of_laptops.DisplayType;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "product_displays")
//public class ProductDisplay extends BaseEntity {
//
//    @Column(name = "display_resolution", nullable = false)
//    private String displayResolution;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "display_type", nullable = false)
//    private DisplayType displayType;
//
//    @Column(name = "display_size", nullable = false)
//    private String displaySize;
//
//    @Column(nullable = false)
//    private Integer brightness;
//
//    @Column(name = "aspect_ratio", nullable = false)
//    private String aspectRatio;
//
//    @Column(name = "contrast_ratio", nullable = false)
//    private String contrastRatio;
//
//    @Column(name = "color_gamut", nullable = false)
//    private String colorGamut;
//
//    @Column(nullable = false)
//    private Integer hz;
//
//    @Column(nullable = false)
//    private Boolean touch;
//
//    public ProductDisplay() {
//        this.touch = false;
//    }
//}