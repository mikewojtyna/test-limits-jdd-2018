package pro.buildmysoftware.testlimits.order.bad;

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

import java.util.Arrays;

import static org.assertj.core.api.Fail.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request
	.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result
	.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result
	.MockMvcResultMatchers.status;

@WebMvcTest
@SpringJUnitConfig(OrderApp.class)
public class BadOrderControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BadOrderRepository orderRepository;
	@MockBean
	BadOrderStatisticsService statisticsService;

	@DisplayName("should calculate total cost and set paid status")
	@Test
	void test0() throws Exception {
		// given
		final String orderJson = "{ \"isPlaced\": true, \"lines\": [ "
			+ "{\"price\": " + "\"USD 10.00\"}, " + "{\"price\": "
			+ "\"USD 20.00\"} ] }";
		final BadOrder expectedOrder = new BadOrder();
		expectedOrder.setLines(Arrays.asList(new OrderLine(Money.of
			(CurrencyUnit.USD, 10.00)), new OrderLine(Money.of
			(CurrencyUnit.USD, 20.00))));
		expectedOrder.setPlaced(true);
		expectedOrder.setTotalCost(Money.of(CurrencyUnit.USD, 30.00));

		// @formatter:off
		// when
		mockMvc.perform(post("/bad/orders").content(orderJson)
			.contentType(MediaType.APPLICATION_JSON_UTF8))
			.andDo(print())

		// then
		.andExpect(status().isOk());
		// @formatter:on
		verify(orderRepository, times(1)).save(expectedOrder);
	}

	@DisplayName("should calculate total cost when order is empty")
	@Test
	void test1() throws Exception {
		// given

		// when

		// then
		fail("Write your test");
	}

	@DisplayName("should update order statistics")
	@Test
	void test() throws Exception {
		// given

		// when

		// then
		fail("Write your test");
	}

	@DisplayName("should calculate total cost when order contains " +
		"different currencies")
	@Test
	void test3() throws Exception {
		// given

		// when

		// then
		fail("Write your test");
	}

	@DisplayName("should save in repository")
	@Test
	void test2() throws Exception {
		// given

		// when

		// then
		fail("Write your test");
	}
}
