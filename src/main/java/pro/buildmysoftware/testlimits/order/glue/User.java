package pro.buildmysoftware.testlimits.order.glue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public User() {
	}

	public User(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final User user = (User) o;
		return Objects.equals(id, user.id) && Objects.equals(name,
			user.name);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
