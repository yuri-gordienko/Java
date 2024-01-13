package ua.com.alevel.persistence.sql.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.type.ProductBrandType;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity // даем понять Спрингу тип класса
@Table(name = "products") // даем название таблицу такое, как хотим чтоб она называлась в БД
public class Product extends BaseEntity {

    @Column(nullable = false)   // колонка не может быть пустой
    private String name;

    @Enumerated(EnumType.STRING)    // говорим что бренд это енам и храним его в БД как Стринг
    @Column(name = "product_brand", nullable = false, updatable = false) // не пустой, не изменяемый
    private ProductBrandType productBrand;

    @Column(columnDefinition = "TEXT") // описание может быть большим, храним как текст
    private String description;

    // связь делаем мени ту мени
    // т.к. много ноутов с различными вариациями, а картинки для них одни и теже (но их тоже много на 1 ноут)
    // еслиб мени ту ван, то дублировались бы картинки для каждого варианта продукта
    @ManyToMany
    @JoinTable(
            name = "product_image",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "product_image_id")
    )
    private Set<ProductImage> productImages = new HashSet<>();
}