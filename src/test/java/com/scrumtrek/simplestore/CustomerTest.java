package com.scrumtrek.simplestore;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	
	private Customer sut;

	@Before
	public void setUp() {
		sut = new Customer("Ivan");
	}

	@Test
	public void shouldSizeIncrementalWhenRentalAddToCustomer() {

		// given

		Rental dummy = new Rental(new Movie("testMove", PriceCodes.Regular), 11);

		// when
		sut.addRental(dummy);

		// then
		List<Rental> m_Rentals = sut.getM_Rentals();

		assertEquals(1, m_Rentals.size());

	}
	
	@Test
	public void shouldNameTheSameWhenCustomerCreated() {
		assertEquals("Ivan",sut.getName());
	}

}
