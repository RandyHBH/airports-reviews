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
	  
}
