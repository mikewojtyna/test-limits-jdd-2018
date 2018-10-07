package pro.buildmysoftware.testlimits.order.good;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import pro.buildmysoftware.testlimits.order.OrderApp;
import pro.buildmysoftware.testlimits.order.common.OrderLine;
import pro.buildmysoftware.testlimits.order.common.PlaceOrderCommand;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request
	.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result
	.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GoodOrderController.class)
@SpringJUnitConfig(OrderApp.class)
public class GoodOrderControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private OrderFacade orderFacade;

	@DisplayName("should deserialize command and delegate to the facade")
	@Test
	void test() throws Exception {
		// given
		// @formatter:off
		final String commandJson =
			"{ \"orderLines\": [{\"price\": \"USD 10.00\"}] }";
		// @formatter:on
		final PlaceOrderCommand expectedCommand = new
			PlaceOrderCommand(new OrderLine(Money.of(CurrencyUnit
			.USD, 10.00)));

		// when
		// @formatter:off
		mockMvc.perform(post("/good/orders")
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.content(commandJson)
		)

		// then
		.andExpect(status().isOk());
		// @formatter:on
		verify(orderFacade, times(1)).placeOrder(expectedCommand);
	}
}
