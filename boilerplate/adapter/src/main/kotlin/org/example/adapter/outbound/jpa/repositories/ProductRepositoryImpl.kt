package org.example.adapter.outbound.jpa.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.example.adapter.outbound.jpa.interfaces.JpaProductRepository
import org.example.adapter.outbound.jpa.mappers.toDomain
import org.example.adapter.outbound.jpa.mappers.toEntity
import org.example.application.ports.outbound.ProductPort
import org.example.domain.entities.Product
import org.example.domain.enums.ProductName
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ProductRepositoryImpl(private val jpaProductRepository: JpaProductRepository) : ProductPort {
    override suspend fun add(product: Product): Product = withContext(Dispatchers.IO) {
        jpaProductRepository.save(product.toEntity()).toDomain()
    }

    override suspend fun getAll(): List<Product> = withContext(Dispatchers.IO) {
        println("ProductRepositoryImpl.getAll()")
        jpaProductRepository.findAll()
            .map { it.toDomain() }
    }

    override suspend fun getById(id: UUID): Product? = withContext(Dispatchers.IO) {
        jpaProductRepository.findById(id).orElse(null)?.toDomain()
    }

    override suspend fun getByName(name: ProductName): Product? = withContext(Dispatchers.IO) {
        jpaProductRepository.findByName(name.toEntity()).orElse(null)?.toDomain()
    }

    override suspend fun set(product: Product): Product = withContext(Dispatchers.IO) {
        jpaProductRepository.save(product.toEntity()).toDomain()
    }

    override suspend fun removeById(id: UUID): Product? = withContext(Dispatchers.IO) {
        var entity = jpaProductRepository.findById(id).orElse(null)?.toDomain()
        jpaProductRepository.deleteById(id)
        return@withContext entity
    }
}