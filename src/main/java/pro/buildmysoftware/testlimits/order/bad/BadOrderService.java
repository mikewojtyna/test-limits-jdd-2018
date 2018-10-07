package pro.buildmysoftware.testlimits.order.bad;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pro.buildmysoftware.testlimits.order.common.OrderLine;

import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;

public class BadOrderService {
	private final BadOrderRepository repository;

	public BadOrderService(final BadOrderRepository repository) {
		this.repository = repository;
	}

	public void placeOrder(final BadOrder order) {
		applyDiscount(order);
		repository.save(order);
	}

	private void applyDiscount(final BadOrder order) {
		final LocalDate now = LocalDate.now();
		if (now.getMonth() == Month.DECEMBER && now.getDayOfMonth() <
			24) {
			final Money afterDiscount = calculateTotalCost(order)
				.multipliedBy(0.8, RoundingMode.DOWN);
			order.setTotalCost(afterDiscount);
		}
		else {
			final Money totalCost = calculateTotalCost(order);
			if (totalCost.isGreaterThan(Money.of(CurrencyUnit.USD,
				350))) {
				final Money afterDiscount = totalCost
					.multipliedBy(0.90, RoundingMode.DOWN);
				order.setTotalCost(afterDiscount);
			}
			else if (totalCost.isGreaterThan(Money.of(CurrencyUnit
				.USD, 200))) {
				final Money afterDiscount = totalCost
					.multipliedBy(0.95, RoundingMode.DOWN);
				order.setTotalCost(afterDiscount);
			}
		}
		// repeat this for each other discount
		// ...
	}

	private Money calculateTotalCost(final BadOrder order) {
		return order.getLines().stream().map(OrderLine::getPrice)
			.reduce(Money.zero(CurrencyUnit.USD), (acc, curr) ->
				acc.plus(curr));
	}
}
