package pro.buildmysoftware.testlimits.order.good;

interface DiscountPolicy {
	double discountFor(GoodOrder goodOrder);
}
