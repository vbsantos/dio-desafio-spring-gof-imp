package dio.shipping.price.domain;

import dio.shipping.price.domain.interfaces.ShippingStrategy;

public class WeightBasedShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateShippingCost(ShippingItem item) {
        return item.getWeight() * 9;
    }
}
