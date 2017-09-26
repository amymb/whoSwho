package io.amy

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.print.attribute.standard.JobOriginatingUserName


@Controller
@RequestMapping("/user")
class UserController {

    @Autowired
    val userRepository: UserRepository? = null

    @PostMapping
    @ResponseBody fun addNewUser(@RequestParam(value = "email") email: String) : String {
        println("creating user")
        val newUser = User()
        newUser.email = email
        userRepository?.save(newUser)
        println("saved")
        return "Posted"
    }

    @GetMapping("/{id}")
    @ResponseBody fun findUser(@PathVariable(value="id") id: Long) : User? {
        println("finding user")
        return userRepository?.findOne(id)
    }

    @GetMapping("/all")
    @ResponseBody fun getUsers() : Iterable<User>? = userRepository?.findAll()


}