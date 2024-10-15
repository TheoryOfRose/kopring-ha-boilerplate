package org.example.domain.entities

import org.example.domain.enums.ProductName
import java.util.UUID

data class Product(
    val id: UUID? = null,
    val name: ProductName = ProductName.ECG_BUDDY,
)
