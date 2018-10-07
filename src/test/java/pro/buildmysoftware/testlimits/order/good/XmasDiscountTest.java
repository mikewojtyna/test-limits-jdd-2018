package pro.buildmysoftware.testlimits.order.good;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.testlimits.order.FixedClockUtil;

import java.time.Clock;

import static org.assertj.core.api.Assertions.assertThat;

public class XmasDiscountTest {
	@DisplayName("should return 0.8 discount when current date is 1st of "
		+ "December 2018")
	@Test
	void test0() throws Exception {
		// given
		final Clock firstDecClock = FixedClockUtil.fixedUtcClock(2018,
			12, 1);
		final DiscountPolicy discountPolicy = new XmasDiscount
			(firstDecClock);

		// when
		final double discount = discountPolicy.discountFor(new
			GoodOrder());

		// then
		assertThat(discount).isEqualTo(0.8);
	}

	@DisplayName("should return 1 discount when current date is 24th of "
		+ "December 2018")
	@Test
	void test1() throws Exception {
		// given
		final Clock clock = FixedClockUtil.fixedUtcClock(2018, 12, 24);
		final DiscountPolicy discountPolicy = new XmasDiscount(clock);

		// when
		final double discount = discountPolicy.discountFor(new
			GoodOrder());

		// then
		assertThat(discount).isEqualTo(1.0);
	}
}
