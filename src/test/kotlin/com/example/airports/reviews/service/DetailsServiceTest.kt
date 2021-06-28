package com.example.airports.reviews.service

import com.example.airports.reviews.repository.ReviewRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.core.io.ClassPathResource
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest(excludeAutoConfiguration = [LiquibaseAutoConfiguration::class])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class DetailsServiceTest {

	  @Autowired
	  protected lateinit var reviewRepository: ReviewRepository

	  private lateinit var detailsService: DetailsService

	  @BeforeAll
	  fun setUp() {
			detailsService = DetailsService((reviewRepository))

			val systemResourceAsStream = ClassPathResource("airportReviewsTest.csv").inputStream
			val mockMultipartFile = MockMultipartFile("airport-reviews-test", systemResourceAsStream)
			val dao = DataLoaderService(reviewRepository)
			dao.parseAndPersistData(mockMultipartFile)
	  }

	  @Test
	  fun getAllStats() {
			//WHEN
			val allStats = detailsService.getAllStats()

			//THEN
			Assertions.assertThat(allStats.size).isEqualTo(3)
	  }

	  @Test
	  fun getAllStatsByAirport() {
			val allStatsByAirport = detailsService.getAllStatsByAirport("aberdeen-airport")

			Assertions.assertThat(allStatsByAirport.airportName).isEqualTo("aberdeen-airport")
			Assertions.assertThat(allStatsByAirport.amountOfReviews).isEqualTo(10)
			Assertions.assertThat(allStatsByAirport.countOfRecommended).isEqualTo(9)
			Assertions.assertThat(allStatsByAirport.overallRatingAvg).isEqualTo(1.8571428571428572)
	  }

	  @Test
	  fun getReviewsByAirport() {
			val reviewsByAirport = detailsService.getReviewsByAirport("aberdeen-airport")
			Assertions.assertThat(reviewsByAirport.size).isEqualTo(10)
	  }
}
