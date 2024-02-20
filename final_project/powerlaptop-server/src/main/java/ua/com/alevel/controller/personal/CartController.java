package ua.com.alevel.controller.personal;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.data.dto.order.CartDto;
import ua.com.alevel.data.dto.order.CartEntryDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.order.CartFacade;

@RestController
@AllArgsConstructor
@RequestMapping("/api/private/personal/cart")
@PreAuthorize("hasRole('PERSONAL')")
public class CartController {

    private final CartFacade cartFacade;

    @GetMapping
    @PreAuthorize("hasAuthority('personal:read')")
    public ResponseEntity<DataContainer<CartDto>> getCart() {
        return ResponseEntity.ok(new DataContainer<>(cartFacade.findActive()));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('personal:create')")
    public ResponseEntity<DataContainer<Boolean>> add(@RequestBody CartEntryDto cartEntryDto) {
        cartFacade.add(cartEntryDto);
        return ResponseEntity.ok(new DataContainer<>(Boolean.TRUE));
    }
}
