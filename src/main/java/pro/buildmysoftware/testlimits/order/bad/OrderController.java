package pro.buildmysoftware.testlimits.order.bad;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.buildmysoftware.testlimits.order.common.OrderRepository;
import pro.buildmysoftware.testlimits.order.common.OrderStatisticsService;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/bad/orders")
@SuppressWarnings("Duplicates")
public class OrderController {
	private OrderRepository orderRepository;
	private OrderStatisticsService orderStatisticsService;

	public OrderController(OrderRepository orderRepository,
			       OrderStatisticsService orderStatisticsService) {
		this.orderRepository = orderRepository;
		this.orderStatisticsService = orderStatisticsService;
	}

	@Transactional
	@PostMapping
	public void placeOrder(@RequestBody Order order) {
		Money totalCost = order.getLines().stream().map
			(OrderLine::getPrice).reduce(Money.zero(CurrencyUnit
			.USD), (acc, curr) -> acc.plus(curr));
		order.setTotalCost(totalCost);
		order.setPlaced(true);
		orderRepository.save(order);
		orderStatisticsService.updateStatistics(order);
	}
}
