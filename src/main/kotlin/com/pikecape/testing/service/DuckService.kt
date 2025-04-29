package com.pikecape.testing.service

import com.pikecape.testing.mapper.DuckMapper
import com.pikecape.testing.model.DuckDto
import com.pikecape.testing.repository.DuckEntity
import com.pikecape.testing.repository.DuckMongoRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.*

@Service
@RequiredArgsConstructor
class DuckService (private val repository: DuckMongoRepository) {
    val DUCK_NOT_FOUND = "Duck not found"

    fun findAll(): List<DuckDto> {
        return repository.findAll()
            .filterNotNull()
            .map { DuckMapper.toDto(it) }
    }

    fun findById(uid: UUID): DuckDto? {
        val duck = repository.findById(uid)

        if (duck.isEmpty) {
            throw RuntimeException (DUCK_NOT_FOUND)
        }

        return DuckMapper.toDto(duck.get())
    }

    fun create(duck: DuckDto): DuckDto {
        return DuckMapper.toDto(repository.save(DuckMapper.toEntity(duck)))
    }

    fun update(uid: UUID, duck: DuckEntity): DuckEntity {
        repository.findById(uid)
            .orElseThrow({ RuntimeException(DUCK_NOT_FOUND) })

        return repository.save<DuckEntity>(duck)
    }

    fun deleteByUid(uid: UUID) {
        repository.findById(uid).ifPresent { repository.delete(it) }
    }
}

