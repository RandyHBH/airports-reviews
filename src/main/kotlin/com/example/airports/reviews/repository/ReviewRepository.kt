package com.example.airports.reviews.repository

import com.example.airports.reviews.domain.Review
import com.example.airports.reviews.repository.projections.ReviewAllStats
import com.example.airports.reviews.repository.projections.ReviewAllStatsAirport
import com.example.airports.reviews.repository.projections.ReviewShort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ReviewRepository : JpaRepository<Review, Long>, JpaSpecificationExecutor<Review> {

	  @Query("SELECT r.airportName as airportName, COUNT(r) as amountOfReviews from Review r group by r.airportName Order by amountOfReviews")
	  fun getAllStats(): List<ReviewAllStats>

	  @Query("""SELECT r.airportName as airportName, count(r) as amountOfReviews, avg(r.overallRating) as overallRatingAvg, count(r.recommended) as countOfRecommended from Review r where r.airportName=:airport GROUP BY r.airportName""")
	  fun getAirportStats(@Param("airport") airport: String): ReviewAllStatsAirport

	  fun getAllByAirportNameOrderByDateDesc(airport: String): List<ReviewShort>
}
