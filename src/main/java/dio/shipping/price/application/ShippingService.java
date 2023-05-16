package dio.shipping.price.application;

import dio.shipping.price.domain.ShippingCalculator;
import dio.shipping.price.domain.ShippingItem;
import dio.shipping.price.domain.enums.ShippingPricingTypes;
import dio.shipping.price.domain.DimensionBasedShippingStrategy;
import dio.shipping.price.domain.WeightBasedShippingStrategy;
import dio.shipping.price.infrastructure.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    @Autowired
    private ShippingRepository shippingRepository;

    public double calculateShippingCost(Long shippingItemId, ShippingPricingTypes type) throws RuntimeException {
        ShippingCalculator shippingCalculator = switch (type) {
            case DIMENSIONS -> new ShippingCalculator(new DimensionBasedShippingStrategy());
            case WEIGHT -> new ShippingCalculator(new WeightBasedShippingStrategy());
            default -> throw new RuntimeException("Base de cálculo desconhecida");
        };

        ShippingItem item = shippingRepository
            .findById(shippingItemId)
            .orElseThrow(() -> new RuntimeException("Item com id " + shippingItemId + " não encontrado"));

        return shippingCalculator.calculateShipping(item);
    }

    public ShippingItem saveShippingItem(ShippingItem item) {
        return shippingRepository.save(item);
    }

    public ShippingItem getShippingItemById(Long shippingItemId) throws RuntimeException {
        return shippingRepository
                .findById(shippingItemId)
                .orElseThrow(() -> new RuntimeException("Item com id " + shippingItemId + " não encontrado"));
    }
}
