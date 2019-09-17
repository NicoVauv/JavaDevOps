package fr.takima.demo.models

import javax.persistence.*

/**
 *
 */
@Entity(name = "users")
data class User(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        @Column(name = "pseudo") var pseudo: String?,
        @Column(name = "mail") var mail: String?,
        @Column(name = "password") var password: String?,
        @ManyToMany(mappedBy = "myUserList")
        var users: List<MyList>?) {
    constructor() : this(null, null, null, null, null)
}