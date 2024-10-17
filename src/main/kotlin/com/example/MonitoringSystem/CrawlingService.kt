package com.example.MonitoringSystem.service

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class CrawlingService {

    // 상단 바 내용 가져오는 메서드
    fun crawlHeaderWords(url: String): List<String> {
        val wordList = mutableSetOf<String>() // 중복 제거를 위해 Set 사용

        try {
            // Jsoup을 사용하여 URL에서 HTML 문서 가져오기
            val document = Jsoup.connect(url).get()

            // '상단 바'를 선택 (header, nav 태그나 특정 클래스 또는 아이디를 선택)
            val headerElements = document.select("header, .navbar, .topbar, #header, #topbar, .main-header")

            // 상단 바 내에서 a 태그와 상위 태그의 자식 요소 텍스트를 개별적으로 추출
            for (element in headerElements) {
                val anchorElements = element.select("a") // 상단 바 내부의 모든 <a> 태그 선택

                for (anchor in anchorElements) {
                    val text = anchor.text().trim() // 텍스트 추출 및 공백 제거
                    if (text.isNotEmpty() && !wordList.contains(text)) { // 중복 항목 필터링
                        wordList.add(text)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return wordList.toList() // Set을 List로 변환하여 반환
    }
}
