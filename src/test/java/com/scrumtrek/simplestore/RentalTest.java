package com.scrumtrek.simplestore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RentalTest {

	@Test
	public void shouldRentalDaysRentedSameWhenRenatalCreated() {
		RentalStubBuilder rentalStubBuilder = new RentalStubBuilder();
		Rental rental = rentalStubBuilder.withDaysRented(1).build();
		assertEquals(1, rental.getDaysRented());

	}
}
