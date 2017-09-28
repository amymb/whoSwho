package io.amy

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by m_632767 on 9/23/17.
 */
interface UserRepository : JpaRepository<User, Long>