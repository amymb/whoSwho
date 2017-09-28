package io.amy

import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    val userRepository: UserRepository? = null

    @PostMapping
    fun createUser(@RequestBody userCreateRequest: User) : User {
        println("creating user")
        val newUser = userCreateRequest
        userRepository?.saveAndFlush(newUser)
        println("saved")
        return "Posted"
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable(value="id") id: Long, @RequestBody userUpdateRequest: User) : User? {
        val user = userRepository?.findOne(id)
        val updatedUser = user?.copy(firstName=userUpdateRequest.firstName, lastName=userUpdateRequest.lastName, email=userUpdateRequest.email)
        return userRepository?.saveAndFlush(updatedUser)
    }

    @GetMapping("/{id}")
    fun findUser(@PathVariable(value="id") id: Long) : User? {
        println("finding user")
        return userRepository?.findOne(id)
    }

    @GetMapping
    fun getUsers() : Iterable<User>? = userRepository?.findAll()


    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable(value="id") id: Long) = userRepository?.delete(id)
}