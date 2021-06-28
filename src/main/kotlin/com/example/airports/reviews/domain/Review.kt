package com.example.airports.reviews.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "review")
data class Review(

	  val airportName: String,

	  val link: String,

	  val title: String,

	  val author: String,

	  val authorCountry: String?,

	  val date: LocalDate,

	  @Column(columnDefinition = "text")
	  val content: String,

	  @Column(columnDefinition = "text")
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
) {
	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_id_seq")
	  @SequenceGenerator(name = "review_id_seq", sequenceName = "review_id_seq", allocationSize = 1)
	  val id: Long? = null
}
