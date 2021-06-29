package com.example.airports.reviews.controllers

import com.example.airports.reviews.service.DataLoaderService
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/api/load")
data class DataLoaderController(
	  private val dataLoaderService: DataLoaderService
) {
	  @ApiOperation(value = "Load a CSV and persist into the Database", response = Void::class)
	  @PostMapping("/csv")
	  fun loadCSV(@RequestParam file: MultipartFile) = dataLoaderService.parseAndPersistData(file)
}
