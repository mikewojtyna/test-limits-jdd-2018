package pro.buildmysoftware.testlimits.order.glue;

import pro.buildmysoftware.testlimits.order.bad.Order;
import pro.buildmysoftware.testlimits.order.bad.PlaceOrderCommand;

public interface PlaceOrderService {
	Order placeOrder(PlaceOrderCommand command);
}
