package com.example.airports.reviews.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.core.io.ClassPathResource
import org.springframework.mock.web.MockMultipartFile

internal class ParserTest {

	  private val parser: Parser = Parser()

	  @Test
	  fun shouldParseCscCorrectly() {
			//GIVEN
			val systemResourceAsStream = ClassPathResource("airportReviewsTest.csv").inputStream
			val mockMultipartFile = MockMultipartFile("airport-reviews-test", systemResourceAsStream)

			//WHEN
			val reviewsFromCsv = parser.getReviewsFromCsv(mockMultipartFile)

			//THEN
			Assertions.assertThat(reviewsFromCsv.size).isEqualTo(18)
	  }
}
