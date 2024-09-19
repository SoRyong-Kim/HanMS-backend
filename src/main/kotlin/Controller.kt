import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class User(val id: Long, val name: String)

@RestController
@RequestMapping("/api/users")
class UserController {

    private val users = listOf(
            User(1, "Alice"),
            User(2, "Bob"),
            User(3, "Charlie")
    )

    @GetMapping
    fun getAllUsers(): List<User> {
        return users
    }
}