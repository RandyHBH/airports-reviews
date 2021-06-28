package com.example.airports.reviews.service

import com.example.airports.reviews.repository.ReviewRepository
import com.example.airports.reviews.util.Parser
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile


@Service
class DataLoaderService(
	  private val reviewRepository: ReviewRepository
) {
	  private val logger = KotlinLogging.logger {}

	  fun parseAndPersistData(file: MultipartFile) {
			runCatching {
				  Parser().getReviewsFromCsv(file)
			}.onFailure {
				  logger.error(it) { "Something wrong happened while loading the CSV" }
			}.onSuccess {
				  logger.info { "${it.size} Reviews parsed" }
			}.mapCatching {
				  reviewRepository.saveAllAndFlush(it)
			}.onSuccess {
				  logger.info { "${it.size} Reviews saved on the database" }
			}.getOrThrow()
	  }
}
