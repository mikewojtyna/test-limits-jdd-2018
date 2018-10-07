package pro.buildmysoftware.testlimits.order.glue;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserFinder {

	private final UserRepository repository;

	public UserFinder(final UserRepository repository) {
		this.repository = repository;
	}

	Collection<User> findByName(final String name) {
		return repository.findByName(name);
		// TODO: try to uncomment this and run UserFinderTest again
		/*return repository.findAll().stream().filter(n -> n.getName()
			.equals(name)).collect(Collectors.toList());*/
	}
}
