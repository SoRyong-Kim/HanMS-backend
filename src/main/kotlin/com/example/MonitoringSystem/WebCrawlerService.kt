package com.example.MonitoringSystem

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class WebCrawlerService {
    fun crawlMSubjects1(url: String): List<String> {
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

    fun crawlMSubjects2(url: String): List<String> {
        val treatments = mutableListOf<String>()
        try {
            // Jsoup으로 해당 URL에서 HTML 문서 가져오기
            val doc = Jsoup.connect(url).get()

            // 원하는 데이터를 가져오기 위한 선택자
            val elements = doc.select("div.menu-item ul li a")

            // 선택된 요소의 텍스트를 리스트에 저장
            for (element in elements) {
                treatments.add(element.text())
            }
        } catch (e: Exception) {
            println("Error occurred while crawling $url: ${e.message}")
        }

        return treatments
    }

    fun crawlMSubjects3(url: String): List<String> {
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