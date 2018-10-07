package pro.buildmysoftware.testlimits.order.glue;

import pro.buildmysoftware.testlimits.order.bad.BadOrder;
import pro.buildmysoftware.testlimits.order.bad.BadOrderRepository;
import pro.buildmysoftware.testlimits.order.bad.BadOrderStatisticsService;
import pro.buildmysoftware.testlimits.order.common.PlaceOrderCommand;

public class GlueOrderService {
	private final PlaceOrderService service;
	private final BadOrderRepository repository;
	private final BadOrderStatisticsService statisticsService;

	public GlueOrderService(final PlaceOrderService service, final
	BadOrderRepository repository, final BadOrderStatisticsService
		statisticsService) {
		this.service = service;
		this.repository = repository;
		this.statisticsService = statisticsService;
	}

	void placeOrder(final PlaceOrderCommand command) {
		// is there any logic here?
		final BadOrder order = service.placeOrder(command);
		final BadOrder savedOrder = repository.save(order);
		statisticsService.updateStatistics(savedOrder);
	}
}
