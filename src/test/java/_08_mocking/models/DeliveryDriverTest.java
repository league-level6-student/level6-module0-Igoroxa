package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeliveryDriverTest {

	DeliveryDriver deliveryDriver;

	String name;
	@Mock

	Car car;
	@Mock
	CellPhone phone;

	boolean Licensed;

	boolean onTheClock;

	boolean currentlyOnDelivery;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		deliveryDriver = new DeliveryDriver(name, car, phone);
	}

	@Test
	void itShouldWasteTime() {
		// given
		boolean expected = true;
		// when

		when(phone.browseCatMemes()).thenReturn(true);

		boolean actual = deliveryDriver.wasteTime();
		// then

		assertEquals(expected, actual);
	}

	@Test
	void itShouldRefuel() {
		// given
		boolean expectedRefuel = true;

		when(car.fillTank(12)).thenReturn(true);
		// when
		boolean actual = deliveryDriver.refuel(12);
		// then
		assertEquals(expectedRefuel, actual);
	}

	@Test
	void itShouldContactCustomer() {
		// given
		boolean expected = true;

		when(phone.call(name)).thenReturn(true);

		// when
		boolean actual = deliveryDriver.contactCustomer(name);
		// then

		assertEquals(expected, actual);
	}

}