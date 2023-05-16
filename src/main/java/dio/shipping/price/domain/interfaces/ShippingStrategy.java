package dio.shipping.price.domain.interfaces;

import dio.shipping.price.domain.ShippingItem;

public interface ShippingStrategy {
    double calculateShippingCost(ShippingItem item);
}
