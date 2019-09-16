package fr.takima.demo.models

import javax.persistence.*

/**
 *
 */
@Entity(name = "mylist")
data class MyList(
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Id var id: Long?,
                @ManyToMany (mappedBy = "myProductList")
                var products: List<Product>?,
                @ManyToMany (mappedBy = "myUserList")
                var users: List<User>?,
                @OneToOne (mappedBy = "myFridge")
                var myFridge: MyFridge?,
                @Column(name = "onlist") var onlist: Int?) {
    constructor() : this(null, null, null,null,null)

}
