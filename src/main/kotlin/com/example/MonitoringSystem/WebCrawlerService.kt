package com.example.MonitoringSystem

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class WebCrawlerService {
    fun crawlMSubjects(url: String): List<String> {
        // Jsoup을 사용하여 웹 페이지를 가져옴
        val document = Jsoup.connect(url).get()

        // HTML의 <h1> 태그에서 텍스트를 추출
        return document.select("a._fade_link span.plain_name").map { it.text() }
    }
}