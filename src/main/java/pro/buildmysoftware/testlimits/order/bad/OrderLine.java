package pro.buildmysoftware.testlimits.order.bad;

import org.joda.money.Money;

import java.util.Objects;

public class OrderLine {
	private Money price;

	public OrderLine() {
	}

	public OrderLine(Money price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		OrderLine orderLine = (OrderLine) o;
		return Objects.equals(price, orderLine.price);
	}

	@Override
	public int hashCode() {

		return Objects.hash(price);
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}
}
