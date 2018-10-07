package pro.buildmysoftware.testlimits.order.glue;

import pro.buildmysoftware.testlimits.order.bad.BadOrder;
import pro.buildmysoftware.testlimits.order.common.PlaceOrderCommand;

public interface PlaceOrderService {
	BadOrder placeOrder(PlaceOrderCommand command);
}
