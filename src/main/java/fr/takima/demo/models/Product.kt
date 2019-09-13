package fr.takima.demo.models

import javax.persistence.*

/**
 *
 */
@Entity(name = "products")
data class Product(
                @OneToOne
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Id var id: Long?,
                @Column(name = "category") var category: String?,
                @Column(name = "name") var name: String?) {
    constructor() : this(null, null, null)

}
