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
                @JsonIgnore
                @ManyToMany (mappedBy = "users", cascade = arrayOf(CascadeType.ALL))
                var myUserList: List<User>?,
                @OneToOne (cascade = arrayOf(CascadeType.ALL))
                @JoinColumn(name = "id_list_fridge", referencedColumnName = "id")
                var myFridge: MyFridge?) {
    constructor() : this(null, null, null,null)

    override fun toString(): String {
        return "MyList(id=$id)"
    }


}
