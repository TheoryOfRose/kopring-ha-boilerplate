package org.example.adapter.inbound.rest

import kotlinx.coroutines.flow.asFlow
import org.example.adapter.inbound.rest.dto.ProductRequestDTO
import org.example.adapter.inbound.rest.dto.ProductResponseDTO
import org.example.application.ports.inbound.CreateProductUseCase
import org.example.application.ports.inbound.ReadAllProductsUseCase
import org.example.application.ports.inbound.ReadProductByNameUseCase
import org.example.domain.enums.ProductName
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val createProductUseCase: CreateProductUseCase,
    private val readAllProductsUseCase: ReadAllProductsUseCase,
    private val readProductByNameUseCase: ReadProductByNameUseCase
) {
    private val logger = LoggerFactory.getLogger(ProductController::class.java)

    @PostMapping
    suspend fun postProduct(@RequestBody requestDTO: ProductRequestDTO) : ResponseEntity<ProductResponseDTO> {
        logger.info("Received request to create product: $requestDTO")
        return ResponseEntity<ProductResponseDTO>(ProductResponseDTO(createProductUseCase.execute(requestDTO.toDomain())), HttpStatus.CREATED)
    }

    @GetMapping
    suspend fun getAllProducts() : List<ProductResponseDTO> {
        return readAllProductsUseCase.execute().map { ProductResponseDTO(it) }
    }

    @GetMapping("/{name}")
    suspend fun getProductByName(@PathVariable name: String) : ResponseEntity<ProductResponseDTO?> {
        return ResponseEntity<ProductResponseDTO?>(readProductByNameUseCase.execute(ProductName.fromValue(name))
            ?.let { ProductResponseDTO(it) }, HttpStatus.OK)
    }
}