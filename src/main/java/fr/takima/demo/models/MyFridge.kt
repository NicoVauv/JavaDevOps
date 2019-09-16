package fr.takima.demo.models

import javax.persistence.*

/**
 *
 */
@Entity(name = "myfridge")
data class MyFridge(
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Id var id: Long?,
                @ManyToMany (mappedBy = "myProductFridge")
                var products: List<Product>?,
                @OneToOne (mappedBy = "myUserList")
                var UserList: MyList?,
                @Column(name = "onfridge") var onfridge: Int?) {
    constructor() : this(null, null, null,null)

}
