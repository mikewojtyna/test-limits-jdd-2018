package pro.buildmysoftware.testlimits.order.good;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pro.buildmysoftware.testlimits.order.bad.OrderLine;

import java.math.RoundingMode;
import java.util.Collection;

class GoodOrder {
	private Collection<OrderLine> orderLines;

	Money calculateTotalCost(DiscountPolicy policy) {
		double discount = policy.discountFor(this);
		return sumOrderLines().multipliedBy(discount, RoundingMode
			.DOWN);
	}

	private Money sumOrderLines() {
		return orderLines.stream().map(OrderLine::getPrice).reduce
			(Money.zero(CurrencyUnit.USD), (acc, curr) -> acc.plus
				(curr));
	}
}
