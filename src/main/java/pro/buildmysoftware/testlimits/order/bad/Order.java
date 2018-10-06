package pro.buildmysoftware.testlimits.order.bad;

import org.joda.money.Money;

import java.util.List;
import java.util.Objects;

public class Order {
	private boolean isPlaced;
	private List<OrderLine> lines;
	private Money totalCost;

	@Override
	public String toString() {
		return "Order{" + "isPlaced=" + isPlaced + ", lines=" + lines
			+ ", totalCost=" + totalCost + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Order order = (Order) o;
		return isPlaced == order.isPlaced && Objects.equals(lines,
			order.lines) && Objects.equals(totalCost, order
			.totalCost);
	}

	@Override
	public int hashCode() {

		return Objects.hash(isPlaced, lines, totalCost);
	}

	public List<OrderLine> getLines() {
		return lines;
	}

	public void setLines(List<OrderLine> lines) {
		this.lines = lines;
	}

	public Money getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Money totalCost) {
		this.totalCost = totalCost;
	}

	public boolean isPlaced() {
		return isPlaced;
	}

	public void setPlaced(boolean placed) {
		isPlaced = placed;
	}
}
