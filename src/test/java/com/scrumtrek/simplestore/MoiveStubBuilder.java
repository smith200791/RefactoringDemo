package com.scrumtrek.simplestore;

import static org.mockito.Mockito.*;

public class MoiveStubBuilder {

	private PriceCodes priceCodes;

	public MoiveStubBuilder withPriceCodes(PriceCodes pCode) {

		this.priceCodes = pCode;
		return this;
	}

	public Movie build() {
		Movie movie = mock(Movie.class);
		when(movie.getPriceCode()).thenReturn(priceCodes);
		return movie;

	}
}
