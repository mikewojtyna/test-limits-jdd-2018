package pro.buildmysoftware.testlimits.order.bad;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.buildmysoftware.testlimits.order.common.OrderLine;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/bad/orders")
@SuppressWarnings("Duplicates")
public class BadOrderController {
	private final BadOrderRepository orderRepository;
	private final BadOrderStatisticsService orderStatisticsService;

	public BadOrderController(final BadOrderRepository orderRepository,
				  final BadOrderStatisticsService
					  orderStatisticsService) {
		this.orderRepository = orderRepository;
		this.orderStatisticsService = orderStatisticsService;
	}

	@Transactional
	@PostMapping
	public void placeOrder(@RequestBody final BadOrder order) {
		final Money totalCost = order.getLines().stream().map
			(OrderLine::getPrice).reduce(Money.zero(CurrencyUnit
			.USD), (acc, curr) -> acc.plus(curr));
		order.setTotalCost(totalCost);
		order.setPlaced(true);
		orderRepository.save(order);
		orderStatisticsService.updateStatistics(order);
	}
}
