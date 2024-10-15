package org.example.adapter.outbound.jpa.mappers

import org.example.adapter.outbound.jpa.entities.ProductEntity
import org.example.adapter.outbound.jpa.enums.ProductNameEntity
import org.example.domain.entities.Product
import org.example.domain.enums.ProductName

fun ProductNameEntity.toDomain() : ProductName = when(this) {
    ProductNameEntity.ECG_BUDDY -> ProductName.ECG_BUDDY
}

fun ProductName.toEntity() : ProductNameEntity = when(this) {
    ProductName.ECG_BUDDY -> ProductNameEntity.ECG_BUDDY
}

fun ProductEntity.toDomain() : Product = Product(
    id = this.id,
    name = this.name.toDomain()
)

fun Product.toEntity() : ProductEntity = ProductEntity(
    id = this.id,
    name = this.name.toEntity()
)