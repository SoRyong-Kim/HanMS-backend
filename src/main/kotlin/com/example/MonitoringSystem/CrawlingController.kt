package com.example.MonitoringSystem

import com.example.MonitoringSystem.service.CrawlingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CrawlingController( private val crawlingService: CrawlingService ) {

    // 진료 과목이 존재할 때
    @GetMapping("/api/crawl-list1")
    fun crawlList1(@RequestParam url: String): List<String> {
        return crawlingService.crawlHeaderWords(url)
    }

    // 상단 바 크롤링 + 진료 내용 비교
    @GetMapping("/api/crawl-list2")
    fun crawlList2(@RequestParam url: String): List<String> {
        return crawlingService.crawlHeaderWords(url)
    }

    @GetMapping("/api/crawl-list3")
    fun crawlList3(@RequestParam url: String): List<String> {
        return crawlingService.crawlHeaderWords(url)
    }
}