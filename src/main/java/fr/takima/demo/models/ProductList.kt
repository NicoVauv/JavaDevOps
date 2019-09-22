package fr.takima.demo.models

import javax.persistence.*


@Entity (name = "productslist")
data class ProductList (
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id") var id: Long?,
    @ManyToOne
    @JoinColumn(name = "id_list_product")
    var myProducts: MyList?,
    @ManyToOne
    @JoinColumn(name = "id_product_list")
    var myLists: Product?,
    @Column(name = "onlist")
    var onlist: Int?){
        constructor() : this(null, null, null, null)

    override fun toString(): String {
        return "ProductList(id=$id)"
    }


}