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

}


