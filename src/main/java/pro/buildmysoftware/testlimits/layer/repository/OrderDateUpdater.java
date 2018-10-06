package pro.buildmysoftware.testlimits.layer.repository;

import pro.buildmysoftware.testlimits.layer.model.Order;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class OrderDateUpdater {
	@PrePersist
	void updateDate(Order order) {
		// update to the current time
		order.setDate(LocalDateTime.now());
	}
}
