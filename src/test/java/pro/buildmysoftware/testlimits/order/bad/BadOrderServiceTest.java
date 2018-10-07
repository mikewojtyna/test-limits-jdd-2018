package pro.buildmysoftware.testlimits.order.bad;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.testlimits.order.common.OrderLine;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Fail.fail;
import static org.mockito.Mockito.*;

public class BadOrderServiceTest {

	private BadOrderService service;

	@DisplayName("should apply xmas discount")
	@Test
	void test0() throws Exception {
		// given
		final BadOrder order = new BadOrder();
		final List<OrderLine> orderLines = Arrays.asList(new OrderLine
			(Money.of(CurrencyUnit.USD, 100.00)), new OrderLine
			(Money.of(CurrencyUnit.USD, 60.00)));
		order.setLines(orderLines);
		final BadOrderRepository repo = mock(BadOrderRepository.class);
		service = new BadOrderService(repo);
		final BadOrder expectedOrder = new BadOrder();
		expectedOrder.setLines(orderLines);
		expectedOrder.setTotalCost(Money.of(CurrencyUnit.USD, 128.00));

		// when
		service.placeOrder(order);

		// then
		verify(repo, times(1)).save(expectedOrder);
	}

	@DisplayName("should apply greater than 350 discount")
	@Test
	void test1() throws Exception {
		// given

		// when

		// then
		fail("Write your test");
	}

	@DisplayName("should apply 200 discount")
	@Test
	void test2() throws Exception {
		// given

		// when

		// then
		fail("Write your test");
	}

	@DisplayName("should apply only xmas discount when other discounts " +
		"also qualify")
	@Test
	void test3() throws Exception {
		// given

		// when

		// then
		fail("Write your test");
	}

	@DisplayName("should apply 350 discount when 200 also qualifies")
	@Test
	void test4() throws Exception {
		// given

		// when

		// then
		fail("Write your test");
	}

	@DisplayName("should apply 200 discount when others don't qualify")
	@Test
	void test5() throws Exception {
		// given

		// when

		// then
		fail("Write your test");
	}
}
