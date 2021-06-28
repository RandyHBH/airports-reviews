package com.example.airports.reviews.repository.projections

interface ReviewAllStatsAirport {
	  val airportName: String?
	  val amountOfReviews: Int?
	  val overallRatingAvg: Double?
	  val countOfRecommended: Int?
}
