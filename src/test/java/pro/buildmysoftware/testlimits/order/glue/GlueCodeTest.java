package pro.buildmysoftware.testlimits.order.glue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.testlimits.order.bad.*;
import pro.buildmysoftware.testlimits.order.common.OrderRepository;
import pro.buildmysoftware.testlimits.order.common.OrderStatisticsService;

import static org.mockito.Mockito.*;

class GlueCodeTest {

	@DisplayName("should place order")
	@Test
	void test() throws Exception {
		// given
		PlaceOrderCommand command = placeCommand();
		// configure the place order service
		PlaceOrderService placeOrderService = mock(PlaceOrderService
			.class);
		Order order = new Order();
		when(placeOrderService.placeOrder(command)).thenReturn(order);
		// configure the repository
		OrderRepository repository = mock(OrderRepository.class);
		Order savedOrder = new Order();
		when(repository.save(order)).thenReturn(savedOrder);
		OrderStatisticsService statsService = mock
			(OrderStatisticsService.class);
		GlueOrderService service = new GlueOrderService
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
