package dio.shipping.price.infrastructure;

import dio.shipping.price.domain.ShippingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<ShippingItem, Long> { }
