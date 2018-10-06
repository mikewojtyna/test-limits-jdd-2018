package pro.buildmysoftware.testlimits.order.bad;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pro.buildmysoftware.testlimits.order.common.OrderRepository;

import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;

public class OrderService {
	OrderRepository repository;

	public void placeOrder(Order order) {
		applyDiscount(order);
		repository.save(order);
	}

	private void applyDiscount(Order order) {
		LocalDate now = LocalDate.now();
		if (now.getMonth() == Month.DECEMBER && now.getDayOfMonth() <
			24) {
			Money afterDiscount = calculateTotalCost(order)
				.multipliedBy(0.8, RoundingMode.DOWN);
			order.setTotalCost(afterDiscount);
		}
		else {
			Money totalCost = calculateTotalCost(order);
			if (totalCost.isGreaterThan(Money.of(CurrencyUnit.USD,
				350))) {
				Money afterDiscount = totalCost.multipliedBy
					(0.90, RoundingMode.DOWN);
				order.setTotalCost(afterDiscount);
			}
			else if (totalCost.isGreaterThan(Money.of(CurrencyUnit
				.USD, 200))) {
				Money afterDiscount = totalCost.multipliedBy
					(0.95, RoundingMode.DOWN);
				order.setTotalCost(afterDiscount);
			}
		}
		// repeat this for each other discount
		// ...
	}

	private Money calculateTotalCost(Order order) {
		return order.getLines().stream().map(OrderLine::getPrice)
			.reduce(Money.zero(CurrencyUnit.USD), (acc, curr) ->
				acc.plus(curr));
	}
}
