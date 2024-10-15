package org.example.domain.enums

enum class ProductName(
    val value: String
) {
    ECG_BUDDY("ECG Buddy");

    companion object {
        fun fromValue(value: String): ProductName {
            return entries.find { it.value == value }
                ?: throw IllegalArgumentException("Unknown value: $value")
        }
    }
}