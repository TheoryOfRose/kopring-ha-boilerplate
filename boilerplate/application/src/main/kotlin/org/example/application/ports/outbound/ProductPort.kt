package org.example.application.ports.outbound

import org.example.domain.entities.Product
import org.example.domain.enums.ProductName
import org.springframework.stereotype.Repository
import java.util.UUID

interface ProductPort {
    suspend fun add(product: Product): Product
    suspend fun getAll(): List<Product>
    suspend fun getById(id: UUID): Product?
    suspend fun getByName(name: ProductName): Product?
    suspend fun set(product: Product): Product
    suspend fun removeById(id: UUID) : Product?
}