package com.scrumtrek.simplestore;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {

	@Test
	public void shouldMoveTitleSameWhenMovieCreated() {
		Movie movie = new Movie("shurik", PriceCodes.Childrens);

		assertEquals("shurik", movie.getTitle());

	}
}
