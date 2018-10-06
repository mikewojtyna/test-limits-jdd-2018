package pro.buildmysoftware.testlimits.order.good;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.buildmysoftware.testlimits.order.bad.PlaceOrderCommand;

@RestController
@RequestMapping("/good/orders")
class GoodOrderController {
	private OrderFacade facade;

	@PostMapping
	void placeOrder(PlaceOrderCommand command) {
		facade.placeOrder(command);
	}
}
