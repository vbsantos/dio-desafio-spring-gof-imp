package dio.shipping.price.application;

import dio.shipping.price.domain.ShippingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item")
public class ShippingItemController {
    @Autowired
    private ShippingService shippingService;

    @PostMapping
    public ResponseEntity<ShippingItem> saveItem(@RequestBody ShippingItem item) {
        return ResponseEntity.ok(shippingService.saveShippingItem(item));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingItem> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(shippingService.getShippingItemById(id));
    }
}