package pro.buildmysoftware.testlimits.order.glue;

import pro.buildmysoftware.testlimits.order.bad.*;
import pro.buildmysoftware.testlimits.order.common.OrderRepository;
import pro.buildmysoftware.testlimits.order.common.OrderStatisticsService;

public class GlueOrderService {
	private PlaceOrderService service;
	private OrderRepository repository;
	private OrderStatisticsService statisticsService;

	public GlueOrderService(PlaceOrderService service, OrderRepository
		repository, OrderStatisticsService statisticsService) {
		this.service = service;
		this.repository = repository;
		this.statisticsService = statisticsService;
	}

	void placeOrder(PlaceOrderCommand command) {
		// is there any logic here?
		Order order = service.placeOrder(command);
		Order savedOrder = repository.save(order);
		statisticsService.updateStatistics(savedOrder);
	}
}
