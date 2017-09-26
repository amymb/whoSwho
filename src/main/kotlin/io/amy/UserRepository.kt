package io.amy

import org.springframework.data.repository.CrudRepository

/**
 * Created by m_632767 on 9/23/17.
 */
interface UserRepository : CrudRepository<User, Long>