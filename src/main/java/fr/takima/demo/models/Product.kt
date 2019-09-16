package fr.takima.demo.models

import javax.persistence.*

/**
 *
 */
@Entity(name = "products")
data class Product(
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Id
                @Column(name = "id") var id: Long?,
                @ManyToMany (cascade = arrayOf(CascadeType.ALL))
                @JoinTable(name = "productslist",
                        joinColumns = arrayOf(JoinColumn(name = "id_product_list")),
                        inverseJoinColumns = arrayOf(JoinColumn(name = "id_list_product")))
                var myProductList: List<MyList>?,
                @ManyToMany (cascade = arrayOf(CascadeType.ALL))
                @JoinTable(name = "productsfridge",
                        joinColumns = arrayOf(JoinColumn(name = "id_product_fridge")),
                        inverseJoinColumns = arrayOf(JoinColumn(name = "id_fridge_product")))
                var myProductFridge: List<MyFridge>?,
                @Column(name = "category") var category: String?,
                @Column(name = "name") var name: String?){
    constructor() : this(null, null, null, null, null)

}
