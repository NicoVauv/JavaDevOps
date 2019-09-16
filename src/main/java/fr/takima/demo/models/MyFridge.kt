package fr.takima.demo.models

import javax.persistence.*

/**
 *
 */
@Entity(name = "myfridge")
data class MyFridge(
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Id var id: Long?,
                @OneToMany(mappedBy = "product")
                var products: List<ProductList>?,
                @OneToOne (mappedBy = "myFridge")
                var FridgeList: MyList?) {
    constructor() : this(null, null, null)

}
