package com.pikecape.testing.controller

import com.pikecape.testing.model.DuckDto
import com.pikecape.testing.repository.DuckEntity
import com.pikecape.testing.service.DuckService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/ducks")
@RequiredArgsConstructor
class DuckController (private val service: DuckService) {

    @GetMapping
    fun findAll(): List<DuckDto?> {
        return service.findAll()
    }

    @GetMapping("/{uid}")
    fun findById(@PathVariable uid: UUID): DuckDto? {
        return service.findById(uid)
    }

    @PostMapping
    fun create(@RequestBody duck: DuckDto): DuckDto {
        return service.create(duck)
    }

    @PutMapping("/{uid}")
    fun update(
        @PathVariable uid: UUID,
        @RequestBody duck: DuckEntity
    ): DuckEntity {
        return service.update(uid, duck)
    }

    @DeleteMapping("/{uid}")
    fun delete(@PathVariable uid: UUID) {
        service.deleteByUid(uid)
    }
}

