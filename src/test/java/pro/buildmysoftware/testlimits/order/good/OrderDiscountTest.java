package pro.buildmysoftware.testlimits.order.good;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.testlimits.order.common.OrderLine;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderDiscountTest {
	@DisplayName("should apply discount")
	@Test
	void test() throws Exception {
		// given
		final GoodOrder order = new GoodOrder(new OrderLine(Money.of
			(CurrencyUnit.USD, 100.00)), new OrderLine(Money.of
			(CurrencyUnit.USD, 60.00)));
		final DiscountPolicy discountPolicy = o -> 0.5;

		// when
		final Money totalCost = order.calculateTotalCost
			(discountPolicy);

		// then
		assertThat(totalCost).isEqualTo(Money.of(CurrencyUnit.USD,
			80.0));
	}
}
