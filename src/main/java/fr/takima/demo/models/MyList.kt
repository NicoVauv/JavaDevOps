package fr.takima.demo.models

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

/**
 *
 */
@Entity(name = "mylist")
data class MyList(
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Id var id: Long?,
                @OneToMany (mappedBy = "myProducts")
                var Products: List<ProductList>?,
                @ManyToMany
                @JoinTable(name = "userslist",
                        joinColumns = arrayOf(JoinColumn(name = "id_list_user")),
                        inverseJoinColumns = arrayOf(JoinColumn(name = "id_user_list")))
                var myUserList: List<User>?,
                @OneToOne (cascade = arrayOf(CascadeType.ALL))
                @JoinColumn(name = "id_list_fridge", referencedColumnName = "id")
                var myFridge: MyFridge?) {
    constructor() : this(null, null, null,null)

    override fun toString(): String {
        return "MyList(id=$id)"
    }


}
