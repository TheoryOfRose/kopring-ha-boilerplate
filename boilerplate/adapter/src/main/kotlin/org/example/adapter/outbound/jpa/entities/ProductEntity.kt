package org.example.adapter.outbound.jpa.entities

import jakarta.persistence.*
import org.example.adapter.outbound.jpa.enums.ProductNameEntity
import java.util.*

@Entity
@Table(name = "products")
class ProductEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    var name: ProductNameEntity = ProductNameEntity.ECG_BUDDY
) {
}