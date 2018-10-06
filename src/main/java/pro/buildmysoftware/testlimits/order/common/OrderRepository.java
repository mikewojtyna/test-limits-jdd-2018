package pro.buildmysoftware.testlimits.order.common;

import org.springframework.data.repository.CrudRepository;
import pro.buildmysoftware.testlimits.order.bad.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
