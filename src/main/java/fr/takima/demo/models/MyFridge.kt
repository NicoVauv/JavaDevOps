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
                var fridgeList: MyList?,
                @Column(name = "reference") var reference: String?) {
    constructor() : this(null, null, null, null)

    override fun toString(): String {
        return "MyFridge(id=$id)"
    }


}
