package fr.takima.demo.models

import javax.persistence.*


@Entity (name = "productsfridge")
data class ProductFridge (
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(name = "id") var id: Long?,
        @ManyToOne
        @JoinColumn(name = "id_fridge_product")
        var myProducts: MyFridge?,
        @ManyToOne
        @JoinColumn(name = "id_product_fridge")
        var myFridges: Product?,
        @Column(name = "onfridge")
        var onfridge: Int?){
    constructor() : this(null, null, null, null)

        override fun toString(): String {
                return "ProductFridge(id=$id)"
        }


}