package pro.buildmysoftware.testlimits.order.good;

import pro.buildmysoftware.testlimits.order.common.PlaceOrderCommand;

public interface OrderFacade {
	void placeOrder(PlaceOrderCommand command);
}
