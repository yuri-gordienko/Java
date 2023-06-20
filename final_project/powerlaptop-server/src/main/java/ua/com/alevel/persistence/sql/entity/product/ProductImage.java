package ua.com.alevel.persistence.sql.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import ua.com.alevel.persistence.sql.entity.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_images")
public class ProductImage extends BaseEntity {

    @Column(name = "image_url", nullable = false)   // храним в БД не полноценные картинки, а ссылки на них (место экономим)
    private String imageUrl;

    @Column(name = "main_image", nullable = false)  // определяем главную картинку
    private Boolean mainImage;

    // т.к. много ноутов с различными вариациями, а картинки для них одни и теже (но их тоже много на 1 ноут,)
    // связь делаем мени ту мени
    @ManyToMany(mappedBy = "productImages")
    private Set<Product> products = new HashSet<>();

    public ProductImage() { // конструктор
        super();    // конструктор папа на случай, если у папы что-то добавим
        this.mainImage = false;     // по дефолту фолс
    }
}
