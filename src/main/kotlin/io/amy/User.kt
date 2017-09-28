package io.amy

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


/**
 * Created by m_632767 on 9/21/17.
 */
@Entity
data class User(
    val email: String? = "",
    val firstName: String? = "",
    val lastName: String? = "",
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    val id: Long? = null)