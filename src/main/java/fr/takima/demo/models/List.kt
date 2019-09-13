package fr.takima.demo.models

import javax.persistence.*

/**
 *
 */
@Entity(name = "mylist")
data class List(
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Id var id: Long?,
                @OneToOne
                @Column(name = "id_product") var id_product: Int?,
                @Column(name = "quantity") var quantity: Int?) {
    constructor() : this(null, null, null)

}
