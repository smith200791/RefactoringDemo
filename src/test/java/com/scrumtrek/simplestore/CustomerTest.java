package com.scrumtrek.simplestore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
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
		// given
		Rental dummy = new Rental(new Movie("testMove", PriceCodes.Regular), 11);

		// when
		sut.addRental(dummy);

		// then
		List<Rental> m_Rentals = sut.getM_Rentals();

		assertEquals(1, m_Rentals.size());
	}

	@Test
	public void shouldReantalAddedInTailWhenRentalAdded() {

		// given
		Rental dummy = new Rental(new Movie("testMove", PriceCodes.Regular), 11);

		Rental dummy2 = new Rental(new Movie("testMove", PriceCodes.Regular), 11);

		
		// when
		sut.addRental(dummy);

		//then
		
		int size = sut.getM_Rentals().size();
		assertSame(dummy, sut.getM_Rentals().get(size-1));
	}

	@Test
	public void shouldNameTheSameWhenCustomerCreated() {
		assertEquals("Ivan", sut.getName());
	}

	
	@Test
	public void shouldCustomerStatementCallChildrenCalcWhenMoiveForChildren() {
		Movie stubMovie = mock(Movie.class);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Childrens);
		Rental stubRental = mock(Rental.class);
		when(stubRental.getMovie()).thenReturn(stubMovie);
		
		sut.addRental(stubRental);
		
		Customer customer = spy(sut);
		
		when(customer.statement()).thenCallRealMethod();
		verify(customer).calculateAmountForChildren(eq(stubRental), anyInt());	
		
	}
	@Test
	public void shouldCustomerStatementCallNewReleaseCalcWhenMoiveForChildren() {
		Movie stubMovie = mock(Movie.class);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.NewRelease);
		Rental stubRental = mock(Rental.class);
		when(stubRental.getMovie()).thenReturn(stubMovie);
		
		sut.addRental(stubRental);
		
		Customer customer = spy(sut);
		
		when(customer.statement()).thenCallRealMethod();
		verify(customer).caclculateAmountForNewRealease(eq(stubRental), anyInt());	
		
	}
	
	@Test
	public void shouldCustomerStatementCallRegularCalcWhenMoiveForChildren() {
		Movie stubMovie = mock(Movie.class);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Regular);
		Rental stubRental = mock(Rental.class);
		when(stubRental.getMovie()).thenReturn(stubMovie);
		
		sut.addRental(stubRental);
		
		Customer customer = spy(sut);
		
		when(customer.statement()).thenCallRealMethod();
		verify(customer).calculateAmountForRegular(eq(stubRental), anyInt());	
		
	}
	@Test
	public void shouldTotalAmountResultContainsInResultStringWhenMoiveForChildren() {
		Movie stubMovie = mock(Movie.class);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Childrens);
		Rental stubRental = mock(Rental.class);
		when(stubRental.getMovie()).thenReturn(stubMovie);
		
		sut.addRental(stubRental);
		
		Customer customer = spy(sut);
		
		
		
	//	when(customer.calculateAmountForChildren(any(Rental.class), anyInt())).thenReturn(1.0);
		when(customer.statement()).thenCallRealMethod();
		
		org.fest.assertions.Assertions.assertThat(customer.statement()).contains("1.5");
		
		
	}
	
	
}
