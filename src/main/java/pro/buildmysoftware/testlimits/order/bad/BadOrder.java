package pro.buildmysoftware.testlimits.order.bad;

import org.joda.money.Money;
import pro.buildmysoftware.testlimits.order.common.OrderLine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;
import java.util.Objects;

@Entity
public class BadOrder {
	@Id
	@GeneratedValue
	private Long id;
	@Transient
	private boolean isPlaced;
	@Transient
	private List<OrderLine> lines;
	@Transient
	private Money totalCost;

	@Override
	public String toString() {
		return "Order{" + "isPlaced=" + isPlaced + ", lines=" + lines
			+ ", totalCost=" + totalCost + '}';
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final BadOrder order = (BadOrder) o;
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

	public void setLines(final List<OrderLine> lines) {
		this.lines = lines;
	}

	public Money getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(final Money totalCost) {
		this.totalCost = totalCost;
	}

	public boolean isPlaced() {
		return isPlaced;
	}

	public void setPlaced(final boolean placed) {
		isPlaced = placed;
	}
}
