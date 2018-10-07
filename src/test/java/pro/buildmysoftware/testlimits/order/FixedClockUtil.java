package pro.buildmysoftware.testlimits.order;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class FixedClockUtil {
	public static Clock fixedUtcClock(final int year, final int month,
					  final int day) {
		final LocalDate date = LocalDate.of(year, month, day);
		return Clock.fixed(date.atStartOfDay().toInstant(ZoneOffset
			.UTC), ZoneOffset.UTC);
	}
}
