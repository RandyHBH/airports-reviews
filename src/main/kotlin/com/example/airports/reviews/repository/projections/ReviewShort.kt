package com.example.airports.reviews.repository.projections

import java.time.LocalDate

interface ReviewShort {
	  val authorCountry: String?
	  val content: String?
	  val date: LocalDate?
	  val overallRating: Double?
}
