package pro.buildmysoftware.testlimits.order.good;

import pro.buildmysoftware.testlimits.order.bad.PlaceOrderCommand;

public interface OrderFacade {
	void placeOrder(PlaceOrderCommand command);
}
