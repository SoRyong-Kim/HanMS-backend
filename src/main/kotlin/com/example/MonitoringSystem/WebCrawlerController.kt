package com.example.MonitoringSystem

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WebCrawlerController(private val webCrawlerService: WebCrawlerService) {
    @GetMapping("/api/crawl-list")
    fun crawlListTags(@RequestParam url: String): List<String> {
        return webCrawlerService.crawlMSubjects(url)
    }
}