package fr.takima.demo.models

import javax.persistence.*

/**
 *
 */
@Entity(name = "mylist")
data class MyList(
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Id var id: Long?,
                @OneToOne
                @JoinColumn(name = "id_product", referencedColumnName = "id")
                var myProduct2: Product?,
                @Column(name = "onlist") var onlist: Int?) {
    constructor() : this(null, null, null)

}
