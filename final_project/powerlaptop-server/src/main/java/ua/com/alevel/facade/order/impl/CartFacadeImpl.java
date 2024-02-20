package ua.com.alevel.facade.order.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.data.dto.order.CartDto;
import ua.com.alevel.data.dto.order.CartEntryDto;
import ua.com.alevel.data.dto.order.ProductOrderDto;
import ua.com.alevel.facade.order.CartFacade;
import ua.com.alevel.persistence.sql.entity.order.Cart;
import ua.com.alevel.persistence.sql.entity.order.CartEntry;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.service.crud.product.ProductVariantCrudService;
import ua.com.alevel.service.order.CartService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CartFacadeImpl implements CartFacade {

    private final CartService cartService;
    private final ProductVariantCrudService productVariantCrudService;

    @Override
    public CartDto findActive() {
        Cart cart = cartService.getActive();
        List<CartEntry> cartEntries = cartService.findByCart(cart);
        List<ProductVariant> productVariants = new ArrayList<>();
        BigDecimal price = new BigDecimal("00.00");
        for (CartEntry cartEntry : cartEntries) {
            ProductVariant productVariant = cartEntry.getProductVariant();
            if (productVariant != null) {
                productVariants.add(productVariant);
                BigDecimal variantPrice = productVariant.getPrice();
                variantPrice = variantPrice.multiply(new BigDecimal(cartEntry.getQuantity()));
                price = price.add(variantPrice);
            }
        }
        CartDto cartDto = new CartDto(cart, productVariants);
        cartDto.setPrice(price.toString());
        for (int i = 0; i < cartEntries.size(); i++) {
            for (int i1 = 0; i1 < cartDto.getEntries().size(); i1++) {
                if (i == i1) {
                    ProductOrderDto productOrderDto = cartDto.getEntries().get(i);
                    productOrderDto.setQuantity(cartEntries.get(i).getQuantity());
                }
            }
        }
        return cartDto;
    }

    @Override
    public void add(CartEntryDto dto) {
        CartEntry cartEntry = new CartEntry();
        ProductVariant productVariant = productVariantCrudService.findById(dto.getProductVariantId());
        cartEntry.setProductVariant(productVariant);
        cartEntry.setQuantity(dto.getQuantity());
        cartService.add(cartEntry);
    }

    @Override
    public void update(CartEntryDto dto) {

    }

    @Override
    public void remove(CartEntryDto dto) {

    }

    @Override
    public void clear() {

    }
}
