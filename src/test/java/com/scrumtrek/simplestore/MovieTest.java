package com.scrumtrek.simplestore;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {

	@Test
	public void shouldMoveTitleSameWhenMovieCreated() {

		Movie movie = new MoiveStubBuilder().withTitle("shurik").build();

		assertEquals("shurik", movie.getTitle());

	}
}
