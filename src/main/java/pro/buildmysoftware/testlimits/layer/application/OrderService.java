package pro.buildmysoftware.testlimits.layer.application;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pro.buildmysoftware.testlimits.layer.model.Order;
import pro.buildmysoftware.testlimits.layer.repository.OrderRepository;
import pro.buildmysoftware.testlimits.order.common.OrderLine;

@SuppressWarnings("Duplicates")
public class OrderService {

	private final OrderRepository orderRepository;
	private final OrderStatisticsService orderStatisticsService;

	public OrderService(final OrderRepository orderRepository, final
	OrderStatisticsService orderStatisticsService) {
		this.orderRepository = orderRepository;
		this.orderStatisticsService = orderStatisticsService;
	}

	public void placeOrder(final Order order) {
		final Money totalCost = order.getLines().stream().map
			(OrderLine::getPrice).reduce(Money.zero(CurrencyUnit
			.USD), (acc, curr) -> acc.plus(curr));
		order.setTotalCost(totalCost);
		order.setPlaced(true);
		orderRepository.save(order);
		orderStatisticsService.updateStatistics(order);
	}
}
