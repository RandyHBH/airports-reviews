package com.example.airports.reviews.repository.specifications

import com.example.airports.reviews.domain.Review
import net.kaczmarzyk.spring.data.jpa.domain.Between
import net.kaczmarzyk.spring.data.jpa.domain.EqualIgnoreCase
import net.kaczmarzyk.spring.data.jpa.domain.Like
import net.kaczmarzyk.spring.data.jpa.web.annotation.And
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec
import org.springframework.data.jpa.domain.Specification

@And(
	  Spec(path = "overallRating", params = ["minRating", "maxRating"], spec = Between::class),
	  Spec(path = "airportName", params = ["airportName"], spec = Like::class)
)
interface ReviewSpecs : Specification<Review> {
}
