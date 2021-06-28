package com.example.airports.reviews.controllers.dto

import com.sun.istack.NotNull
import org.springframework.boot.context.properties.bind.DefaultValue
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.validation.constraints.Min

data class ReviewRequest(
	  @NotNull
	  val airportName: String,
	  @NotNull
	  val title: String,
	  @NotNull
	  val author: String,
	  @NotNull
	  val authorCountry: String?,
	  @NotNull
	  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	  val date: LocalDate,
	  @NotNull
	  val content: String,
	  val experienceAirport: String?,
	  @DateTimeFormat(pattern = "dd-MM-yyyy")
	  val dateVisit: LocalDate?,
	  val typeTraveller: String?,
	  @Min(value = 0)
	  val overallRating: Double?,
	  @Min(value = 0)
	  val queuingRating: Double?,
	  @Min(value = 0)
	  val terminalCleanlinessRating: Double?,
	  @Min(value = 0)
	  val terminalSeatingRating: Double?,
	  @Min(value = 0)
	  val terminalSignsRating: Double?,
	  @Min(value = 0)
	  val foodBeveragesRating: Double?,
	  @Min(value = 0)
	  val airportShoppingRating: Double?,
	  @Min(value = 0)
	  val wifiConnectivityRating: Double?,
	  @Min(value = 0)
	  val airportStaffRating: Double?,
	  @NotNull
	  @Min(value = 0)
	  @DefaultValue("0")
	  val recommended: Int
)
