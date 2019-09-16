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
                @OneToMany (mappedBy = "list")
                var myProductList: List<ProductList>?,
                @OneToMany(mappedBy = "fridge")
                var myProductFridge: List<ProductFridge>?,
                @Column(name = "category") var category: String?,
                @Column(name = "name") var name: String?){
    constructor() : this(null, null, null, null, null)

}
