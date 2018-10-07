package pro.buildmysoftware.testlimits.order.good;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pro.buildmysoftware.testlimits.order.common.OrderLine;

import java.math.RoundingMode;
import java.util.Collection;

class GoodOrder {
	private Collection<OrderLine> orderLines;

	Money calculateTotalCost(final DiscountPolicy policy) {
		final double discount = policy.discountFor(this);
		return sumOrderLines().multipliedBy(discount, RoundingMode
			.DOWN);
	}

	private Money sumOrderLines() {
		return orderLines.stream().map(OrderLine::getPrice).reduce
			(Money.zero(CurrencyUnit.USD), Money::plus);
	}
}
