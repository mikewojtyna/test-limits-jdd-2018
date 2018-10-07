package pro.buildmysoftware.testlimits.order.glue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pro.buildmysoftware.testlimits.order.OrderApp;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@SpringJUnitConfig(OrderApp.class)
public class UserFinderIntegrationTest {
	@Autowired
	private UserRepository repo;

	@DisplayName("should find user by name")
	@Test
	void test() throws Exception {
		// given
		// save some users
		final User foobar = new User("foobar");
		repo.save(foobar);
		final User goobar = new User("goobar");
		repo.save(goobar);
		final User hoobar = new User("hoobar");
		repo.save(hoobar);
		// init finder using the real repo
		final UserFinder finder = new UserFinder(repo);

		// when
		final Collection<User> users = finder.findByName("goobar");

		// then
		assertThat(users).containsOnly(goobar);
	}
}
