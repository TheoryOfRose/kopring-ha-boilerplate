package org.example.application.services

import org.example.application.ports.inbound.CreateProductUseCase
import org.example.application.ports.inbound.ReadAllProductsUseCase
import org.example.application.ports.inbound.ReadProductByNameUseCase
import org.example.application.ports.outbound.ProductPort
import org.example.domain.entities.Product
import org.example.domain.enums.ProductName
import org.springframework.stereotype.Service

@Service
class ProductService(private val productPort: ProductPort) : CreateProductUseCase, ReadAllProductsUseCase, ReadProductByNameUseCase {
    override suspend fun execute(product: Product): Product {
        return productPort.add(product)
    }

    override suspend fun execute(): List<Product> {
        return productPort.getAll()
    }

    override suspend fun execute(name: ProductName): Product? {
        return productPort.getByName(name)
    }
}