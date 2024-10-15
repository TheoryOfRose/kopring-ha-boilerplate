package org.example.adapter.inbound.rest.dto

import org.example.domain.entities.Product
import org.example.domain.enums.ProductName

data class ProductRequestDTO(
    val name: String
){
    fun toDomain() = Product(
        name = kotlin.runCatching { ProductName.fromValue(name) }.getOrElse {
            throw IllegalArgumentException("Invalid product name")
        }
    )
}

data class ProductResponseDTO(
    val id: String,
    val name: String
){
    constructor(product: Product) : this(
        id = product.id.toString(),
        name = product.name.value
    )
}