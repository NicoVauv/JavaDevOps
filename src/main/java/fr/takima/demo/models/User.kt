package fr.takima.demo.models

import com.fasterxml.jackson.annotation.JsonIgnore
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
        @JsonIgnore
        @ManyToMany
        @JoinTable(name = "userslist",
                joinColumns = arrayOf(JoinColumn(name = "id_user_list")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "id_list_user")))
        var users: List<MyList>?) {
    constructor() : this(null, null, null, null, null)

    override fun toString(): String {
        return "User(id=$id)"
    }


}