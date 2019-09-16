package fr.takima.demo.models

import javax.persistence.*

/**
 *
 */
@Entity(name = "users")
data class User(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        @ManyToMany(mappedBy = "myUserList")
        var users: List<MyList>?,
        @Column(name = "pseudo") var pseudo: String?,
        @Column(name = "mail") var mail: String?,
        @Column(name = "password") var password: Int?) {
    constructor() : this(null, null, null, null, null)
}