package com.pikecape.testing.mapper

import com.pikecape.testing.model.DuckDto
import com.pikecape.testing.repository.DuckEntity

object DuckMapper {
    fun toDto(entity: DuckEntity): DuckDto {
        return DuckDto(
            uid = entity.uid,
            name = entity.name
        )

    }

    fun toEntity(dto: DuckDto): DuckEntity {
        return DuckEntity(
            uid = dto.uid,
            name = dto.name
        )
    }
}
