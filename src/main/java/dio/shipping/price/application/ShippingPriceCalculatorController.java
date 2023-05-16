package dio.shipping.price.application;

import dio.shipping.price.domain.enums.ShippingPricingTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("price")
public class ShippingPriceCalculatorController {
    @Autowired
    private ShippingService shippingService;

    @GetMapping("/by-weight/{id}")
    public ResponseEntity<Double> shippingPriceByWeight(@PathVariable Long id) {
        Double price = shippingService.calculateShippingCost(id, ShippingPricingTypes.WEIGHT);
        return ResponseEntity.ok(price);
    }

    @GetMapping("/by-dimension/{id}")
    public ResponseEntity<Double> shippingPriceByDimension(@PathVariable Long id) {
        Double price = shippingService.calculateShippingCost(id, ShippingPricingTypes.DIMENSIONS);
        return ResponseEntity.ok(price);
    }
}
