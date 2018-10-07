package pro.buildmysoftware.testlimits.order.glue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.testlimits.order.bad.BadOrder;
import pro.buildmysoftware.testlimits.order.bad.BadOrderRepository;
import pro.buildmysoftware.testlimits.order.bad.BadOrderStatisticsService;
import pro.buildmysoftware.testlimits.order.common.PlaceOrderCommand;

import static org.mockito.Mockito.*;

class GlueCodeTest {

	@DisplayName("should place order")
	@Test
	void test() throws Exception {
		// given
		final PlaceOrderCommand command = placeCommand();
		// configure the place order service
		final PlaceOrderService placeOrderService = mock
			(PlaceOrderService.class);
		final BadOrder order = new BadOrder();
		when(placeOrderService.placeOrder(command)).thenReturn(order);
		// configure the repository
		final BadOrderRepository repository = mock(BadOrderRepository
			.class);
		final BadOrder savedOrder = new BadOrder();
		when(repository.save(order)).thenReturn(savedOrder);
		final BadOrderStatisticsService statsService = mock
			(BadOrderStatisticsService.class);
		final GlueOrderService service = new GlueOrderService
			(placeOrderService, repository, statsService);

		// when
		service.placeOrder(command);

		// then
		verify(placeOrderService, times(1)).placeOrder(command);
		verify(repository, times(1)).save(order);
		verify(statsService, times(1)).updateStatistics(savedOrder);
	}

	private PlaceOrderCommand placeCommand() {
		return new PlaceOrderCommand();
	}
}
