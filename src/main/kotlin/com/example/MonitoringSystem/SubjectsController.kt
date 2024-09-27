import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["http://localhost:3000"]) // React 앱의 URL
class SubjectsController {

    // @RequestParam을 사용하여 쿼리 파라미터 'url'을 받음
    @GetMapping("/api/subjects/clinic1")
    fun getClinic1Subjects(@RequestParam url: String): ResponseEntity<Any> {
        return try {
            // 크롤링 시도
            val subjects = crawlMSubjects(url)
            if (subjects.isNotEmpty()) {
                ResponseEntity.ok(subjects)
            } else {
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("No subjects found.")
            }
        } catch (e: Exception) {
            // 크롤링 중 오류 발생 시 오류 메시지 반환
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during crawling.")
        }
    }

    fun crawlMSubjects(url: String): List<String> {
        // Jsoup을 사용하여 전달받은 URL을 크롤링
        val document = Jsoup.connect(url).get()

        // "진료과목"이라는 텍스트를 가진 <a> 태그가 포함된 <li> 찾기
        val targetUl = document.select("li:has(a:contains(진료과목)) > ul")

        // <ul> 안의 <li> 태그에서 첫 번째 <ul>의 <li> 내에 있는 <a> 태그의 텍스트만 추출
        return targetUl.select("> li > a").map { element: Element -> element.text() }
    }
}
