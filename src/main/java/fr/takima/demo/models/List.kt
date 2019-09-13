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
                @Column(name = "id_product2") var id_product2: Int?,
                @Column(name = "onlist") var onlist: Int?) {
    constructor() : this(null, null, null)

}
