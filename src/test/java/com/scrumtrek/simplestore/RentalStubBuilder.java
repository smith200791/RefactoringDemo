package com.scrumtrek.simplestore;


import static org.mockito.Mockito.*;

public class RentalStubBuilder {
	private Movie movie = new MoiveStubBuilder().build(); 
	private int daysCol;

	public RentalStubBuilder withMovie(Movie movie) {
		this.movie = movie;
		return this;
	}

	public RentalStubBuilder withDaysRented(int daysCol) {
		this.daysCol = daysCol;
		return this;
	}
	
	
	public Rental build() {
		Rental rental = mock(Rental.class);
		
		when(rental.getDaysRented()).thenReturn(this.daysCol);
		when(rental.getMovie()).thenReturn(this.movie);
		return rental;
		
	}
}
