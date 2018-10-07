package pro.buildmysoftware.testlimits.order.glue;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Long> {
	Collection<User> findByName(String name);
}
