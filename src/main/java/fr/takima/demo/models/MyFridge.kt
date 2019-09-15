package fr.takima.demo.models

import javax.persistence.*

/**
 *
 */
@Entity(name = "myfridge")
data class MyFridge(
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Id var id: Long?,
                @OneToOne
                @JoinColumn(name = "id_product", referencedColumnName = "id")
                var myProduct1: Product?,
                @Column(name = "onfridge") var onfridge: Int?) {
    constructor() : this(null, null, null)

}
