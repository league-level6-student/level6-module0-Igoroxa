package _10_white_box_testing;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

class MyDonutShopTest {

	MyDonutShop myDonutShop;

	@Mock
	MyDonutShop shopper;

	@Mock
	PaymentService pay = new PaymentService();

	@Mock
	DeliveryService delivery = new DeliveryService(null);

	@Mock
	BakeryService bakery = new BakeryService();

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		List<MyDonutShop> avaliableShops = Collections.singletonList(shopper);

		myDonutShop = new MyDonutShop(pay, delivery, bakery);

	}

	@Test
	void itShouldTakeDeliveryOrder() throws Exception {
		// given

		Order order = new Order("name", "phone", 1, 1, "", true);
		// when
		when(bakery.getDonutsRemaining()).thenReturn(1);
		when(pay.charge(order)).thenReturn(true);
		myDonutShop.openForTheDay();
		myDonutShop.takeOrder(order);
		// then
		verify(delivery, times(1)).scheduleDelivery(order);

	}

	@Test
	void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() {
		// given

		Order order = new Order("name", "phone", 6, 1, "", true);

		// when
		when(bakery.getDonutsRemaining()).thenReturn(5);
		myDonutShop.openForTheDay();
		Exception exp = null; 
		try {
			myDonutShop.takeOrder(order);
		} catch (Exception e) {
			exp = e;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// then
		assertTrue(exp instanceof IllegalArgumentException);
		
	}

	@Test
	void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException() {
		// given
		Order order = new Order("name", "phone", 6, 1, "", true);
		myDonutShop.closeForTheDay();
		// when
		Exception exp = null;
		try {
			myDonutShop.takeOrder(order);
		} catch (Exception e) {
			exp = e;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// then
		assertTrue(exp instanceof IllegalStateException);
	}

}