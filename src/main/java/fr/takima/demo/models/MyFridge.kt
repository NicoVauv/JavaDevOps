package fr.takima.demo.models

import javax.persistence.*

/**
 *
 */
@Entity(name = "myfridge")
data class MyFridge(
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Id var id: Long?,
                @OneToMany(mappedBy = "myProducts")
                var myProducts: List<ProductFridge>?,
                @OneToOne (mappedBy = "myFridge")
                var fridgeList: MyList?) {
    constructor() : this(null, null, null)

}
