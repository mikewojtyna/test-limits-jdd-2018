package pro.buildmysoftware.testlimits.order.good;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pro.buildmysoftware.testlimits.order.common.OrderLine;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;

class GoodOrder {
	private final Collection<OrderLine> orderLines;

	GoodOrder(final OrderLine... orderLines) {
		this.orderLines = Arrays.asList(orderLines);
	}

	Money calculateTotalCost(final DiscountPolicy policy) {
		final double discount = policy.discountFor(this);
		return sum().multipliedBy(discount, RoundingMode.DOWN);
	}

	Money sum() {
		return orderLines.stream().map(OrderLine::getPrice).reduce
			(Money.zero(CurrencyUnit.USD), Money::plus);
	}
}
