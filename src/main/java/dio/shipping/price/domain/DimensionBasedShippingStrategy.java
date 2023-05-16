package dio.shipping.price.domain;

import dio.shipping.price.domain.interfaces.ShippingStrategy;

public class DimensionBasedShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateShippingCost(ShippingItem item) {
        return item.getHeight() * item.getLength() * item.getWeight() * 3;
    }
}
