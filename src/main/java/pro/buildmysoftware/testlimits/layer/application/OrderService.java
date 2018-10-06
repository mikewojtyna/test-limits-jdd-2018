package pro.buildmysoftware.testlimits.layer.application;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.stereotype.Service;
import pro.buildmysoftware.testlimits.layer.model.Order;
import pro.buildmysoftware.testlimits.layer.repository.OrderRepository;
import pro.buildmysoftware.testlimits.order.bad.OrderLine;

@SuppressWarnings("Duplicates")
public class OrderService {

	private OrderRepository orderRepository;
	private OrderStatisticsService orderStatisticsService;

	public OrderService(OrderRepository orderRepository,
			    OrderStatisticsService orderStatisticsService) {
		this.orderRepository = orderRepository;
		this.orderStatisticsService = orderStatisticsService;
	}

	public void placeOrder(Order order) {
		Money totalCost = order.getLines().stream().map
			(OrderLine::getPrice).reduce(Money.zero(CurrencyUnit
			.USD), (acc, curr) -> acc.plus(curr));
		order.setTotalCost(totalCost);
		order.setPlaced(true);
		orderRepository.save(order);
		orderStatisticsService.updateStatistics(order);
	}
}
