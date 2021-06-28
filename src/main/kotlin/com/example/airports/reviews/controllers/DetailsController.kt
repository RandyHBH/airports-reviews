package com.example.airports.reviews.controllers

import com.example.airports.reviews.controllers.dto.ReviewRequest
import com.example.airports.reviews.controllers.dto.ReviewResponse
import com.example.airports.reviews.controllers.mappers.toReview
import com.example.airports.reviews.controllers.mappers.toReviewResponse
import com.example.airports.reviews.repository.specifications.ReviewSpecs
import com.example.airports.reviews.service.DetailsService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class DetailsController(
	  private val detailsService: DetailsService
) {

	  @GetMapping("/all/stats")
	  fun getStats() = detailsService.getAllStats()

	  @GetMapping("/{airport}/stats")
	  fun getStatsByAirport(@PathVariable airport: String) = detailsService.getAllStatsByAirport(airport)

	  @GetMapping("/{airport}/reviews")
	  fun getReviewsByAirport(@PathVariable airport: String) = detailsService.getReviewsByAirport(airport)

	  @PostMapping("/{airport}/reviews")
	  fun addReviewsToAirport(@PathVariable airport: String, @Valid @RequestBody request: ReviewRequest) =
	  	  detailsService.addReviewToAirport(airport, request.toReview())

	  @GetMapping("/find")
	  fun findAirportReview(
			@RequestParam(required = false) minRating: Long?,
			@RequestParam(required = false) maxRating: Long?,
			@RequestParam(required = false) airportName: String?,
			reviewSpecs: ReviewSpecs
	  ) = detailsService.find(reviewSpecs)

}


