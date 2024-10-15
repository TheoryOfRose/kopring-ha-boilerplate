package org.example.adapter.inbound.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/health")
class HealthController {

    @GetMapping
    suspend fun healthCheck(): ResponseEntity<String> {
        return ResponseEntity("OK", HttpStatus.OK)
    }
}