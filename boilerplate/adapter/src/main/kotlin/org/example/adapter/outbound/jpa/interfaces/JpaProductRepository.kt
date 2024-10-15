package org.example.adapter.outbound.jpa.interfaces

import org.example.adapter.outbound.jpa.entities.ProductEntity
import org.example.adapter.outbound.jpa.enums.ProductNameEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

//@Repository
interface JpaProductRepository : JpaRepository<ProductEntity, UUID> {
    fun findByName(name: ProductNameEntity): Optional<ProductEntity>
}