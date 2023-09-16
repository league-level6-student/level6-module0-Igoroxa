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
	Car car;
	CellPhone phone;
	boolean Licensed;
	boolean onTheClock;
	boolean currentlyOnDelivery;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		deliveryDriver = new DeliveryDriver(name, car, phone, Licensed, onTheClock, currentlyOnDelivery);
	}

	@Test
	void itShouldWasteTime() {
		// given
		boolean expected = true;
		// when

		when(deliveryDriver.cellPhone.browseCatMemes()).thenReturn(true);

		boolean actual = deliveryDriver.wasteTime();
		// then

		assertEquals(expected, actual);
	}

	@Test
	void itShouldRefuel() {
		// given
		boolean expectedRefuel = true;
		
		when(deliveryDriver.car.fillTank(10));
		// when
		boolean actual = deliveryDriver.refuel(0);
		// then
		assertEquals(expectedRefuel, actual);
	}

	@Test
	void itShouldContactCustomer() {
		// given
		boolean expected = true;

		when(deliveryDriver.cellPhone.call(name)).thenReturn(true);

		// when
		boolean actual = deliveryDriver.contactCustomer(name);
		// then

		assertEquals(expected, actual);
	}

}