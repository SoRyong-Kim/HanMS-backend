package com.example.MonitoringSystem

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class WebCrawlerService {
    fun crawlMSubjects(url: String): List<String> {
        // Jsoup을 사용하여 웹 페이지를 가져옴
        val document = Jsoup.connect(url).get()

        // "진료과목"이라는 텍스트를 가진 <a> 태그가 포함된 <li> 찾기
        val targetUl = document
                .select("li:has(a:contains(진료과목)) > ul")  // "진료과목" <a> 태그의 하위 <ul> 선택

        // <ul> 안의 <li> 태그에서, 첫 번째 <ul>의 <li> 내에 있는 <a> 태그의 텍스트만 추출
        val listItems = targetUl.select("> li > a")  // 중첩되지 않은, 직접적인 자식 <li>의 <a>만 선택
                .map { it.text() }

        return listItems
    }

    fun crawlAcroSubjects(url: String): List<String> {
        // Jsoup을 사용하여 웹 페이지를 가져옴
        val document = Jsoup.connect(url).get()

        // "진료과목"이라는 텍스트를 가진 <a> 태그가 포함된 <li> 찾기
        val targetUl = document
                .select("li:has(a:contains(진료과목)) > ul")  // "진료과목" <a> 태그의 하위 <ul> 선택

        // <ul> 안의 <li> 태그에서, 첫 번째 <ul>의 <li> 내에 있는 <a> 태그의 텍스트만 추출
        val listItems = targetUl.select("> li > a")  // 중첩되지 않은, 직접적인 자식 <li>의 <a>만 선택
                .map { it.text() }

        return listItems
    }
}
