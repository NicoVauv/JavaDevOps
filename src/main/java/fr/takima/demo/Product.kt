package fr.takima.demo

import javax.persistence.*

/**
 *
 */
@Entity(name = "product")
data class Product(
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Id var id: Long?,
                @Column(name = "category") var category: String?,
                @Column(name = "name") var name: String?,
                @Column(name = "number") var number: Int?,
                @Column(name = "selected") var selected: Int?) {
    constructor() : this(null, null, null, null, null)

}
