package com.example.airports.reviews.controllers

import com.example.airports.reviews.controllers.dto.ReviewRequest
import com.example.airports.reviews.controllers.dto.ReviewResponse
import com.example.airports.reviews.controllers.mappers.toReview
import com.example.airports.reviews.repository.projections.ReviewAllStats
import com.example.airports.reviews.repository.projections.ReviewShort
import com.example.airports.reviews.repository.specifications.ReviewSpecs
import com.example.airports.reviews.service.DetailsService
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class DetailsController(
	  private val detailsService: DetailsService
) {

	  @ApiOperation(value = "Get the amount of review per airport ordered descendent", response = ReviewAllStats::class)
	  @GetMapping("/all/stats")
	  fun getStats() = detailsService.getAllStats()

	  @ApiOperation(
			value = "Giving an airport will return the amount of review, the average rating, and how many recommendation has",
			response = ReviewAllStats::class
	  )
	  @GetMapping("/{airport}/stats")
	  fun getStatsByAirport(@PathVariable airport: String) = detailsService.getAllStatsByAirport(airport)

	  @ApiOperation(value = "Giving an airport will return all the reviews for it", response = ReviewShort::class)
	  @GetMapping("/{airport}/reviews")
	  fun getReviewsByAirport(@PathVariable airport: String) = detailsService.getReviewsByAirport(airport)

	  @ApiOperation(value = "Add a new review airport review", response = ReviewResponse::class)
	  @PostMapping("/{airport}/reviews")
	  fun addReviewsToAirport(@PathVariable airport: String, @Valid @RequestBody request: ReviewRequest) =
	  	  detailsService.addReviewToAirport(airport, request.toReview())

	  @ApiOperation(
			value = "Giving an airport and a rating will respond will the reviews with that rating or higher",
			response = ReviewResponse::class
	  )
	  @GetMapping("/find")
	  fun findAirportReview(
			@RequestParam(required = false) minRating: Long?,
			@RequestParam(required = false) maxRating: Long?,
			@RequestParam(required = false) airportName: String?,
			reviewSpecs: ReviewSpecs
	  ) = detailsService.find(reviewSpecs)

}


