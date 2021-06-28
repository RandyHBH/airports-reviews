package com.example.airports.reviews.controllers.dto

import java.time.LocalDate

data class ReviewResponse(
	  val id: Long,
	  val airportName: String,
	  val link: String,
	  val title: String,
	  val author: String,
	  val authorCountry: String?,
	  val date: LocalDate,
	  val content: String,
	  val experienceAirport: String?,
	  val dateVisit: LocalDate?,
	  val typeTraveller: String?,
	  val overallRating: Double?,
	  val queuingRating: Double?,
	  val terminalCleanlinessRating: Double?,
	  val terminalSeatingRating: Double?,
	  val terminalSignsRating: Double?,
	  val foodBeveragesRating: Double?,
	  val airportShoppingRating: Double?,
	  val wifiConnectivityRating: Double?,
	  val airportStaffRating: Double?,
	  val recommended: Int?
)
