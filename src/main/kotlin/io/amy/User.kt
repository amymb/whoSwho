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
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Long? = null,
    var email: String? = "",
    var firstName: String? = "",
    var lastName: String? = "")