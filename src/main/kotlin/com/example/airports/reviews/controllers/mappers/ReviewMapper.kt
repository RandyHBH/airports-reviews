package com.example.airports.reviews.controllers.mappers

import com.example.airports.reviews.controllers.dto.ReviewRequest
import com.example.airports.reviews.controllers.dto.ReviewResponse
import com.example.airports.reviews.domain.Review


private const val LINK = "/airport-reviews/"


fun ReviewRequest.toReview() = Review(
	  airportName = airportName,
	  link = LINK + airportName,
	  title = title,
	  author = author,
	  authorCountry = authorCountry,
	  date = date,
	  content = content,
	  experienceAirport = experienceAirport,
	  dateVisit = dateVisit,
	  typeTraveller = typeTraveller,
	  overallRating = overallRating,
	  queuingRating = queuingRating,
	  terminalCleanlinessRating = terminalCleanlinessRating,
	  terminalSeatingRating = terminalSeatingRating,
	  terminalSignsRating = terminalSignsRating,
	  foodBeveragesRating = foodBeveragesRating,
	  airportShoppingRating = airportShoppingRating,
	  wifiConnectivityRating = wifiConnectivityRating,
	  airportStaffRating = airportStaffRating,
	  recommended = recommended
)

fun Review.toReviewResponse() = ReviewResponse(
	  airportName = airportName,
	  link = LINK + airportName,
	  title = title,
	  author = author,
	  authorCountry = authorCountry,
	  date = date,
	  content = content,
	  experienceAirport = experienceAirport,
	  dateVisit = dateVisit,
	  typeTraveller = typeTraveller,
	  overallRating = overallRating,
	  queuingRating = queuingRating,
	  terminalCleanlinessRating = terminalCleanlinessRating,
	  terminalSeatingRating = terminalSeatingRating,
	  terminalSignsRating = terminalSignsRating,
	  foodBeveragesRating = foodBeveragesRating,
	  airportShoppingRating = airportShoppingRating,
	  wifiConnectivityRating = wifiConnectivityRating,
	  airportStaffRating = airportStaffRating,
	  recommended = recommended,
	  id = id!!
)
