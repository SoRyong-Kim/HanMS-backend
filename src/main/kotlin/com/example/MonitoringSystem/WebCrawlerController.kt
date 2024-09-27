package com.example.MonitoringSystem

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WebCrawlerController(private val webCrawlerService: WebCrawlerService) {
    @GetMapping("/api/crawl-list1")
    fun crawlListTags1(@RequestParam url: String): List<String> {
        return webCrawlerService.crawlMSubjects1(url)
    }

    @GetMapping("/api/crawl-list2")
    fun crawlListTags2(@RequestParam url: String): List<String> {
        return webCrawlerService.crawlMSubjects2(url)
    }

    @GetMapping("/api/crawl-list3")
    fun crawlListTags3(@RequestParam url: String): List<String> {
        return webCrawlerService.crawlMSubjects3(url)
    }
}