package com.example.MonitoringSystem

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WebCrawlerController(private val webCrawlerService: WebCrawlerService) {
    // 진료 과목 이 존재할 때
//    @GetMapping("/api/crawl-list1")
//    fun crawlListTags1(@RequestParam url: String): List<String> {
//        return webCrawlerService.crawlMSubjects1(url)
//    }
//
//    // 상단 메뉴에 '치료법'이 들어가 있을 때.
//    @GetMapping("/api/crawl-list2")
//    fun crawlListTags2(@RequestParam url: String): List<String> {
//        return webCrawlerService.crawlMSubjects2(url)
//    }
//
//    // 진료과목이 이미지 일 때.
//    @GetMapping("/api/crawl-list3")
//    fun crawlListTags3(@RequestParam url: String): List<String> {
//        return webCrawlerService.crawlMSubjects3(url)
//    }
}