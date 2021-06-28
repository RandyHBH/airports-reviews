package com.example.airports.reviews.service

import com.example.airports.reviews.domain.Review
import com.example.airports.reviews.repository.ReviewRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.core.io.ClassPathResource
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.persistence.EntityManager

@ExtendWith(SpringExtension::class)
@DataJpaTest(excludeAutoConfiguration = [LiquibaseAutoConfiguration::class])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class DataLoaderServiceTest {

	  @Autowired
	  protected lateinit var reviewRepository: ReviewRepository

	  @Test
	  fun `database should contain 18 reviews`() {
			//GIVEN
			val systemResourceAsStream = ClassPathResource("airportReviewsTest.csv").inputStream
			val mockMultipartFile = MockMultipartFile("airport-reviews-test", systemResourceAsStream)
			val dao = DataLoaderService(reviewRepository)
			dao.parseAndPersistData(mockMultipartFile)

			//WHEN
			val allReviews = reviewRepository.findAll()

			//THEN
			Assertions.assertThat(allReviews.size).isEqualTo(18)
	  }
}
