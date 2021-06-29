package com.example.airports.reviews.util

import com.example.airports.reviews.domain.Review
import com.opencsv.CSVParser
import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder
import mu.KotlinLogging
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedReader
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class Parser {
	  private val logger = KotlinLogging.logger {}

	  companion object {
			private const val CSV_DELIMITER = ';'
			private const val CSV_AIRPORT_NAME = 0
			private const val CSV_LINK = 1
			private const val CSV_TITLE = 2
			private const val CSV_AUTHOR = 3
			private const val CSV_AUTHOR_COUNTRY = 4
			private const val CSV_DATE = 5
			private const val CSV_CONTENT = 6
			private const val CSV_EXPERIENCE_AIRPORT = 7
			private const val CSV_DATE_VISIT = 8
			private const val CSV_TYPE_TRAVELLER = 9
			private const val CSV_OVERALL_RATING = 10
			private const val CSV_QUEUING_RATING = 11
			private const val CSV_TERMINAL_CLEANLINESS_RATING = 12
			private const val CSV_TERMINAL_SEATING_RATING = 13
			private const val CSV_TERMINAL_SIGNS_RATING = 14
			private const val CSV_FOOD_BEVERAGES_RATING = 15
			private const val CSV_AIRPORT_SHOPPING_RATING = 16
			private const val CSV_WIFI_CONNECTIVITY_RATING = 17
			private const val CSV_AIRPORT_STAFF_RATING = 18
			private const val CSV_RECOMMENDED = 19
	  }

	  fun getReviewsFromCsv(file: MultipartFile): ArrayList<Review> {
			val reviews = ArrayList<Review>()
			var reader: BufferedReader? = null
			var csvReader: CSVReader? = null
			val parser: CSVParser = CSVParserBuilder().withSeparator(CSV_DELIMITER).build()

			try {
				  reader = BufferedReader(file.inputStream.bufferedReader())
				  csvReader = CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build()

				  var row = csvReader.readNext()

				  while (row != null) {
						val columns = row

						try {
							  buildReviewAddToList(columns, reviews)
						} catch (e: Exception) {
							  logger.error(e) { "Error during processing, skipping this line $columns" }
						}

						row = csvReader.readNext()
				  }
			} catch (e: Exception) {
				  logger.error(e) { "General Exception while parsing the CSV" }
			} finally {
				  reader!!.close()
				  csvReader!!.close()
			}

			return reviews
	  }

	  private fun buildReviewAddToList(columns: Array<String>, reviews: ArrayList<Review>) {
			if (columns.isNotEmpty()) {
				  val airportName = columns[CSV_AIRPORT_NAME]
				  val link = columns[CSV_LINK]
				  val title = columns[CSV_TITLE]
				  val author = columns[CSV_AUTHOR]
				  val authorCountry = columns[CSV_AUTHOR_COUNTRY].ifBlank { null }
				  val date = columns[CSV_DATE].let { LocalDate.parse(it, DateTimeFormatter.ISO_DATE) }
				  val content = columns[CSV_CONTENT]
				  val experienceAirport = columns[CSV_EXPERIENCE_AIRPORT].ifBlank { null }
				  val dateVisit = columns[CSV_DATE_VISIT].ifBlank { null }
						?.let { LocalDate.parse(it, DateTimeFormatter.ofPattern("dd-MM-yyyy")) }
				  val typeTraveller = columns[CSV_TYPE_TRAVELLER].ifBlank { null }
				  val overallRating = columns[CSV_OVERALL_RATING].ifBlank { null }?.toDouble()
				  val queuingRating = columns[CSV_QUEUING_RATING].ifBlank { null }?.toDouble()
				  val terminalCleanlinessRating =
						columns[CSV_TERMINAL_CLEANLINESS_RATING].ifBlank { null }?.toDouble()
				  val terminalSeatingRating =
						columns[CSV_TERMINAL_SEATING_RATING].ifBlank { null }?.toDouble()
				  val terminalSignsRating =
						columns[CSV_TERMINAL_SIGNS_RATING].ifBlank { null }?.toDouble()
				  val foodBeveragesRating =
						columns[CSV_FOOD_BEVERAGES_RATING].ifBlank { null }?.toDouble()
				  val airportShoppingRating =
						columns[CSV_AIRPORT_SHOPPING_RATING].ifBlank { null }?.toDouble()
				  val wifiConnectivityRating =
						columns[CSV_WIFI_CONNECTIVITY_RATING].ifBlank { null }?.toDouble()
				  val airportStaffRating =
						columns[CSV_AIRPORT_STAFF_RATING].ifBlank { null }?.toDouble()
				  val recommended = columns[CSV_RECOMMENDED].ifBlank { null }?.toInt()

				  reviews += Review(
						airportName = airportName,
						link = link,
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
			}
	  }

	  private fun skipHeaderLine(reader: BufferedReader) = reader.readLine()
}
