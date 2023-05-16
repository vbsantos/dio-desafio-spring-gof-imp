package dio.shipping.price.domain;

import dio.shipping.price.domain.interfaces.ShippingStrategy;

public class ShippingCalculator {
    private final ShippingStrategy shippingStrategy;

    public ShippingCalculator(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateShipping(ShippingItem item) {
        return shippingStrategy.calculateShippingCost(item);
    }
}
