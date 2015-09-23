
package com.scrumtrek.simplestore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private Customer sut;

	@Before
	public void setUp() {
		sut = new Customer("Ivan"); // fixture
	}

	@Test
	public void shouldSizeIncrementalWhenRentalAddToCustomer() {
		RentalStubBuilder rentalStubBuilder = new RentalStubBuilder();
		
		MoiveStubBuilder moiveStubBuilder = new MoiveStubBuilder();
		// given
		Rental sRental = rentalStubBuilder.withMovie(moiveStubBuilder.build()).build();

		// when
		sut.addRental(sRental);

		// then
		List<Rental> m_Rentals = sut.getM_Rentals();

		assertEquals(1, m_Rentals.size());
	}

	@Test
	public void shouldReantalAddedInTailWhenRentalAdded() {

		
		RentalStubBuilder rentalStubBuilder = new RentalStubBuilder();
		
		MoiveStubBuilder moiveStubBuilder = new MoiveStubBuilder();
		// given
		Rental sRental = rentalStubBuilder.withMovie(moiveStubBuilder.build()).build();

		// when
		sut.addRental(sRental);

		// then

		int size = sut.getM_Rentals().size();
		assertSame(sRental, sut.getM_Rentals().get(size - 1));
	}

	@Test
	public void shouldNameTheSameWhenCustomerCreated() {
		assertEquals("Ivan", sut.getName());
	}

	@Test
	public void shouldCustomerStatementCallChildrenCalcWhenMoiveForChildren() {
		MoiveStubBuilder builder = new MoiveStubBuilder();
		Movie sMovie = builder.withPriceCodes(PriceCodes.Childrens).build();

		RentalStubBuilder rentalStubBuilder = new RentalStubBuilder();
		Rental sRental = rentalStubBuilder.withMovie(sMovie).build();
		
		
		sut.addRental(sRental);

		Customer customer = spy(sut);

		when(customer.statement()).thenCallRealMethod();
		verify(customer).calculateAmountForChildren(eq(sRental), anyInt());

	}

	@Test
	public void shouldCustomerStatementCallNewReleaseCalcWhenMoiveForChildren() {
		MoiveStubBuilder builder = new MoiveStubBuilder();
		Movie sMovie = builder.withPriceCodes(PriceCodes.NewRelease).build();

		RentalStubBuilder rentalStubBuilder = new RentalStubBuilder();
		Rental sRental = rentalStubBuilder.withMovie(sMovie).build();
		
		
		sut.addRental(sRental);

		Customer customer = spy(sut);

		when(customer.statement()).thenCallRealMethod();
		verify(customer).caclculateAmountForNewRealease(eq(sRental), anyInt());

	}

	@Test
	public void shouldCustomerStatementCallRegularCalcWhenMoiveForChildren() {
		MoiveStubBuilder builder = new MoiveStubBuilder();
		Movie sMovie = builder.withPriceCodes(PriceCodes.Regular).build();

		RentalStubBuilder rentalStubBuilder = new RentalStubBuilder();
		Rental sRental = rentalStubBuilder.withMovie(sMovie).build();
		
		
		sut.addRental(sRental);

		Customer customer = spy(sut);

		when(customer.statement()).thenCallRealMethod();
		verify(customer).calculateAmountForRegular(eq(sRental), anyInt());

	}

	@Test
	public void shouldTotalAmountResultContainsInResultStringWhenMoiveForChildren() {
		MoiveStubBuilder builder = new MoiveStubBuilder();
		Movie sMovie = builder.withPriceCodes(PriceCodes.Childrens).build();

		RentalStubBuilder rentalStubBuilder = new RentalStubBuilder();
		Rental sRental = rentalStubBuilder.withMovie(sMovie).build();
		
		
		sut.addRental(sRental);

		Customer customer = spy(sut);

		when(customer.statement()).thenCallRealMethod();

		org.fest.assertions.Assertions.assertThat(customer.statement()).contains("1.5");
	}

	@Test
	public void shouldTotalAmountResultContainsInResultStringWhenMoiveForChildrenAndRentalDaysGratest3() {
		
		MoiveStubBuilder builder = new MoiveStubBuilder();
		Movie sMovie = builder.withPriceCodes(PriceCodes.Childrens).build();

		RentalStubBuilder rentalStubBuilder = new RentalStubBuilder();
		Rental sRental = rentalStubBuilder.withMovie(sMovie).withDaysRented(5).build();
		
		
		sut.addRental(sRental);

		Customer customer = spy(sut);

		when(customer.statement()).thenCallRealMethod();
		org.fest.assertions.Assertions.assertThat(customer.statement()).contains("3.0");

	}

	

	@Test
	public void shouldTotalAmountResultContainsInResultStringWhenMoiveForRegularAndRentalDaysGratest2() {
		
		MoiveStubBuilder builder = new MoiveStubBuilder();
		Movie sMovie = builder.withPriceCodes(PriceCodes.Regular).build();

		RentalStubBuilder rentalStubBuilder = new RentalStubBuilder();
		Rental sRental = rentalStubBuilder.withMovie(sMovie).withDaysRented(5).build();
		
		
		sut.addRental(sRental);

		Customer customer = spy(sut);

		when(customer.statement()).thenCallRealMethod();
		org.fest.assertions.Assertions.assertThat(customer.statement()).contains("6.5");

	}

}
