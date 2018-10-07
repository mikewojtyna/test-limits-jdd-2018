package pro.buildmysoftware.testlimits.order.glue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserFinderTest {

	@DisplayName("should find user by name")
	@Test
	void test() throws Exception {
		// given
		final UserRepository repo = mock(UserRepository.class);
		final UserFinder finder = new UserFinder(repo);
		final User goobar = new User("goobar");
		when(repo.findByName("goobar")).thenReturn(Collections
			.singleton(goobar));

		// when
		final Collection<User> users = finder.findByName("goobar");

		// then
		assertThat(users).containsOnly(goobar);
	}
}
