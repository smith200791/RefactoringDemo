package com.scrumtrek.simplestore;

import static org.mockito.Mockito.*;

public class MoiveStubBuilder {

	private PriceCodes priceCodes;

	private String movieTitle;

	public MoiveStubBuilder withPriceCodes(PriceCodes pCode) {
		this.priceCodes = pCode;
		return this;
	}

	public MoiveStubBuilder withTitle(String title) {
		this.movieTitle = title;
		return this;

	}

	public Movie build() {
		Movie movie = mock(Movie.class);
		when(movie.getPriceCode()).thenReturn(priceCodes);
		when(movie.getTitle()).thenReturn(movieTitle);
		return movie;
	}
}
