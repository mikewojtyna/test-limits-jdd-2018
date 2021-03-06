package pro.buildmysoftware.testlimits.layer.model;

import org.joda.money.Money;
import pro.buildmysoftware.testlimits.layer.repository.OrderDateUpdater;
import pro.buildmysoftware.testlimits.order.common.OrderLine;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(OrderDateUpdater.class)
public class Order {
	private boolean isPlaced;
	private List<OrderLine> lines;
	private Money totalCost;
	private LocalDateTime date;

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(final LocalDateTime placeDate) {
		this.date = placeDate;
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
