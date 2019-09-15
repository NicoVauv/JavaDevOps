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
                @Column(name = "category") var category: String?,
                @Column(name = "name") var name: String?,
                @OneToOne (mappedBy = "myProduct1")
                var myFridge: MyFridge?,
                @OneToOne (mappedBy = "myProduct2")
                var myList: MyList?){
    constructor() : this(null, null, null, null, null)

}
